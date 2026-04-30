# 🔧 DOKUMENTASI TEKNIS - KONFIGURASI & IMPLEMENTASI

---

## 📱 ARSITEKTUR APLIKASI

### Model Arsitektur
```
┌─────────────────────────────────────────────┐
│         Presentation Layer (UI)             │
│  (Activities, Fragments, Layouts)           │
└─────────────────┬───────────────────────────┘
                  │
┌─────────────────▼───────────────────────────┐
│        Business Logic Layer                 │
│  (AppSession, Validation Logic)             │
└─────────────────┬───────────────────────────┘
                  │
┌─────────────────▼───────────────────────────┐
│         Data Layer (Local)                  │
│  (In-memory storage, no database)           │
└─────────────────────────────────────────────┘
```

### Clean Architecture Pattern
```
app/src/main/
├── java/com/example/uts/
│   ├── [Activities]
│   │   ├── MainActivity              - Entry point & Auth UI
│   │   └── DashboardActivity         - Main container
│   │
│   ├── [Fragments]
│   │   ├── HomeFragment              - Dashboard view
│   │   ├── SeminarFormFragment       - Registration form
│   │   └── ResultFragment            - Results display
│   │
│   ├── [Models]
│   │   ├── SeminarRegistration       - Data class
│   │   └── AppSession                - Global state
│   │
│   └── [Utils/Helpers]
│       └── (Validation helpers)
│
└── res/
    ├── layout/                       - XML layouts
    ├── drawable/                     - Drawables & shapes
    ├── color/                        - Color selectors
    ├── menu/                         - Menu definitions
    ├── values/                       - Strings, colors, styles
    └── mipmap/                       - App icons
```

---

## 🎨 DESIGN SYSTEM

### Color Palette Definition (colors.xml)

#### Primary Colors
```xml
<color name="primary">#1E293B</color>                    <!-- Dark Slate -->
<color name="onPrimary">#FFFFFF</color>                  <!-- White -->
```

#### Secondary Colors
```xml
<color name="secondary">#3B82F6</color>                  <!-- Bright Blue -->
<color name="secondary_light">#93C5FD</color>            <!-- Light Blue -->
```

#### Background
```xml
<color name="background">#F8FAFC</color>                 <!-- Very Light Gray -->
<color name="surfaceCard">#FFFFFFFF</color>              <!-- White Card -->
```

#### Text Colors
```xml
<color name="textPrimary">#0F172A</color>                <!-- Dark Text -->
<color name="textSecondary">#64748B</color>              <!-- Medium Gray -->
```

#### Accent Colors
```xml
<color name="accent_blue">#3B82F6</color>                <!-- Primary Action -->
<color name="accent_blue_light">#DBEAFE</color>          <!-- Light State -->
<color name="accent_purple">#8B5CF6</color>              <!-- Decorative -->
<color name="accent_purple_light">#EDE9FE</color>        <!-- Light State -->
```

#### Semantic Colors
```xml
<color name="success">#10B981</color>                    <!-- Success/Green -->
<color name="error">#EF4444</color>                      <!-- Error/Red -->
<color name="warning">#F59E0B</color>                    <!-- Warning/Orange -->
```

#### Utility
```xml
<color name="divider">#E2E8F0</color>                    <!-- Separator lines -->
<color name="overlay_light">#F1F5F9</color>              <!-- Input background -->
<color name="white_opacity_10">#1AFFFFFF</color>         <!-- 10% white -->
<color name="white_opacity_20">#33FFFFFF</color>         <!-- 20% white -->
```

---

## 📐 COMPONENT STYLING

### Text Input Layout Style
```xml
<style name="UTSWidgetTextInputOutlined" 
       parent="Widget.Material3.TextInputLayout.OutlinedBox">
    
    <!-- Background styling -->
    <item name="boxBackgroundColor">@color/overlay_light</item>
    
    <!-- Corner radius -->
    <item name="boxCornerRadiusTopStart">16dp</item>
    <item name="boxCornerRadiusTopEnd">16dp</item>
    <item name="boxCornerRadiusBottomStart">16dp</item>
    <item name="boxCornerRadiusBottomEnd">16dp</item>
    
    <!-- Border styling -->
    <item name="boxStrokeColor">@color/divider</item>
    <item name="boxStrokeWidth">1dp</item>
    <item name="boxStrokeWidthFocused">2dp</item>
    
    <!-- Text styling -->
    <item name="hintTextColor">@color/textSecondary</item>
</style>
```

