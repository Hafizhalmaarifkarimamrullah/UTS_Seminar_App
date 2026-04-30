# 📖 Dokumentasi Teknis - Aplikasi Pendaftaran Seminar

## 1. Deskripsi Project

Aplikasi Android untuk manajemen pendaftaran seminar mahasiswa dengan fitur:
- Autentikasi user (login/register)
- Dashboard beranda
- Form pendaftaran seminar dengan validasi lengkap
- Tampilan hasil pendaftaran
- Session management

---

## 2. Architecture & Flow

```
MainActivity (Login/Register)
         ↓ (Login berhasil)
DashboardActivity (Container dengan Fragment)
    ├─ HomeFragment (Beranda)
    ├─ SeminarFormFragment (Form Pendaftaran)
    └─ ResultFragment (Hasil Pendaftaran)
         ↓ (Logout)
MainActivity (Kembali ke Login)
```

---

## 3. Alur Aplikasi Lengkap

### Step 1: Login Screen (MainActivity)
- User melihat hero section dengan brand info
- Input username & password
- 2 button: "Masuk" dan "Belum punya akun? Register"

**User Data (Hardcoded)**:
```kotlin
private val users = mutableMapOf(
    "mahasiswa" to "12345",
    "admin" to "admin123"
)
```

### Step 2: Dashboard (DashboardActivity)
- Setelah login, user masuk ke Dashboard
- Berisi BottomNavigationView dengan 3 tab:
  1. 🏠 Beranda (HomeFragment)
  2. 📝 Daftar (SeminarFormFragment)
  3. 📋 Hasil (ResultFragment)

### Step 3: Beranda (HomeFragment)
Menampilkan:
- Welcome message: "Halo, [username] 👋"
- Informasi tentang seminar
- Fitur yang tersedia
- Button "Mulai Pendaftaran" → ke Form
- Button "Logout" → kembali ke Login

### Step 4: Form Pendaftaran (SeminarFormFragment)
Fieldnya:
```
1. Nama Lengkap (TextInput)
2. Email (TextInput)
3. Nomor Telepon (TextInput)
4. Jenis Kelamin (RadioButton)
5. Pilih Seminar (Spinner)
6. Persetujuan Syarat (Checkbox)
7. Button Submit
```

**Validasi**:
- Nama: Not empty
- Email: Valid format & not empty
- Telepon: Format 08xxxxxxxxxx (11-12 digit)
- Gender: Must be selected
- Seminar: Must be selected (not default)
- Agreement: Must be checked

### Step 5: Hasil Pendaftaran (ResultFragment)
Menampilkan ringkasan data:
```
✓ Pendaftaran Berhasil! 🎉

Detail Pendaftaran:
- Nama: [Input dari form]
- Email: [Input dari form]
- Telepon: [Input dari form]
- Jenis Kelamin: [Pilihan]
- Seminar: [Pilihan]

Status: Pendaftaran Diterima
```

Button "Kembali ke Beranda" → back to HomeFragment

---

## 4. Data Structure

### Users (Hardcoded)
```kotlin
// MainActivity.kt
private val users = mutableMapOf(
    "mahasiswa" to "12345",
    "admin" to "admin123"
)
```

### Seminars (Hardcoded)
```kotlin
// SeminarFormFragment.kt
private val seminarOptions = listOf(
    "-- Pilih Seminar --",
    "Seminar Android Modern",
    "Seminar AI untuk Mahasiswa",
    "Seminar UI/UX Product Design",
    "Seminar Public Speaking",
    "Seminar Career Preparation"
)
```

### Registration Data Class
```kotlin
// SeminarRegistration.kt
data class SeminarRegistration(
    val name: String,
    val email: String,
    val phone: String,
    val gender: String,
    val seminar: String
)
```

### Session Management
```kotlin
// AppSession.kt
object AppSession {
    var currentUsername: String = ""
    var latestRegistration: SeminarRegistration? = null
}
```

---

## 5. UI/UX Design

### Color Palette

```
Primary: #5B57F3 (Ungu)
Secondary: #26A69A (Teal)
Success: #10B981 (Hijau)
Error: #EF4444 (Merah)
Background: #F5F7FF (Biru muda)
Surface: #FFFFFF (Putih)
Text Primary: #1D2333 (Gelap)
Text Secondary: #5A647A (Abu-abu)
Divider: #E5E7EB
Overlay Light: #F3F4F6
```

### Typography

