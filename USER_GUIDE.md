# 📱 User Guide - Aplikasi Pendaftaran Seminar

## 🎯 Panduan Penggunaan Aplikasi

### Halaman 1: Login

**Tampilan:**
- Header dengan brand "SeminarHub Kampus"
- Form login dengan input Username & Password
- Button "Masuk" untuk login
- Button "Belum punya akun? Register" untuk pindah ke mode register

**Cara Gunakan:**
1. Masukkan username: `mahasiswa`
2. Masukkan password: `12345`
3. Tap tombol "Masuk"
4. Tunggu 1-2 detik, aplikasi akan membawa Anda ke Dashboard

**Tips:**
- ❌ Jangan lupa username & password
- ❌ Password case-sensitive
- ✅ Gunakan username & password yang sudah terdaftar

---

### Halaman 2: Register (Optional)

**Jika ingin membuat akun baru:**

1. Tap tombol "Belum punya akun? Register"
2. Tampilan form akan berubah:
   - Password field akan muncul input "Konfirmasi Password"
   - Button berubah menjadi "Daftar"
   - Link berubah menjadi "Sudah punya akun? Login"

3. **Isi form:**
   - Username: minimal 4 karakter
   - Password: minimal 4 karakter
   - Konfirmasi Password: harus sama dengan password

4. **Tap tombol "Daftar"**
   - Jika sukses: muncul pesan "Registrasi berhasil, silakan login"
   - Form kembali ke mode login
   - Gunakan username/password baru untuk login

**Validasi yang dilakukan:**
- ❌ Username < 4 karakter → error
- ❌ Password < 4 karakter → error
- ❌ Konfirmasi password tidak sama → error
- ❌ Username sudah terdaftar → error

---

### Halaman 3: Dashboard Beranda

**Setelah login berhasil, Anda masuk ke halaman Beranda**

**Konten yang ditampilkan:**
- 🎉 Welcome card: "Selamat Datang!"
- 👋 Greeting: "Halo, [username]"
- 📚 Info section: tentang seminar yang tersedia
- ✅ Feature highlights: 3 fitur utama aplikasi
- 🔘 Button "Mulai Pendaftaran" (warna ungu/primary)
- 🔴 Button "Logout" (outline, warna merah)

**Navigation Bar (di bawah):**
- 🏠 Beranda (current)
- 📝 Daftar
- 📋 Hasil

**Aksi:**
- Tap "Mulai Pendaftaran" → ke halaman Form
- Tap "📝 Daftar" di navbar → ke halaman Form
- Tap "📋 Hasil" di navbar → ke halaman Hasil
- Tap "Logout" → kembali ke Login

---

### Halaman 4: Form Pendaftaran Seminar

**Lokasi:** Tab "📝 Daftar" di navigation bar

**Form Fields:**

#### 1. Nama Lengkap
- Type: Text input
- Icon: 👤 Person
- Placeholder: "Nama Lengkap"
- Validasi: Tidak boleh kosong
- Error: "Nama lengkap wajib diisi"

#### 2. Email
- Type: Email input
- Icon: ✉️ Email
- Placeholder: "Email"
- Validasi: Format valid + tidak kosong
- Error: "Email tidak valid" atau "Email wajib diisi"
- Contoh: `mahasiswa@email.com`

#### 3. Nomor Telepon
- Type: Phone input
- Icon: ☎️ Phone
- Placeholder: "Nomor Telepon"
- Validasi: Format 08xxxxxxxxxx (11-12 digit total)
- Error: "Nomor telepon tidak valid"
- Contoh: `081234567890`

#### 4. Jenis Kelamin
- Type: Radio buttons (horizontal)
- Options: "Laki-laki" | "Perempuan"
- Validasi: Harus dipilih salah satu
- Error (if not selected): "Jenis kelamin wajib dipilih"

#### 5. Pilih Seminar
- Type: Dropdown/Spinner
- Default: "-- Pilih Seminar --"
- Options:
  1. Seminar Android Modern
  2. Seminar AI untuk Mahasiswa
  3. Seminar UI/UX Product Design
  4. Seminar Public Speaking
  5. Seminar Career Preparation
