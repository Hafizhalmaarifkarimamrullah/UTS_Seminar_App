# 🚀 QUICK START GUIDE - Run Aplikasi

## 🎯 Cara Menjalankan Aplikasi

### Option 1: Via Android Studio (Recommended)

#### Step 1: Buka Project
1. Buka Android Studio
2. File → Open
3. Navigasi ke folder: `C:\Users\Hafizh Al ma'arif\AndroidStudioProjects\UTS`
4. Klik "Open"

#### Step 2: Sync Gradle
1. Android Studio akan otomatis mulai sync
2. Tunggu sampai selesai (lihat progress bar di bawah)
3. Jika tidak otomatis, tekan: `Ctrl + Alt + Shift + S` → Sync Now

#### Step 3: Pilih Emulator/Device
1. Di toolbar, cari dropdown yang bertuliskan nama emulator
2. Jika belum ada emulator, klik "Create Virtual Device"
3. Atau koneksikan physical device via USB

#### Step 4: Run Aplikasi
1. Tekan tombol "Run" (tombol play ▶️) di toolbar
2. Atau gunakan keyboard shortcut: `Shift + F10`
3. Pilih emulator/device dari dialog yang muncul
4. Klik "OK"

#### Step 5: Tunggu Build & Install
1. Build akan berjalan (lihat progress di "Build" panel)
2. APK akan di-install ke emulator/device
3. Aplikasi akan auto-launch setelah install selesai

---

### Option 2: Via Terminal/Command Prompt

#### Persiapan
```powershell
# Navigate ke project folder
cd "C:\Users\Hafizh Al ma'arif\AndroidStudioProjects\UTS"
```

#### Build APK
```powershell
# Build debug APK
.\gradlew.bat assembleDebug

# Hasil APK:
# app\build\outputs\apk\debug\app-debug.apk
```

#### Install ke Emulator
```powershell
# Pastikan emulator sedang berjalan atau device terhubung

# Install APK
.\gradlew.bat installDebug

# Launch aplikasi
adb shell am start -n com.example.uts/.MainActivity
```

#### Build & Run (Shortcut)
```powershell
# Build dan langsung run
.\gradlew.bat installDebugRun
```

---

## 📱 Emulator Setup (Jika belum ada)

### Create Virtual Device via Android Studio
1. Tools → Device Manager
2. Klik "+ Create Device"
3. Pilih device (e.g., "Pixel 5")
4. Klik "Next"
5. Pilih API 31-36 (recommended: API 33 atau 34)
6. Klik "Next" → Finish
7. Device akan di-list, klik play button untuk jalankan

### Atau via Terminal
```powershell
# List available emulators
emulator -list-avds

# Start emulator (contoh)
emulator -avd Pixel_5_API_33
```

---

## 🔑 Test Credentials

Gunakan salah satu akun ini untuk login:

### Akun 1 (Student)
```
Username: mahasiswa
Password: 12345
```

### Akun 2 (Admin)
```
Username: admin
Password: admin123
```

### Atau Buat Akun Baru
1. Di login screen, tap "Belum punya akun? Register"
2. Isi username, password, dan konfirmasi
3. Tap "Daftar"
4. Login dengan akun baru yang dibuat

---

## 🧪 Testing Flow

### Test Case 1: Complete Flow
```
1. Login dengan: mahasiswa / 12345
2. Di beranda, tap "Mulai Pendaftaran"
3. Isi form dengan data:
   - Nama: Ahmad Rafif
   - Email: rafif@example.com
   - Telepon: 081234567890
   - Jenis Kelamin: Laki-laki
   - Seminar: Seminar Android Modern
   - Centang persetujuan
4. Tap "Kirim Pendaftaran"
5. Tap "Ya, Kirim" di konfirmasi
6. Lihat hasil di halaman Hasil
7. Tap "Kembali ke Beranda"
8. Tap Logout
```

### Test Case 2: Validation Testing
```
1. Login dengan: mahasiswa / 12345
2. Tap "Mulai Pendaftaran"
3. Coba submit form kosong → lihat error messages
4. Isi email dengan format salah → lihat error
5. Isi telepon dengan format salah (misal 123456) → lihat error
6. Tap seminar tapi pilih default → lihat error
7. Tap submit tanpa centang persetujuan → lihat error
```

### Test Case 3: Register Testing
```
1. Tap "Belum punya akun? Register"
2. Coba register dengan username < 4 karakter → error
3. Coba register dengan password < 4 karakter → error
4. Coba register dengan password tidak match → error
5. Isi dengan data valid:
   - Username: student1
   - Password: password123
   - Confirm: password123
6. Tap Daftar
7. Login dengan akun baru: student1 / password123
```