### Button Primary Style
```xml
<style name="UTSWidgetButtonPrimary" parent="Widget.Material3.Button">
    <item name="android:layout_height">52dp</item>
    <item name="android:textSize">15sp</item>
    <item name="backgroundTint">@color/accent_blue</item>
    <item name="cornerRadius">16dp</item>
</style>
```

### Typography Styles
```xml
<style name="UTSTextTitleLarge">
    <item name="android:textColor">@color/textPrimary</item>
    <item name="android:textSize">22sp</item>
    <item name="android:textStyle">bold</item>
</style>

<style name="UTSTextTitleMedium">
    <item name="android:textColor">@color/textPrimary</item>
    <item name="android:textSize">16sp</item>
    <item name="android:textStyle">bold</item>
</style>

<style name="UTSTextBody">
    <item name="android:textColor">@color/textSecondary</item>
    <item name="android:textSize">14sp</item>
</style>

<style name="UTSTextCaption">
    <item name="android:textColor">@color/textSecondary</item>
    <item name="android:textSize">12sp</item>
</style>
```

---

## 📋 LAYOUT HIERARCHY

### Activity: MainActivity

#### Structure:
```xml
ConstraintLayout (root)
├── View (Header Background - gradient)
├── View (Decorative circle)
├── LinearLayout (Logo section - centered)
│   ├── MaterialCardView (Logo card)
│   │   └── ImageView (App logo)
│   ├── TextView (App name)
│   └── TextView (Subtitle)
│
└── NestedScrollView (Content scroll area)
    └── LinearLayout (Form container)
        ├── MaterialCardView (Auth form card - elevated)
        │   └── LinearLayout (Form fields)
        │       ├── TextView (Title)
        │       ├── View (Underline)
        │       ├── TextInputLayout (Username)
        │       ├── TextInputLayout (Password)
        │       ├── TextInputLayout (Confirm password)
        │       ├── MaterialButton (Submit)
        │       └── MaterialButton (Switch mode)
        │
        └── TextView (Demo credentials info)
```

#### Dimensions:
```
Header height:           320dp
Logo size:               140dp x 140dp
Form card corner:        28dp
Input field corner:      16dp
Button height:           52dp
Padding (horizontal):    24dp
Padding (vertical):      32dp between sections
```

---

### Fragment: HomeFragment

#### Structure:
```xml
ScrollView (fillViewport=true)
└── LinearLayout (main content container)
    ├── RelativeLayout (Header with logout)
    │   ├── LinearLayout (Title section)
    │   │   ├── TextView (Title: "Beranda")
    │   │   └── TextView (Subtitle)
    │   └── MaterialCardView (Logout button - circular)
    │       └── ImageView (Logout icon)
    │
    ├── MaterialCardView (Hero card - elevated)
    │   └── FrameLayout (Content with decoration)
    │       ├── View (Circle decoration - overlay)
    │       └── LinearLayout (Content)
    │           ├── TextView (Greeting)
    │           ├── TextView (User name - dynamic)
    │           ├── View (Underline)
    │           └── TextView (Description)
    │
    ├── LinearLayout (Stats row - 2 columns)
    │   ├── MaterialCardView (Stat 1: Seminar count)
    │   │   └── LinearLayout
    │   │       ├── View (Blue indicator)
    │   │       └── LinearLayout (Text content)
    │   │
    │   └── MaterialCardView (Stat 2: Steps)
    │       └── LinearLayout
    │           ├── View (Purple indicator)
    │           └── LinearLayout (Text content)
    │
    ├── TextView (Available section title)
    ├── TextView (Available section description)
    │
    └── MaterialButton (CTA: "Daftar Seminar")
        ├── Icon (Add icon)
        └── Text
```

