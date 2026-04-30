# 📸 KONFIGURASI VISUAL & PENJELASAN SCREENSHOT

---

## 🖼️ SCREEN 1: LOGIN SCREEN

### Layout Configuration
```xml
Header Background (320dp height)
├─ Gradient: #1E293B → #334155 (135° angle)
├─ Decorative circles (150dp, semi-transparent)
│
Logo Section (Centered)
├─ Material Card (140dp x 140dp)
│  └─ App logo (centered inside)
│
Title & Subtitle (White text)
│
Form Card (Material, 28dp radius)
├─ Username Input (Icon: person)
├─ Password Input (Icon: lock, toggle visibility)
├─ Confirm Password (Register only)
├─ Primary Button (Blue: #3B82F6)
└─ Text Button (Switch mode)
```

### Visual Elements
- **Header**: Dark gradient background
- **Logo Card**: White card with shadow elevation 12dp
- **Form Card**: White elevated card (8dp), overlap effect
- **Icons**: Material outline icons (tint: secondary)
- **Buttons**: Primary button (52dp height), rounded 16dp
- **Text**: White for header, dark for form content
- **Demo Info**: Small text at bottom (gray, 12sp)

### Color Usage
```
Background area:    #F8FAFC
Form card:         #FFFFFF
Primary text:      #0F172A
Secondary text:    #64748B
Buttons:           #3B82F6 (Blue)
Button text:       #FFFFFF (White)
Error text:        #EF4444 (Red)
Icons:             #64748B (Gray tint)
```

### Spacing
```
Logo padding:      48dp top
Form margin top:   -20dp (overlap)
Card padding:      28dp
Field margin:      16dp top
Button margin:     32dp top
Section padding:   24dp horizontal
```

### User Interaction Flow
```
1. See login form with fields
2. Type username → real-time validation
3. Type password → show/hide toggle visible
4. See error messages if validation fails
5. Click "Login" → go to Dashboard
6. Or click "Register" → toggle confirm password field
```

---

## 🖼️ SCREEN 2: HOME/DASHBOARD SCREEN

### Layout Configuration
```xml
Header Section (Sticky top)
├─ Title: "Beranda" (22sp, bold)
├─ Subtitle: "Selamat datang kembali" (12sp)
└─ Logout Button (48dp circular card, end aligned)
│
Hero Card (Material, 28dp, elevation 6dp)
├─ Gradient Background (#1E293B → #334155)
├─ Decorative circle (top-right corner)
├─ Greeting: "Halo, {username}! 👋" (24sp bold, white)
├─ Description text (white, 80% opacity)
└─ Blue underline (40dp width)
│
Stats Row (2 columns, equal width)
├─ Card 1: Seminar Count (5)
│  └─ Blue indicator bar (4dp width, 32dp height)
├─ Card 2: Steps (3)
│  └─ Purple indicator bar (4dp width, 32dp height)
│
CTA Section
├─ Section title: "Seminar Tersedia"
├─ Description text
└─ Large Primary Button (62dp height)
   └─ Icon: add
```

### Visual Elements
- **Header**: Clean with logout button positioned top-right
- **Hero Card**: Premium gradient with decorative overlay
- **Welcome Text**: Personalized with dynamic username
- **Stats Cards**: White cards (20dp radius), small shadows
- **Indicators**: Colored bars (blue & purple) on left
- **CTA Button**: Large, prominent, with icon
- **Scroll Area**: Full scrollable with extra bottom padding

### Color Scheme
```
Background:        #F8FAFC
Hero gradient:     #1E293B → #334155
Card background:   #FFFFFF
Text primary:      #0F172A (header, stats)
Text secondary:    #64748B (descriptions)
Blue indicator:    #3B82F6
Purple indicator:  #8B5CF6
Button:            #3B82F6
Logout icon:       #EF4444
```

### Dynamic Content
```
Welcome message:   "Halo, {currentUsername}! 👋"
Stat 1 value:      "5" (seminar count)
Stat 2 value:      "3" (steps)
Section title:     "Seminar Tersedia"
Description:       Multi-line text about available seminars
```

### Spacing
```
Header padding:    24dp top, 20dp horizontal
Hero card margin:  24dp bottom
Stats row margin:  28dp bottom
Section title:     18sp bold, 8dp margin bottom
Description:       14sp, margin bottom 24dp
Button height:     62dp
```

