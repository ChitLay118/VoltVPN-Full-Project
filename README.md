# VoltVPN Full Project (AIDE Compatible)

ဒီ Project က UI အပြည့်အစုံ၊ V2Ray Core SDK နဲ့ Native Libraries တွေ အားလုံး ပါဝင်ပြီးသား ဖြစ်ပါတယ်။ သင်က Config တစ်ခုတည်း ထည့်ရုံနဲ့ တကယ်အလုပ်လုပ်မှာပါ။

## ပါဝင်သော အစိတ်အပိုင်းများ
- **UI**: `assets/index.html` (Modern Material Design)
- **Core SDK**: `libs/libv2ray.aar` (V2Ray/Xray Core)
- **Native Libs**: `jniLibs/` (arm64-v8a, armeabi-v7a, x86, x86_64)
- **Config Update**: GitHub Raw Link ကနေ `config.json` ကို အလိုအလျောက် Update လုပ်ပေးပါတယ်။

## အသုံးပြုနည်း
1. AIDE မှာ Project ကို ဖွင့်ပါ။
2. `MainActivity.java` ထဲက `githubConfigUrl` နေရာမှာ သင့်ရဲ့ GitHub Raw Link ကို ထည့်ပါ။
3. Build & Run လုပ်ပါ။

## Config ပုံစံ
သင့်ရဲ့ GitHub မှာ တင်မယ့် `config.json` က အောက်ပါအတိုင်း ဖြစ်ရပါမယ်-
```json
{
  "server": "your-server-ip",
  "port": 443,
  "id": "your-uuid",
  "aid": 0,
  "net": "ws",
  "path": "/v2ray",
  "type": "none",
  "host": "your-host",
  "tls": "tls"
}
```

ဒီ Project က အပြီးအစီးဖြစ်လို့ ဘာမှ ထပ်ရှာစရာမလိုတော့ပါဘူး။
