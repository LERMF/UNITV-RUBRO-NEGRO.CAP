# UNITV Minimal Android TV Launcher

> **Ultra-minimalist, tracker-free Leanback launcher for Android TV and TV Box hardware.**

```
                     ┌───────────────────────────────────┐
                     │       D-Pad Remote Control        │
                     └─────────────────┬─────────────────┘
                                       │
                                       ▼
                     ┌───────────────────────────────────┐
                     │    Focus-Aware RecyclerView Grid  │
                     │    (5-Column Leanback Layout)     │
                     └─────────────────┬─────────────────┘
                                       │
                    ┌──────────────────┴──────────────────┐
                    ▼                                     ▼
         ┌─────────────────────┐               ┌─────────────────────┐
         │  Zero-Tracker Engine│               │   ProGuard Stripped │
         │  No Analytics/Ads   │               │    Sub-2MB Release  │
         └─────────────────────┘               └─────────────────────┘
```

Commercial Android TV launchers are filled with background trackers, intrusive advertising banners, and memory leaks that cripple low-end set-top boxes. A launcher should execute a single responsibility: indexing and launching installed applications with zero perceptible input latency.

`UNITV-RUBRO-NEGRO.CAP` is a clean, sovereign Android TV launcher built in idiomatic Kotlin. It strips all telemetry, enforces strict D-Pad navigation semantics, and optimizes rendering for 10-foot television user interfaces.

---

## ✦ Core Architectural Features

- **Strict D-Pad Semantics**: Full hardware remote compatibility (`DPAD_UP`, `DPAD_DOWN`, `DPAD_LEFT`, `DPAD_RIGHT`, `DPAD_CENTER`, `ENTER`).
- **Leanback Compliance**: Native `AndroidX Leanback` integration guaranteeing Android TV compatibility from Android 5.0 (API 21) through Android 14 (API 34).
- **Tracker Elimination**: Zero third-party analytics SDKs, zero advertising calls, zero persistent background services.
- **ProGuard Optimization**: Minified binary footprint ($<2\text{ MB}$) ensuring instantaneous cold-start on resource-constrained TV boxes.
- **Adaptive Focus States**: High-contrast visual focus styling with elevation depth for clear spatial orientation.

---

## ✦ Technical Specifications

| Parameter | Specification | Target Rationale |
|---|---|---|
| **Language** | Kotlin 1.9.0 | Idiomatic type safety and coroutines |
| **Minimum SDK** | API 21 (Android 5.0) | Broad legacy hardware support |
| **Target SDK** | API 34 (Android 14) | Modern platform compliance |
| **UI Framework** | RecyclerView + GridLayoutManager | Low-memory virtualization |
| **Theme** | Leanback Dark / High Contrast Red | Glare-free 10-foot living room UX |
| **License** | Apache-2.0 | Permissive open-source standard |

---

## ✦ Build & Deployment Instructions

### Build Release APK
```bash
# Ensure Android SDK is installed:
./gradlew assembleRelease

# Or invoke the automated release builder:
./build-release.sh
```

### Installation via ADB
```bash
# Connect to your Android TV device:
adb connect <DEVICE_IP>:5555

# Sideload the launcher:
adb install -r app/build/outputs/apk/release/app-release.apk

# Set as default launcher via device settings:
# Settings -> Apps -> Default Apps -> Home app -> UNITV Launcher
```

---

## ✦ License
[Apache License 2.0](LICENSE) © LERMF