### User Interaction Flow
```
1. User sees personalized welcome
2. See stats showing seminar info
3. Read seminar description
4. Click "Daftar Seminar" → go to Form
5. Or click logout button → confirm logout → back to Login
6. Swipe/scroll to see full content
```

---

## 🖼️ SCREEN 3: FORM PENDAFTARAN SCREEN

### Layout Configuration
```xml
Header Section (Fixed, gradient background 180dp)
├─ Title: "Form Pendaftaran" (22sp bold, white)
├─ Subtitle: "Isi data diri dengan benar" (13sp, white 80%)
│
Form Card (Material, 24dp radius, elevation 6dp)
├─ SECTION 1: IDENTITAS
│  ├─ Label: "IDENTITAS" (14sp, blue, uppercase)
│  ├─ Text Input: Nama Lengkap
│  │  └─ Icon: badge (start), clear button (end)
│  ├─ Text Input: Email
│  │  └─ Icon: email (start), clear button (end)
│  ├─ Text Input: Telepon
│  │  └─ Icon: phone (start), prefix: "+62"
│  │
│  ├─ Label: "Jenis Kelamin" (14sp bold)
│  └─ Radio Group (Horizontal)
│     ├─ Laki-laki
│     └─ Perempuan
│
│  ├─ Divider line (1dp, #E2E8F0)
│
│  ├─ SECTION 2: PREFERENSI
│  ├─ Label: "PREFERENSI" (14sp, blue, uppercase)
│  ├─ Label: "Pilih Seminar" (14sp bold)
│  ├─ Spinner Container (Material Card)
│  │  └─ Dropdown: Seminar options
│  │
│  ├─ Checkbox: Persetujuan Syarat & Ketentuan (13sp)
│  │
│  └─ Primary Button: "Submit" (52dp, with send icon)
```

