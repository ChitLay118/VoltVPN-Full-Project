# VoltVPN Project for AIDE

ဒီ project က AIDE (Android IDE) နဲ့ build လို့ရအောင် ပြင်ဆင်ထားတဲ့ project ဖြစ်ပါတယ်။

## ပါဝင်တဲ့ဖိုင်များ
- `app/src/main/assets/index.html`: သင်ပေးထားတဲ့ UI source ကို WebView နဲ့ အလုပ်လုပ်အောင် ပြင်ဆင်ထားပါတယ်။
- `MainActivity.java`: UI နဲ့ Android System ကို ချိတ်ဆက်ပေးတဲ့ နေရာပါ။
- `MyVpnService.java`: VPN ရဲ့ အဓိက အလုပ်လုပ်တဲ့ နေရာပါ။

## VPN တကယ်အလုပ်လုပ်ဖို့ လိုအပ်ချက်များ
VPN တစ်ခု တကယ်အလုပ်လုပ်ဖို့အတွက် အောက်ပါတို့ လိုအပ်ပါတယ်-
1. **VPN Server**: သင်ချိတ်ဆက်မယ့် server (V2Ray, OpenVPN, သို့မဟုတ် WireGuard) ရှိရပါမယ်။
2. **Core Library**: AIDE မှာ build တဲ့အခါ core library တွေကို `libs/` folder ထဲမှာ ထည့်ပေးရပါမယ်။
   - ဥပမာ- V2Ray အတွက်ဆိုရင် `libv2ray.so` ဖိုင်တွေ လိုအပ်ပါတယ်။

## AIDE မှာ အသုံးပြုနည်း
1. ဒီ zip ဖိုင်ကို ဖြည်လိုက်ပါ။
2. AIDE ကိုဖွင့်ပြီး `VoltVPN` folder ကို project အနေနဲ့ open လုပ်ပါ။
3. Build & Run လုပ်လိုက်ရင် UI အတိုင်း APK ထွက်လာပါလိမ့်မယ်။

**မှတ်ချက်**: လက်ရှိ code က UI နဲ့ VPN Service ချိတ်ဆက်မှုကိုသာ ပြသထားတာဖြစ်ပြီး၊ server configuration တွေကိုတော့ `MyVpnService.java` မှာ ထပ်ဖြည့်ပေးဖို့ လိုအပ်ပါတယ်။
