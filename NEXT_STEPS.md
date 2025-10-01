# Next Steps - Getting Your Launcher Running

## 1. Build the Project

### Option A: Using Android Studio
1. Open the project in Android Studio
2. Wait for Gradle sync to complete
3. Click "Build" → "Build Bundle(s) / APK(s)" → "Build APK(s)"
4. Find the APK at `app/build/outputs/apk/debug/app-debug.apk`

### Option B: Using Command Line
```bash
# Ensure you have Android SDK and Java 17+ installed
export ANDROID_HOME=/path/to/android/sdk

# Build debug version (for testing)
./gradlew assembleDebug

# Build release version (optimized)
./gradlew assembleRelease
# or
./build-release.sh
```

## 2. Install on Android TV

### Using ADB (Android Debug Bridge)
```bash
# Connect to your Android TV via ADB
adb connect YOUR_TV_IP_ADDRESS

# Install the APK
adb install app/build/outputs/apk/debug/app-debug.apk
```

### Using USB Drive
1. Copy the APK to a USB drive
2. Plug the USB drive into your Android TV
3. Use a file manager app to navigate to the APK
4. Click to install

## 3. Set as Default Launcher

1. On your Android TV, go to **Settings**
2. Navigate to **Apps** → **See all apps**
3. Find **Default apps** or **Home app**
4. Select **UNITV Launcher**

## 4. Configure CI/CD (Optional)

To enable automated builds and APK signing:

1. Create a keystore for signing:
```bash
keytool -genkey -v -keystore release.keystore \
  -alias release_key -keyalg RSA -keysize 2048 -validity 10000
```

2. Convert keystore to base64:
```bash
base64 release.keystore | tr -d '\n' > keystore_base64.txt
```

3. Add GitHub repository secrets:
   - Go to your repository → Settings → Secrets and variables → Actions
   - Add these secrets:
     - `KEYSTORE_BASE64`: Contents of keystore_base64.txt
     - `KEYSTORE_PASSWORD`: Your keystore password
     - `KEY_ALIAS`: Your key alias (e.g., "release_key")
     - `KEY_PASSWORD`: Your key password

4. Push code to trigger the workflow:
```bash
git push origin main
```

See `KEYSTORE_SETUP.md` for detailed instructions.

## 5. Test the Launcher

1. Launch the UNITV Launcher
2. Use your TV remote's D-Pad (arrow keys) to navigate
3. Press OK/Enter to launch an app
4. Notice the red highlight when an app is focused

## 6. Customize (Optional)

### Change Theme Colors
Edit `app/src/main/res/values/colors.xml`:
```xml
<color name="red">#FFYOURCOLOR</color>
<color name="background">#FFYOURCOLOR</color>
```

### Change Grid Columns
Edit `app/src/main/java/com/unitv/launcher/MainActivity.kt`:
```kotlin
appsRecyclerView.layoutManager = GridLayoutManager(this, 5) // Change 5 to your preferred column count
```

### Change App Name
Edit `app/src/main/res/values/strings.xml`:
```xml
<string name="app_name">Your Launcher Name</string>
```

## 7. Troubleshooting

### Build Fails
- Ensure Android SDK is installed
- Check that `ANDROID_HOME` is set correctly
- Run `./gradlew clean` and try again

### Apps Don't Show
- Ensure `QUERY_ALL_PACKAGES` permission is granted
- Check if apps are launchable (have LAUNCHER category)
- Look at logcat for errors: `adb logcat | grep unitv`

### D-Pad Navigation Not Working
- Ensure your TV remote is properly connected
- Check that the CardView has `android:focusable="true"`
- Test with different remotes or external keyboard

## 8. Additional Resources

- **README.md**: General project documentation
- **PROJECT_SUMMARY.md**: Technical details and architecture
- **KEYSTORE_SETUP.md**: Detailed signing setup
- **GitHub Actions**: Check `.github/workflows/build.yml` for CI configuration

## Need Help?

If you encounter issues:
1. Check the GitHub Actions builds for errors
2. Review logcat output: `adb logcat`
3. Verify Android TV requirements are met (API 21+)
4. Ensure all dependencies are downloaded

Enjoy your minimal Android TV launcher! 🚀📺