### Visual Elements
- **Header**: Gradient background matching hero style
- **Form Card**: White elevated card, padding 24dp
- **Section Labels**: Blue, uppercase, small caps effect
- **Input Fields**: Light gray background (#F1F5F9), 16dp radius
- **Border**: 1dp gray (#E2E8F0), 2dp on focus
- **Icons**: Material outline icons inside fields
- **Divider**: Thin gray line separating sections
- **Spinner**: Material card container with dropdown
- **Checkbox**: Material design checkbox
- **Button**: Blue primary button with send icon
- **Scroll Area**: NestedScrollView for long content

### Input Field Styling
```
Background:        #F1F5F9 (light overlay)
Border color:      #E2E8F0 (divider)
Border width:      1dp (normal), 2dp (focused)
Corner radius:     16dp (all corners)
Padding:           12dp horizontal, 16dp vertical
Font size:         14sp
Text color:        #0F172A
Hint color:        #64748B
Icon color:        #64748B
Error color:       #EF4444
```

### Validations Displayed
```
Name:              "Nama tidak boleh kosong"
Email:             "Format email tidak valid"
Phone:             "Nomor telepon tidak valid"
Gender:            Error if not selected
Seminar:           Error if not selected (default)
Agreement:         Error if not checked
```

### Spacing
```
Header padding:    24dp top/sides
Form margin top:   -20dp (overlap)
Form padding:      24dp
Section label:     16dp top, 12sp size
Input field:       12dp top
Divider section:   24dp margins
Button margin:     24dp top
Bottom padding:    32dp extra
```

### User Interaction Flow
```
1. See form with clear sections
2. Fill name, email, phone
   → Real-time validation
   → Error messages appear on invalid input
3. Select gender with radio button
4. Select seminar from dropdown
5. Check agreement checkbox
6. Click submit
   → Confirmation dialog appears
   → Confirm → data saved → go to Result
```

---

## 🖼️ SCREEN 4: RESULT/HASIL SCREEN

### Layout Configuration
```xml
Result Card (Material, 24dp radius, elevation 4dp)
├─ Title: "Hasil Pendaftaran" (22sp bold)
│
├─ STATUS SECTION
│  ├─ Status indicator (color: #10B981 green)
│  ├─ Status text: "✅ Pendaftaran Berhasil!" (18sp bold)
│  └─ Subtitle: Timestamp or message (14sp gray)
│
├─ EMPTY STATE (conditional visibility)
│  ├─ Icon: Empty state placeholder (160dp)
│  └─ Button: "Daftar Seminar" (CTA)
│
├─ DATA DETAILS SECTION (conditional visibility)
│  ├─ Divider line (1dp gray)
│  ├─ Row: Nama | {value}
│  ├─ Row: Email | {value}
│  ├─ Row: Telepon | {value} (formatted: 08xxx)
│  ├─ Row: Jenis Kelamin | {value}
│  └─ Row: Seminar | {value}
│
└─ PRIMARY BUTTON
   ├─ Icon: arrow back
   ├─ Text: "Kembali ke Beranda"
   └─ Click: Navigate to Home
```

### Visual Elements
- **Card**: White elevated card, shadow 4dp
- **Title**: Dark gray, 22sp bold
- **Status Header**: Green color (#10B981), centered
- **Status Message**: Bold, large text
- **Data Rows**: Label-value pair layout
- **Divider**: Thin gray line separating sections
- **Icons**: Arrow back on button
- **Empty State**: Large placeholder icon, info text

### Result Row Layout
```xml
LinearLayout (horizontal)
├─ Label section (35% width)
│  └─ TextView: "Nama" (14sp bold, gray)
│
└─ Value section (65% width)
   └─ TextView: "{actual value}" (14sp, dark)
```

### Color Scheme
```
Background:        #F8FAFC
Card:             #FFFFFF
Status color:     #10B981 (green/success)
Label text:       #64748B (gray)
Value text:       #0F172A (dark)
Divider:          #E2E8F0
Button:           #3B82F6
```

### Dynamic Content Display
```
Status: "✅ Pendaftaran Berhasil!" (if data exists)
        "Belum Ada Data" (if empty)

Rows displayed:
- Nama: {SeminarRegistration.name}
- Email: {SeminarRegistration.email}
- Telepon: {SeminarRegistration.phone} [formatted]
- Jenis Kelamin: {SeminarRegistration.gender}
- Seminar: {SeminarRegistration.seminar}
```

### Spacing
```
Card padding:      24dp
Title margin:      0 top, 16dp bottom
Status section:    12dp margins
Divider section:   16dp vertical margins
Data rows:         12dp between rows
Button margin:     32dp top
```

### User Interaction Flow
```
1. See registration success message
2. View all submitted data (formatted correctly)
3. Phone number shows as 08xxxxxxxxxx
4. Click "Kembali ke Beranda"
5. Navigate back to home screen
6. Or use bottom nav to switch screens
```

---

## 🖼️ SCREEN 5: BOTTOM NAVIGATION

### Structure
```xml
BottomNavigationView
├─ Item 1: 🏠 Beranda
├─ Item 2: 📋 Daftar
└─ Item 3: ✅ Hasil
```

### Styling
```
Background color:    #FFFFFF (white)
Height:             56dp (standard)
Elevation:          8dp
Border top:         1dp gray divider

Icon tint (inactive):  #64748B (gray)
Icon tint (active):    #3B82F6 (blue)
Text color:           same as icon tint

Item padding:        8dp vertical, 12dp horizontal
Icon size:           24dp
Text size:           11sp
```

### Behavior
```
Tap behavior:      Instant navigation
Visual feedback:   Icon + text color change to blue
Current state:     Highlighted item shows blue
Animation:         Smooth color transition (300ms)
```

---

## 🎨 COLOR REFERENCE

### Primary Colors
```
#1E293B   Dark Slate      (Headers, backgrounds)
#FFFFFF   White           (Cards, text backgrounds)
```

### Accent Colors
```
#3B82F6   Bright Blue     (Buttons, CTAs, active states)
#8B5CF6   Purple          (Decorative elements)
#93C5FD   Light Blue      (Hover, secondary states)
#DBEAFE   Very Light Blue (Subtle backgrounds)
#EDE9FE   Light Purple    (Subtle backgrounds)
```

### Semantic Colors
```
#10B981   Green           (Success, positive)
#EF4444   Red             (Error, negative)
#F59E0B   Orange          (Warning, caution)
```

### Neutral Colors
```
#0F172A   Dark Gray       (Primary text)
#64748B   Medium Gray     (Secondary text)
#E2E8F0   Light Gray      (Dividers, borders)
#F1F5F9   Very Light Gray (Input backgrounds)
#F8FAFC   Lightest Gray   (Page background)
```

### Opacity Variations
```
#FFFFFF1A  White 10%      (Decorative overlays)
#FFFFFF33  White 20%      (Subtle overlays)
~80%       Semi-transparent (Reduced opacity text)
```

---

## 📐 DIMENSION REFERENCE

### Typography Sizes
```
26sp   Page titles (Login heading, form title)
24sp   Logo name, welcome greeting
22sp   Section titles, result title
20sp   Subtitle, user name
18sp   Card titles, status message
16sp   Section labels, input labels
15sp   Button text, bold labels
14sp   Body text, input text, field labels
13sp   Subtitle text, checkbox text
12sp   Caption, demo info
11sp   Bottom nav labels
```

### Component Heights
```
62dp   Large CTA button
52dp   Primary button, normal height
48dp   Logout button (square/circle)
56dp   Bottom navigation
44dp   Large input field (with label)
54dp   Spinner height
32dp   Stat indicator bar
24dp   Small button
```

### Component Widths
```
match_parent      Full width components
0dp + weight=1    Proportional width
wrap_content      Auto width
140dp            Logo size
160dp            Empty state icon
150dp            Decorative circles
200dp            Large decorative circles
```

### Corner Radius
```
28dp   Large cards, hero cards
24dp   Medium cards, form cards
20dp   Stat chips
16dp   Input fields, buttons
12dp   Spinner container
2dp    Indicator bars
Full circle (48dp div 2)  Logout button
```

### Elevation/Shadow
```
12dp   Logo card
8dp    Form card, nav
6dp    Hero cards, primary cards
4dp    Result card
2dp    Stat chips, secondary cards
```

### Spacing System (Grid-based: 4dp)
```
4dp    xs (minimum spacing)
8dp    sm (small spacing)
12dp   md (medium spacing)
16dp   lg (large spacing)
20dp   xl (extra large)
24dp   2xl (very large)
32dp   3xl (massive)

Standard margins:    16dp, 20dp, 24dp
Standard paddings:   12dp, 16dp, 20dp, 24dp
Between sections:    24dp, 32dp
```

---

## ✨ VISUAL EFFECTS

### Gradients
```
Hero Card: 135° angle
  Start: #1E293B
  Center: #2D3E50 (optional)
  End: #334155
  Type: Linear

Decorative circles: Soft white with transparency
  Color: #FFFFFF
  Alpha: 0.1 (10%)
```

### Shadows
```
Logo card:           elevation 12dp
Form card (main):    elevation 8dp
Hero cards:          elevation 6dp
Bottom nav:          elevation 8dp
Result card:         elevation 4dp
Stat cards:          elevation 2dp
Logout button:       elevation 2dp
```

### Animations
```
Button ripple:       Material ripple effect
Field focus:         2dp stroke width change
Tab switch:          Fade + slide transition
Navigation:          Fragment transaction with fade
Color change:        Smooth 300ms transition
```

---

## 📱 RESPONSIVE BREAKPOINTS

### Phone (320-480dp width)
```
Single column layout
Buttons: Full width (with padding)
Cards: Full width (with padding)
Margins: 12dp-16dp
```

### Tablet (720dp+ width)
```
Increased margins
Better proportional spacing
Potentially wider input fields
Enhanced touch targets
```

### Landscape Mode
```
Reduced height for header
Horizontal scrolling for long forms
Adjusted padding to use screen better
```

---

## 🖼️ SCREENSHOT DESCRIPTIONS

### Screen 1: LOGIN
**Key Visual**: Dark gradient header with centered white logo card, overlay form card with blue buttons

### Screen 2: HOME
**Key Visual**: Personalized welcome message in hero card, two stat chips with colored indicators, large blue CTA button

### Screen 3: FORM
**Key Visual**: Multiple input fields with icons, radio buttons for gender, dropdown for seminar, large form card with sections

### Screen 4: RESULT
**Key Visual**: Green success message, formatted data display with clean rows, back button

### Screen 5: NAVIGATION
**Key Visual**: 5-item bottom navigation with icons, blue highlight on active tab

---

**Visual Documentation Complete** ✅