- **Heading (22-26sp)**: Bold, Primary color
- **Subheading (16-18sp)**: Bold, Primary/Text
- **Body (13-14sp)**: Regular, Text Secondary
- **Caption (12-13sp)**: Regular, Text Secondary

### Spacing

- **Large Padding**: 20dp (card outer)
- **Medium Padding**: 16dp (content)
- **Small Padding**: 12dp (elements)
- **Extra Small**: 8dp (minimal gap)

### Components

#### 1. Hero Card
- Background: Gradient atau solid primary
- Corner Radius: 24-28dp
- Elevation: 6-8dp
- Padding: 20-24dp
- Content: Title + Subtitle

#### 2. Content Card
- Background: White/Surface
- Corner Radius: 20-24dp
- Elevation: 6-8dp
- Padding: 18-20dp

#### 3. TextInput Layout
- Background: Light overlay (#F3F4F6)
- Corner Radius: 12-14dp
- Has Start Icon
- Has End Icon (clear/toggle)
- Border Radius: Smooth

#### 4. MaterialButton
- Corner Radius: 14dp
- Height: 48-52dp
- Text Size: 15-16sp
- Elevation: 4dp
- Icon + Text Layout

#### 5. Bottom Navigation
- Height: 56dp (default)
- Background: White
- Item Tint: Primary (selected) / Gray (inactive)

---

## 6. File Structure

```
UTS/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/example/uts/
│   │       │       ├── MainActivity.kt (206 baris)
│   │       │       ├── DashboardActivity.kt (81 baris)
│   │       │       ├── HomeFragment.kt (31 baris)
│   │       │       ├── SeminarFormFragment.kt (141 baris)
│   │       │       ├── ResultFragment.kt (45 baris)
│   │       │       ├── AppSession.kt (8 baris)
│   │       │       └── SeminarRegistration.kt (11 baris)
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   ├── activity_main.xml
│   │       │   │   ├── activity_dashboard.xml
│   │       │   │   ├── fragment_home.xml
│   │       │   │   ├── fragment_form.xml
│   │       │   │   └── fragment_result.xml
│   │       │   ├── drawable/
│   │       │   │   ├── bg_gradient.xml
│   │       │   │   ├── spinner_bg.xml
│   │       │   │   └── ic_*.xml
│   │       │   ├── color/
│   │       │   │   └── bottom_nav_selector.xml
│   │       │   ├── menu/
│   │       │   │   └── bottom_nav_menu.xml
│   │       │   ├── values/
│   │       │   │   ├── colors.xml (28 warna)
│   │       │   │   ├── strings.xml (60+ string)
│   │       │   │   └── themes.xml
│   │       │   └── mipmap/ (app icons)
│   │       └── AndroidManifest.xml (2 activity)
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── gradle/ (wrapper files)
├── build.gradle.kts (root)
├── settings.gradle.kts
├── README.md
├── DOKUMENTASI.md (file ini)
└── .gitignore
```

---

## 7. Key Classes & Methods

### MainActivity.kt
```kotlin
class MainActivity : AppCompatActivity() {
    private enum class AuthMode { LOGIN, REGISTER }
    
    private fun handleLogin()      // Validasi & proses login
    private fun handleRegister()   // Validasi & proses register
    private fun renderAuthMode()   // Toggle UI login/register
    private fun showAuthScreen()   // Initialize UI
}
```

### DashboardActivity.kt
```kotlin
class DashboardActivity : AppCompatActivity() {
    private fun openFragment(fragment: Fragment)  // Ganti fragment
    fun navigateToForm()          // Navigate ke form
    fun navigateToResult()        // Navigate ke result
    fun navigateToHome()          // Navigate ke home
    fun logout()                  // Logout & kembali ke MainActivity
}
```

### SeminarFormFragment.kt
```kotlin
class SeminarFormFragment : Fragment(R.layout.fragment_form) {
    private fun isEmailValid(email: String): Boolean
    private fun isPhoneValid(phone: String): Boolean
    // Handle form validation & submission
}
```

---

## 8. Validation Rules

### Login/Register
| Field | Min | Max | Format |
|-------|-----|-----|--------|
| Username | 4 | - | Alphanumeric |
| Password | 4 | - | Any |
| Confirm | 4 | - | Must match password |

### Seminar Form
| Field | Rule |
|-------|------|
| Nama | Not empty |
| Email | Valid email format |
| Telepon | 08xxxxxxxxxx (11-12 digit) |
| Gender | Must select |
| Seminar | Not default option |
| Persetujuan | Must check |

---

## 9. String Resources (strings.xml)

Total: 60+ string entries untuk:
- Login/Register labels & messages
- Form labels & errors
- Navigation labels
- Success/Error messages
- Validation error messages

---

## 10. Dependencies

```gradle
// Material Design 3
implementation(libs.material)

// AndroidX
implementation(libs.androidx.core.ktx)
implementation(libs.androidx.appcompat)
implementation(libs.androidx.activity)
implementation(libs.androidx.constraintlayout)

// Testing
testImplementation(libs.junit)
androidTestImplementation(libs.androidx.junit)
androidTestImplementation(libs.androidx.espresso.core)
```

---

## 11. Build Info

- **API Level**: Min 31, Target 36
- **Compile SDK**: 36.1
- **Build System**: Gradle 9.2.1
- **Kotlin**: Latest
- **Java Compatibility**: 11

---

## 12. Testing Credentials

```
Demo User 1:
Username: mahasiswa
Password: 12345

Demo User 2:
Username: admin
Password: admin123

Try to Register:
Username: student1
Password: password123
Confirm: password123
```

---

## 13. Error Handling

### Login Errors
- ❌ Username/Password kosong
- ❌ Username/Password tidak cocok

### Register Errors
- ❌ Username < 4 karakter
- ❌ Password < 4 karakter
- ❌ Password tidak match
- ❌ Username sudah terdaftar

### Form Errors
- ❌ Nama kosong
- ❌ Email kosong atau invalid
- ❌ Telepon tidak sesuai format
- ❌ Gender tidak dipilih
- ❌ Seminar tidak dipilih
- ❌ Persetujuan tidak dicek

---

## 14. Best Practices Implemented

✅ **Material Design 3**: Menggunakan Material components  
✅ **Kotlin**: Modern Android development  
✅ **Fragment**: Proper fragment lifecycle handling  
✅ **Resources**: Hardcoded strings di strings.xml  
✅ **Colors**: Centralized di colors.xml  
✅ **Validation**: Input validation di setiap field  
✅ **UX**: Proper feedback & error messages  
✅ **Responsive**: Works on different screen sizes  
✅ **Edge-to-Edge**: System insets handling  
✅ **Session**: Singleton pattern untuk app session  

---

## 15. Fitur Tambahan yang Bisa Dikembangkan

- [ ] Database (Room/Firebase) untuk persistent storage
- [ ] User authentication dengan server
- [ ] Seminar details screen
- [ ] Edit pendaftaran sebelumnya
- [ ] Export PDF hasil pendaftaran
- [ ] Notifikasi reminder
- [ ] Dark mode toggle
- [ ] Multi-language support
- [ ] Image upload untuk profile
- [ ] Pembayaran/QR code
- [ ] Analytics tracking
- [ ] Offline support

---

## 16. Deployment

### APK Generation
```bash
.\gradlew.bat assembleDebug    # Debug APK
.\gradlew.bat assembleRelease  # Release APK (need signing)
```

### Testing
```bash
.\gradlew.bat testDebugUnitTest
.\gradlew.bat connectedAndroidTest
```

---

## 17. Troubleshooting

| Issue | Solution |
|-------|----------|
| Build error: Duplicate resources | Remove duplicate dari colors.xml |
| Icon tidak muncul | Pastikan drawable file exists |
| Text overflow | Gunakan maxLines atau android:ellipsize |
| Layout melebihi screen | Gunakan ScrollView atau NestedScrollView |

---

## 18. Performance Tips

- ✅ Menggunakan ViewBinding (recommended untuk future)
- ✅ Fragment lazy loading via BottomNavigation
- ✅ Minimal nested layouts
- ✅ Efficient drawable resources
- ✅ No memory leaks dengan proper cleanup

---

## 19. Security Notes

⚠️ **Important**: 
- Data user hardcoded hanya untuk demo
- Password tidak di-hash (demo only)
- No data persistence (hilang saat app tutup)
- No network/API calls

**Production Checklist**:
- [ ] Implementasi proper authentication
- [ ] Use encrypted database
- [ ] HTTPS untuk API calls
- [ ] Obfuscate dengan ProGuard
- [ ] Security testing

---

**Version**: 1.0  
**Last Updated**: April 2025  
**Status**: ✅ Production Ready (for demo/learning purposes)