#### Dimensions:
```
Hero card corner:        28dp
Hero card elevation:     6dp
Stat card corner:        20dp
Stat card elevation:     2dp
Indicator bar width:     4dp
Logout button size:      48dp
CTA button height:       62dp
Stats indicator height:  32dp
```

---

### Fragment: SeminarFormFragment

#### Structure:
```xml
ConstraintLayout (root)
├── View (Header background - gradient, 180dp)
│
├── LinearLayout (Header text - overlay)
│   ├── TextView (Form title)
│   └── TextView (Form subtitle)
│
└── NestedScrollView (Content scroll, starts at 100dp from top)
    └── LinearLayout (Form card container)
        └── MaterialCardView (Form card - elevated)
            └── LinearLayout (Form fields)
                
                <!-- Section 1: Identity -->
                ├── TextView ("IDENTITAS" - label)
                ├── TextInputLayout (Nama lengkap)
                ├── TextInputLayout (Email)
                ├── TextInputLayout (Telepon)
                │
                ├── TextView (Jenis Kelamin label)
                ├── RadioGroup (Male/Female)
                │
                ├── View (Divider line)
                │
                <!-- Section 2: Preference -->
                ├── TextView ("PREFERENSI" - label)
                │
                ├── TextView (Seminar selection label)
                ├── MaterialCardView (Spinner container)
                │   └── Spinner (Seminar dropdown)
                │
                ├── MaterialCheckBox (Agreement)
                │
                └── MaterialButton (Submit)
                    ├── Icon (Send icon)
                    └── Text
```

#### Dimensions:
```
Form header height:      180dp
Form card corner:        24dp
Form card elevation:     6dp
Input field corner:      16dp
Section separator:       1dp line with 24dp margin
Button height:           52dp
Button corner:           16dp
Padding (form):          24dp
Padding (section):       20dp
```

---

### Fragment: ResultFragment

#### Structure:
```xml
ScrollView (fillViewport=true)
└── LinearLayout (main container)
    └── MaterialCardView (Result card - elevated)
        └── LinearLayout (Content)
            
            ├── TextView (Title: "Hasil Pendaftaran")
            │
            ├── LinearLayout (Status section)
            │   ├── View (Status indicator)
            │   ├── TextView (Status text - "Berhasil!")
            │   └── TextView (Status subtitle)
            │
            ├── LinearLayout (Empty state - conditional visibility)
            │   ├── ImageView (Empty icon)
            │   └── MaterialButton (CTA: "Daftar Sekarang")
            │
            ├── LinearLayout (Result details - conditional visibility)
            │   ├── View (Divider)
            │   ├── include (Result row: Name)
            │   ├── include (Result row: Email)
            │   ├── include (Result row: Phone)
            │   ├── include (Result row: Gender)
            │   └── include (Result row: Seminar)
            │
            └── MaterialButton (Back button)
                ├── Icon (Arrow back)
                └── Text
```

#### Result Row (item_result_row.xml):
```xml
LinearLayout (horizontal)
├── LinearLayout (Label section)
│   └── TextView (Field label)
│
└── TextView (Field value)
```

#### Dimensions:
```
Card corner:             24dp
Card elevation:          4dp
Empty state image:       160dp x 160dp
Result divider:          1dp
Button heights:          52dp
Button corners:          16dp
Padding:                 20dp
```

---

## 🔄 DATA MODELS

### SeminarRegistration Data Class
```kotlin
data class SeminarRegistration(
    val name: String,              // Nama lengkap
    val email: String,             // Email address
    val phone: String,             // Nomor telepon (format: 08xxxxx)
    val gender: String,            // Jenis kelamin (Laki-laki/Perempuan)
    val seminar: String,           // Nama seminar
    val timestamp: Long            // Waktu registrasi
)
```

### AppSession Singleton
```kotlin
object AppSession {
    var currentUsername: String = ""                      // Current logged-in user
    var latestRegistration: SeminarRegistration? = null   // Latest registration data
}
```

