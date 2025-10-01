# UNITV-RUBRO-NEGRO.CAP
Custom minimal launcher for Android TV / BTV TV Box with optimizations and tracker removal.

## Features
- 🎯 Minimal and lightweight Android TV launcher
- 🎮 Full D-Pad navigation support for TV remotes
- 📱 Leanback-compatible for Android TV
- 🚀 Fast app launching with RecyclerView-based UI
- 🎨 Red and black theme optimized for TV screens
- 📦 Small APK size with ProGuard optimization

## Requirements
- Android 5.0 (API 21) or higher
- Android TV or TV Box with Leanback support
- Java 11+ for building

## Building

### Using the build script
```bash
./build-release.sh
```

### Using Gradle directly
```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease
```

The APK will be generated at:
- Debug: `app/build/outputs/apk/debug/app-debug.apk`
- Release: `app/build/outputs/apk/release/app-release.apk`

## Installation
1. Transfer the APK to your Android TV device
2. Enable "Unknown sources" in Settings
3. Install the APK using a file manager
4. Go to Settings > Apps > Default Apps > Home app
5. Select "UNITV Launcher" as your default launcher

## Development
The project uses:
- Kotlin for all source code
- AndroidX and Leanback libraries
- RecyclerView with GridLayoutManager for app grid
- CardView with focus animations for TV navigation

## CI/CD
The project includes GitHub Actions workflow for automated builds with APK signing.

## License
Apache License 2.0 - See LICENSE file for details