- Validasi: Tidak boleh default option
- Error: "Seminar wajib dipilih"

#### 6. Persetujuan
- Type: Checkbox
- Label: "Saya setuju dengan syarat dan ketentuan"
- Validasi: Harus dicentang
- Error: "Anda harus setuju dengan syarat dan ketentuan"

#### 7. Submit Button
- Label: "Kirim Pendaftaran"
- Color: Ungu/Primary
- Icon: 📤 Send

**Cara Mengisi Form:**

1. **Masukkan Nama:**
   - Contoh: "Ahmad Rafif"
   - Validasi real-time muncul saat ketik

2. **Masukkan Email:**
   - Contoh: "ahmad@example.com"
   - Harus ada @ dan domain

3. **Masukkan Telepon:**
   - Contoh: "081234567890"
   - Mulai dengan 08, total 11-12 digit

4. **Pilih Jenis Kelamin:**
   - Tap salah satu radio button

5. **Pilih Seminar:**
   - Tap dropdown
   - Pilih salah satu seminar (tidak default)

6. **Centang Persetujuan:**
   - Tap checkbox

7. **Tap Tombol "Kirim Pendaftaran":**
   - Dialog konfirmasi akan muncul
   - "Pastikan semua data sudah benar sebelum mengirim"
   - Tap "Ya, Kirim" untuk lanjut
   - Tap "Batal" untuk kembali edit

**Jika Ada Error:**
- Setiap field akan menampilkan error message
- Error berubah real-time saat Anda edit
- Fix error kemudian submit ulang

---

### Halaman 5: Hasil Pendaftaran

**Setelah submit berhasil, Anda akan diarahkan ke halaman Hasil**

**Konten yang ditampilkan:**

1. **Header Sukses** (hijau)
   - ✓ Checkmark besar
   - "Pendaftaran Berhasil! 🎉"
   - "Pendaftaran Diterima"

2. **Detail Pendaftaran** (card)
   - Nama: [data yang diinput]
   - Email: [data yang diinput]
   - Telepon: [data yang diinput]
   - Jenis Kelamin: [pilihan]
   - Seminar: [pilihan]

3. **Info Box**
   - "Pendaftaran Anda telah berhasil dicatat"
   - "Silakan cek email untuk konfirmasi"

4. **Button "Kembali ke Beranda"**
   - Warna: Ungu/Primary
   - Tap untuk kembali ke halaman Beranda

**Yang Bisa Dilakukan:**
- ✅ Lihat ringkasan data yang didaftar
- ✅ Tap "Kembali ke Beranda" untuk home
- ✅ Tap "📝 Daftar" untuk daftar seminar lagi (baru)
- ✅ Tap "Logout" untuk keluar

---

## 🔐 Akun Demo

### Akun Sudah Ada:

```
Akun 1:
Username: mahasiswa
Password: 12345

Akun 2:
Username: admin
Password: admin123
```

### Buat Akun Baru:

Contoh membuat akun baru:
```
Username: student1
Password: password123
Konfirmasi: password123
```

---

## ⚠️ Error Messages & Solusi

### Login Page

| Error | Penyebab | Solusi |
|-------|---------|--------|
| "Username dan password wajib diisi" | Field kosong | Isi kedua field |
| "Login gagal, username/password tidak cocok" | Data salah | Cek username/password, gunakan demo credentials |
| "Username minimal 4 karakter" | (saat register) | Gunakan username minimal 4 huruf |
| "Password minimal 4 karakter" | (saat register) | Gunakan password minimal 4 karakter |
| "Konfirmasi password tidak sama" | (saat register) | Pastikan konfirmasi = password |
| "Username sudah terdaftar" | (saat register) | Gunakan username lain |

### Form Pendaftaran