---

## ✅ VALIDASI RULES

### Username Validation
```kotlin
fun validateUsername(username: String): ValidationResult {
    return when {
        username.isEmpty() -> 
            ValidationResult(false, "Username tidak boleh kosong")
        username.length < 4 -> 
            ValidationResult(false, "Username minimal 4 karakter")
        isDuplicateUsername(username) -> 
            ValidationResult(false, "Username sudah terdaftar")
        else -> 
            ValidationResult(true, "Username valid")
    }
}
```

### Password Validation
```kotlin
fun validatePassword(password: String): ValidationResult {
    return when {
        password.isEmpty() -> 
            ValidationResult(false, "Password tidak boleh kosong")
        password.length < 4 -> 
            ValidationResult(false, "Password minimal 4 karakter")
        else -> 
            ValidationResult(true, "Password valid")
    }
}
```

### Email Validation
```kotlin
fun validateEmail(email: String): ValidationResult {
    val pattern = Regex("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Z|a-z]{2,})\$")
    return when {
        email.isEmpty() -> 
            ValidationResult(false, "Email tidak boleh kosong")
        !pattern.matches(email) -> 
            ValidationResult(false, "Format email tidak valid")
        else -> 
            ValidationResult(true, "Email valid")
    }
}
```

### Phone Number Validation
```kotlin
fun validatePhone(phone: String): ValidationResult {
    val digitsOnly = phone.replace(Regex("[^0-9]"), "")
    return when {
        digitsOnly.isEmpty() -> 
            ValidationResult(false, "Nomor telepon tidak boleh kosong")
        digitsOnly.length < 11 -> 
            ValidationResult(false, "Nomor telepon minimal 11 digit")
        digitsOnly.length > 12 -> 
            ValidationResult(false, "Nomor telepon maksimal 12 digit")
        else -> 
            ValidationResult(true, "Nomor telepon valid")
    }
}
```

### Phone Number Formatting
```kotlin
fun formatPhoneNumber(input: String): String {
    val cleaned = input.replace(Regex("[^0-9]"), "")
    return when {
        cleaned.startsWith("62") -> "0" + cleaned.substring(2)
        cleaned.startsWith("0") -> cleaned
        else -> "0" + cleaned
    }
}
```

---

## 🎨 DRAWABLE RESOURCES

### Shape Drawables

#### bg_hero_card.xml - Linear Gradient
```xml
<shape xmlns:android="http://schemas.android.com/apk/res/android" 
    android:shape="rectangle">
    <gradient
        android:angle="135"
        android:startColor="#1E293B"
        android:centerColor="#2D3E50"
        android:endColor="#334155"
        android:type="linear" />
    <corners android:radius="28dp" />
</shape>
```

#### bg_circle_decoration.xml - Oval Shape
```xml
<shape xmlns:android="http://schemas.android.com/apk/res/android" 
    android:shape="oval">
    <solid android:color="#FFFFFF" />
    <alpha android:value="0.1" />
</shape>
```

#### bg_stat_indicator_blue.xml - Indicator Bar
```xml
<shape xmlns:android="http://schemas.android.com/apk/res/android" 
    android:shape="rectangle">
    <solid android:color="#3B82F6" />
    <corners android:radius="2dp" />
</shape>
```

#### bg_stat_indicator_purple.xml - Purple Indicator
```xml
<shape xmlns:android="http://schemas.android.com/apk/res/android" 
    android:shape="rectangle">
    <solid android:color="#8B5CF6" />
    <corners android:radius="2dp" />
</shape>
```

---

## 🗂️ DRAWABLE ICONS

### Material Icons Used
```
ic_person_outline.xml               - Username icon
ic_lock_outline.xml                 - Password icon
ic_email_outline.xml                - Email icon
ic_phone_outline.xml                - Phone icon
ic_badge_outline.xml                - Name icon
ic_action_logout.xml                - Logout icon
ic_send_outline.xml                 - Submit icon
ic_action_add.xml                   - Add/Register icon
ic_arrow_back_outline.xml           - Back icon
ic_empty_state.xml                  - Empty state placeholder
logo_seminar_hub.xml                - App logo
```