---

## ⚠️ Troubleshooting

### Build Error
```
Problem: "ERROR: [something]"

Solution:
1. Klik "Clean Project" (Build menu)
2. Klik "Rebuild Project"
3. Jika masih error, buka terminal:
   .\gradlew.bat clean
   .\gradlew.bat build
```

### Emulator Not Starting
```
Problem: Emulator tidak mau start

Solution:
1. Buka Device Manager
2. Klik tombol "..." → "Wipe Data"
3. Klik tombol "▶️ Play" untuk start
4. Tunggu 30-60 detik sampai emulator fully loaded
```

### App Crash
```
Problem: Aplikasi crash setelah install

Solution:
1. Lihat logcat (View → Tool Windows → Logcat)
2. Cari error message (biasanya berwarna merah)
3. Screenshot error message
4. Buka issue atau tanya di forum
```

### Cannot Find Device
```
Problem: "No connected devices"

Solution:
1. Pastikan emulator running (di Device Manager)
2. Atau hubungkan physical device via USB
3. Enable USB Debugging di device:
   Settings → Developer Options → USB Debugging
4. Terima permission dialog di device
```

---

## 📊 Build Information

```
Project Name:       UTS
Package Name:       com.example.uts
Min SDK:            31
Target SDK:         36
Compile SDK:        36.1
Kotlin Version:     Latest
Gradle Version:     9.2.1
```

---

## 🔍 Debugging Tips

### Lihat Logs
```powershell
# Show all logcat
adb logcat

# Filter by app
adb logcat | findstr "UTS|EXAMPLE"

# Via Android Studio: View → Tool Windows → Logcat
```

### Check Device Connection
```powershell
# List connected devices
adb devices

# Install APK manually
adb install app\build\outputs\apk\debug\app-debug.apk
```

### Uninstall App
```powershell
adb uninstall com.example.uts
```

---

## 📁 Important Paths

```
Project Root:        C:\Users\Hafizh Al ma'arif\AndroidStudioProjects\UTS
Source Code:         app\src\main\java\com\example\uts\
Resources:           app\src\main\res\
Layouts:             app\src\main\res\layout\
Drawable:            app\src\main\res\drawable\
Values (strings):    app\src\main\res\values\
Debug APK:           app\build\outputs\apk\debug\app-debug.apk
```

---

## ✅ Success Indicators

Aplikasi berhasil dijalankan jika:
- ✅ Login screen muncul dengan sempurna
- ✅ Background gradient terlihat
- ✅ Input fields responsif
- ✅ Bisa login dengan mahasiswa/12345
- ✅ Dashboard beranda tampil
- ✅ Navigation bottom bar berfungsi
- ✅ Form validation bekerja
- ✅ Tidak ada error di logcat

---

## 🎯 Next Steps

Setelah aplikasi berjalan:

1. **Coba Test Credentials**
   - Login dengan mahasiswa / 12345

2. **Explore Features**
   - Navigasi ke halaman berbeda
   - Cek validation pada form
   - Lihat result page

3. **Check Code**
   - Buka MainActivity.kt
   - Lihat logic di SeminarFormFragment.kt
   - Explore layout XML files

4. **Modify & Experiment**
   - Ubah warna di colors.xml
   - Tambah seminar baru di SeminarFormFragment
   - Eksperimen dengan UI elements

---

## 📞 Common Questions

### Q: Berapa lama build pertama kali?
**A:** 1-3 menit, tergantung kecepatan mesin. Build berikutnya lebih cepat.

### Q: Emulator butuh berapa GB RAM?
**A:** Minimum 2GB, recommended 4-6GB.

### Q: Bisa run di physical device?
**A:** Ya, hubungkan via USB dan enable USB Debugging.

### Q: APK berapa ukuran?
**A:** Sekitar 5-10 MB untuk debug APK.

### Q: Bisa run di iOS?
**A:** Tidak, ini hanya untuk Android.

---

## 🎓 Learning Resources

Jika ingin pelajari lebih lanjut:

### Android Development
- https://developer.android.com/
- https://developer.android.com/docs

### Material Design 3
- https://m3.material.io/
- https://developer.android.com/design

### Kotlin
- https://kotlinlang.org/
- https://developer.android.com/kotlin

### Gradle
- https://gradle.org/
- https://developer.android.com/build

---

## 📝 Notes

- Aplikasi menggunakan hardcoded data (tidak menggunakan database)
- Semua data akan hilang jika app ditutup
- Untuk production, gunakan database seperti Room atau Firebase
- Source code dapat dimodifikasi sesuai kebutuhan

---

**Last Updated**: April 14, 2025  
**Version**: 1.0.0  
**Status**: ✅ Ready to Run

