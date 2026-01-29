# Android Reusables

A collection of useful Kotlin extension functions for Android development, focusing on **Coroutines**, **String utilities**, and **Jetpack Compose modifiers**.

## Overview

This repository contains reusable extension functions that simplify common Android development tasks and reduce boilerplate code.

## Features

### 🔄 Coroutine Extensions (`CoroutineExt.kt`)
Simplified coroutine launching with predefined dispatchers:
- `launchIO()` - Launch a coroutine on the IO dispatcher
- `launchMain()` - Launch a coroutine on the Main dispatcher
- `launchDefault()` - Launch a coroutine on the Default dispatcher

**Spacing:**
- `heightSpacer(height: Dp)` - Add vertical spacing
- `widthSpacer(width: Dp)` - Add horizontal spacing

## Usage

Simply copy the extension files into your Android project and import them where needed:

```kotlin
// Coroutine example
viewModelScope.launchIO {
    val data = fetchDataFromAPI()
}

// String example
val email = "user@example.com"
if (email.isEmailValid()) {
    // Process email
}

// Compose modifier example
Button(
    modifier = Modifier
        .paddingAll(16.dp)
        .circleClip()
        .clickableNoRipple { /* action */ }
) {
    Text("Click me")
}
```

## Requirements

- Kotlin 1.x+
- Android API level 21+
- Jetpack Compose (for modifier extensions)
- Kotlinx Coroutines (for coroutine extensions)

## License

This repository is open for personal and commercial use.

## Contributing

Feel free to suggest improvements or add more useful extensions!