---

## 📱 RESPONSIVE BEHAVIOR

### ConstraintLayout Chains
Used for flexible positioning:
```xml
<!-- Horizontal chain for centered elements -->
<LinearLayout
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
```

### Weight-based Layout
Used for proportional sizing:
```xml
<LinearLayout
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_weight="1"
    android:layout_marginEnd="8dp" />
```

### Scroll Handling
For content that exceeds screen:
```xml
<NestedScrollView
    android:layout_width="match_parent"
    android:layout_height="0dp"
    android:fillViewport="true"
    app:layout_constraintTop_toBottomOf="@id/header"
    app:layout_constraintBottom_toBottomOf="parent" />
```

---

## 🧪 TESTING SCENARIOS

### Test Case 1: Login Validation
```
Scenario: User enters invalid credentials
Steps:
  1. Open app → MainActivity
  2. Enter "ab" in username → should show error (min 4 chars)
  3. Enter "12" in password → should show error (min 4 chars)
  4. Click login → button should be disabled
Expected: Form validation prevents submission
```

### Test Case 2: Register & Duplicate Check
```
Scenario: Register new user then try duplicate
Steps:
  1. Switch to register mode
  2. Enter username "mahasiswa" → should show "already registered"
  3. Enter new username "user123"
  4. Enter password & confirm
  5. Click register → should succeed
Expected: Duplicate detection working, new user created
```

### Test Case 3: Form Validation
```
Scenario: Submit form with missing fields
Steps:
  1. Login successfully
  2. Navigate to form
  3. Try submit without filling → show error on each field
  4. Fill name & email, skip phone → error on phone
  5. Fill all fields correctly → success
Expected: Real-time validation prevents invalid submission
```

### Test Case 4: Phone Number Format
```
Scenario: Test phone number conversion
Steps:
  1. Enter "62812345678" → should convert to "0812345678"
  2. Enter "08123456789" → should keep as "08123456789"
  3. Enter "812345678" → should convert to "0812345678"
Expected: Phone format always starts with 08
```

### Test Case 5: Navigation Flow
```
Scenario: Navigate between fragments
Steps:
  1. Click Home tab → HomeFragment loads
  2. Click Form tab → SeminarFormFragment loads
  3. Click Result tab → ResultFragment loads (empty)
  4. Fill and submit form
  5. Result tab shows data
Expected: Smooth navigation with data persistence in session
```

---

## 🚀 BUILD & DEPLOYMENT

### Gradle Configuration (build.gradle.kts)
```kotlin
plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.uts"
    compileSdk = 36
    
    defaultConfig {
        applicationId = "com.example.uts"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }
    
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // Core
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    
    // UI
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    
    // Fragment
    implementation("androidx.fragment:fragment-ktx:1.8.1")
    
    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}
```

---

## 📊 PERFORMANCE OPTIMIZATION

### Memory Management
- Proper fragment lifecycle handling
- No memory leaks in listeners
- Bitmap optimization for images
- Clean separation of concerns

### Layout Optimization
- Minimal nesting (max 3-4 levels)
- Use ConstraintLayout for complex layouts
- Avoid unnecessary ViewGroups
- Proper use of merge tags

### Rendering Optimization
- Card elevation used sparingly (max 6dp)
- Smooth animations with proper durations
- Efficient drawable resources
- Proper view recycling

---

## 🔒 SECURITY CONSIDERATIONS

### Data Security
```kotlin
// ✅ Good: Data cleared on logout
AppSession.currentUsername = ""
AppSession.latestRegistration = null

// ❌ Avoid: Storing sensitive data unencrypted
// (Not applicable here - demo app only)
```

### Input Sanitization
```kotlin
// Validate all user input before processing
val cleanedInput = userInput.trim()
                            .replace(Regex("[<>\"'&]"), "")
```

---

**Dokumentasi Teknis Selesai**