| Error | Penyebab | Solusi |
|-------|---------|--------|
| "Nama lengkap wajib diisi" | Field kosong | Isi nama |
| "Email wajib diisi" | Field kosong | Isi email |
| "Email tidak valid" | Format salah | Gunakan format: nama@domain.com |
| "Nomor telepon wajib diisi" | Field kosong | Isi nomor telepon |
| "Nomor telepon tidak valid" | Format salah | Gunakan format 08xxxxxxxxxx (11-12 digit) |
| "Jenis kelamin wajib dipilih" | Tidak dipilih | Tap salah satu radio button |
| "Seminar wajib dipilih" | Pilih default | Buka dropdown dan pilih seminar |
| "Anda harus setuju dengan syarat" | Checkbox tidak dicentang | Centang checkbox persetujuan |

---

## 💡 Tips & Trik

### Login Page
- ✅ Gunakan credentials demo untuk testing cepat
- ✅ Buat akun baru jika ingin test register
- ✅ Password case-sensitive, pastikan caps lock off

### Home Page
- ✅ Baca info tentang fitur aplikasi
- ✅ Tap "Mulai Pendaftaran" untuk langsung ke form
- ✅ Tap navigation bar untuk pindah halaman

### Form Page
- ✅ Isi semua field sebelum submit
- ✅ Lihat real-time validation saat ketik
- ✅ Gunakan format telepon yang benar: 08xxxxxxxxxx
- ✅ Centang persetujuan di bagian bawah form

### Result Page
- ✅ Lihat ringkasan data Anda
- ✅ Tap "Kembali ke Beranda" untuk home
- ✅ Tap "Daftar" untuk input data baru (akan menimpa data sebelumnya)

---

## 🎨 UI Elements

### Colors
- 🟣 Ungu (#5B57F3): Primary buttons, headers
- 🟦 Biru muda (#A6C8FF): Background gradient
- 🟢 Hijau (#10B981): Success state
- 🔴 Merah (#EF4444): Error, logout button
- ⚪ Putih (#FFFFFF): Card background

### Buttons
- **Primary (Ungu)**: Main action buttons
- **Outline (Gray)**: Secondary buttons
- **Tertiary (Text)**: Link buttons

### Icons
- 📧 Email input
- ☎️ Telepon input
- 👤 Nama input
- 🎓 Info section
- 🏆 Networking highlight
- ✅ Validation passed

---

## 📝 Contoh Mengisi Form

**Skenario: Anda adalah Rafif dari Teknik Informatika**

1. **Nama Lengkap:**
   ```
   Rafif Muhammad Hafizh
   ```

2. **Email:**
   ```
   rafif@universitas.ac.id
   ```

3. **Nomor Telepon:**
   ```
   081234567890
   ```

4. **Jenis Kelamin:**
   ```
   ✓ Laki-laki
   ```

5. **Pilih Seminar:**
   ```
   Seminar Android Modern
   ```

6. **Persetujuan:**
   ```
   ✓ Saya setuju dengan syarat dan ketentuan
   ```

7. **Tap "Kirim Pendaftaran"**

8. **Lihat ringkasan di halaman Hasil**

---

## 🚀 Keyboard Shortcuts (Untuk testing)

| Aksi | Keyboard |
|------|----------|
| Focus next field | Tab |
| Toggle radio/checkbox | Space |
| Submit form | Enter (saat di button) |

---

## 📱 Responsive Behavior

Aplikasi dirancang untuk:
- ✅ Phone portrait (320dp - 600dp)
- ✅ Phone landscape (600dp - 1200dp)
- ✅ Tablet (1200dp+)
- ✅ Bottom navigation auto-hide pada landscape

---

## 🔄 App Flow Summary

```
Start → Login/Register
         ↓ (success)
       Dashboard (Home)
       ├── 📝 Go to Form
       ├── 📋 View Result
       └── Logout
         
Form Page
├── Fill all fields ✓
├── Real-time validation
└── Submit → Result Page
        ↓
Result Page
├── View summary
├── Go back home
└── Fill new registration
```

---

**Version:** 1.0  
**Last Updated:** April 2025  
**Language:** Bahasa Indonesia / English mix

