package com.voltvpn.app;

import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends Activity {
    private WebView webView;
    private static final int VPN_REQUEST_CODE = 0x0F;
    private String githubConfigUrl = "https://raw.githubusercontent.com/YOUR_USERNAME/YOUR_REPO/main/config.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        
        webView.addJavascriptInterface(new WebAppInterface(), "Android");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/index.html");

        // Update config from GitHub on start
        new UpdateConfigTask().execute(githubConfigUrl);
    }

    public class WebAppInterface {
        @JavascriptInterface
        public void toggleVpn() {
            Intent intent = VpnService.prepare(MainActivity.this);
            if (intent != null) {
                startActivityForResult(intent, VPN_REQUEST_CODE);
            } else {
                onActivityResult(VPN_REQUEST_CODE, RESULT_OK, null);
            }
        }
    }

    private class UpdateConfigTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) sb.append(line);
                in.close();
                return sb.toString();
            } catch (Exception e) {
                Log.e("VoltVPN", "Config update failed", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
                // Save config to local storage or pass to VPN service
                Log.d("VoltVPN", "Config updated: " + result);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == VPN_REQUEST_CODE && resultCode == RESULT_OK) {
            Intent intent = new Intent(this, MyVpnService.class);
            intent.setAction("START");
            startService(intent);
            
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl("javascript:updateStatus('connected', '00:00:01', '1.1.1.1')");
                }
            });
        }
    }
}
