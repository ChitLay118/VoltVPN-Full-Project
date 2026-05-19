package com.voltvpn.app;

import android.content.Intent;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import android.util.Log;

public class MyVpnService extends VpnService {
    private ParcelFileDescriptor vpnInterface = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && "START".equals(intent.getAction())) {
            startVpn();
        }
        return START_STICKY;
    }

    private void startVpn() {
        Builder builder = new Builder();
        try {
            // This is a basic setup. For a real VPN, you need to route traffic to a server.
            vpnInterface = builder.setSession("VoltVPN")
                    .addAddress("10.0.0.2", 24)
                    .addDnsServer("8.8.8.8")
                    .addRoute("0.0.0.0", 0)
                    .establish();
            Log.d("VoltVPN", "VPN Started");
        } catch (Exception e) {
            Log.e("VoltVPN", "Error starting VPN", e);
        }
    }

    @Override
    public void onDestroy() {
        if (vpnInterface != null) {
            try {
                vpnInterface.close();
            } catch (Exception e) {
                Log.e("VoltVPN", "Error closing VPN", e);
            }
        }
        super.onDestroy();
    }
}
