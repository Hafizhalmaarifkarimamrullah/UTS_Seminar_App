# UTS - Login/Register + Pendaftaran Seminar Mahasiswa

link video : https://youtu.be/V-aar7haPUE

Aplikasi Android modern untuk manajemen pendaftaran seminar mahasiswa dengan alur:

1. **Login / Register** → Autentikasi user (data hardcode)
2. **Dashboard** → Tampilan utama setelah login berhasil
3. **Form Pendaftaran Seminar** → Isi data dan pilih seminar
4. **Hasil Pendaftaran** → Ringkasan data yang telah didaftar

## 🎨 Desain & UI

- **Material Design 3** dengan warna gradient modern
- **Color Scheme**: Ungu (#5B57F3) + Teal (#26A69A) + Biru muda (#A6C8FF)
- **Responsive Layout** dengan card-based design
- **Proper Spacing & Padding** untuk UX yang nyaman
- **Icon & Visual Elements** untuk setiap section
- **Bottom Navigation** untuk navigasi antar fragment

## 👤 Data User (Hardcoded)

```
Username: mahasiswa
Password: 12345

Username: admin  
Password: admin123
```

## 📋 Data Seminar (Hardcoded)

1. Seminar Android Modern
2. Seminar AI untuk Mahasiswa
3. Seminar UI/UX Product Design
4. Seminar Public Speaking
5. Seminar Career Preparation

## 📁 Struktur Project

```
app/src/main/
├── java/com/example/uts/
│   ├── MainActivity.kt           (Login/Register)
│   ├── DashboardActivity.kt      (Main container)
│   ├── HomeFragment.kt           (Beranda)
│   ├── SeminarFormFragment.kt    (Form pendaftaran)
│   ├── ResultFragment.kt         (Hasil pendaftaran)
│   ├── AppSession.kt             (Global session)
│   └── SeminarRegistration.kt    (Data class)
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── activity_dashboard.xml
│   │   ├── fragment_home.xml
│   │   ├── fragment_form.xml
│   │   └── fragment_result.xml
│   ├── drawable/
│   │   ├── bg_gradient.xml       (Gradient background)
│   │   └── spinner_bg.xml        (Spinner styling)
│   ├── color/
│   │   └── bottom_nav_selector.xml
│   ├── menu/
│   │   └── bottom_nav_menu.xml
│   ├── values/
│   │   ├── colors.xml
│   │   ├── strings.xml
│   │   └── themes.xml
│   └── mipmap/                   (App icons)
└── AndroidManifest.xml
```

## ✨ Fitur Utama

### 1. Login & Register
- ✅ Validasi username minimal 4 karakter
- ✅ Validasi password minimal 4 karakter
- ✅ Konfirmasi password saat register
- ✅ Deteksi duplikasi username
- ✅ Toggle password visibility

### 2. Home (Beranda)
- ✅ Welcome message dengan nama user
- ✅ Info tentang seminar yang tersedia
- ✅ CTA button untuk mulai pendaftaran
- ✅ Fitur logout dengan konfirmasi

### 3. Form Pendaftaran
- ✅ Input nama lengkap
- ✅ Input email dengan validasi
- ✅ Input nomor telepon (format 08xxxxxxxxxx)
- ✅ Pilih jenis kelamin (Radio button)
- ✅ Pilih seminar dari dropdown
- ✅ Checkbox persetujuan syarat & ketentuan
- ✅ Real-time validation dengan error messages
- ✅ Konfirmasi sebelum submit

### 4. Hasil Pendaftaran
- ✅ Tampilan lengkap semua data yang didaftar
- ✅ Status berhasil dengan visual sukses
- ✅ Opsi kembali ke beranda

### 5. Navigation
- ✅ Bottom Navigation untuk 3 section
- ✅ Fragment-based navigation
- ✅ Smooth transitions antar screen

## 🛠️ Teknologi

- **Bahasa**: Kotlin
- **Build System**: Gradle KTS
- **Minimum SDK**: 31
- **Target SDK**: 36
- **Libraries**: 
  - AndroidX (core-ktx, appcompat, activity, constraintlayout)
  - Material Design 3
  - Fragment API

## 🚀 Cara Menjalankan

### Via Android Studio
1. Buka project di Android Studio
2. Sync Gradle files
3. Pilih emulator atau device
4. Klik tombol "Run" atau tekan Shift + F10

### Via Terminal
```bash
# Build project
.\gradlew.bat build

# Run di emulator (harus ada AVD yang berjalan)
.\gradlew.bat installDebug
adb shell am start -n com.example.uts/.MainActivity
```

## 📝 Validasi Input

| Field | Validasi |
|-------|----------|
| Username | Min 4 karakter, unik |
| Password | Min 4 karakter |
| Nama | Tidak boleh kosong |
| Email | Format valid & tidak kosong |
| Telepon | Format 08xxxxxxxxxx (11-12 digit) |
| Jenis Kelamin | Harus dipilih |
| Seminar | Harus dipilih (tidak default) |
| Persetujuan | Harus dicentang |

## 🎯 UX/UI Highlights

1. **Visual Hierarchy**: Heading jelas, typography konsisten
2. **Color Consistency**: Menggunakan color palette yang harmonis
3. **Spacing & Padding**: Margin dan padding yang rapi (12dp, 16dp, 20dp)
4. **Icons**: Menggunakan system icons untuk clarity
5. **Button States**: Material buttons dengan proper elevation
6. **Input Fields**: Text input layout dengan background color, corner radius, start/end icon
7. **Error States**: Error messages yang jelas dan helpful
8. **Success States**: Visual feedback yang memuaskan saat berhasil

## 🔐 Session Management

Session user disimpan di `AppSession` object singleton:
```kotlin
object AppSession {
    var currentUsername: String = ""
    var latestRegistration: SeminarRegistration? = null
}
```

## 📱 Responsive Design

- Aplikasi menggunakan ConstraintLayout & LinearLayout dengan weight
- ScrollView untuk content yang panjang
- Proper insets handling dengan edge-to-edge display
- Bottom padding extra untuk bottom navigation

## 🐛 Notes

- Data tidak disimpan secara persisten (akan hilang saat app ditutup)
- Untuk production, gunakan database seperti Room atau Firebase
- Semua data user & seminar bersifat demo/hardcoded

---

**Author**: Hafizh Al ma'arif  
**Date**: April 2025  
**Status**: ✅ Complete & Ready for Submission
