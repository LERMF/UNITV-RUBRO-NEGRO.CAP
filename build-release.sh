#!/bin/bash
set -e

echo "Building UNITV Launcher Release APK..."

# Clean previous builds
./gradlew clean

# Build release APK
./gradlew assembleRelease

# Output location
echo ""
echo "Build complete!"
echo "APK location: app/build/outputs/apk/release/app-release.apk"
echo ""

# Show APK info
if [ -f "app/build/outputs/apk/release/app-release.apk" ]; then
    ls -lh app/build/outputs/apk/release/app-release.apk
fi
