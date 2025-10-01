# Keystore Setup for CI/CD

To enable APK signing in GitHub Actions CI, you need to configure repository secrets.

## Creating a Keystore

If you don't have a keystore, create one:

```bash
keytool -genkey -v -keystore release.keystore -alias release_key -keyalg RSA -keysize 2048 -validity 10000
```

Follow the prompts to set passwords and information.

## Configure GitHub Secrets

Go to your repository settings → Secrets and variables → Actions, and add these secrets:

1. **KEYSTORE_BASE64**: Base64-encoded keystore file
   ```bash
   base64 release.keystore | tr -d '\n' > keystore_base64.txt
   # Copy the contents of keystore_base64.txt to this secret
   ```

2. **KEYSTORE_PASSWORD**: The keystore password you set

3. **KEY_ALIAS**: The alias name (e.g., "release_key")

4. **KEY_PASSWORD**: The key password you set

## How It Works

The GitHub Actions workflow will:
1. Decode the base64 keystore
2. Build the release APK
3. Align the APK using zipalign
4. Sign the APK using apksigner
5. Upload the signed APK as an artifact

## Manual Signing

If you prefer to sign manually:

```bash
# Build unsigned APK
./gradlew assembleRelease

# Align
zipalign -v -p 4 app/build/outputs/apk/release/app-release-unsigned.apk app-aligned.apk

# Sign
apksigner sign --ks release.keystore --ks-key-alias release_key --out app-signed.apk app-aligned.apk

# Verify
apksigner verify app-signed.apk
```
