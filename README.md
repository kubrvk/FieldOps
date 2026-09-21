# FieldOps — Native Android Field Service & Site Inspection Platform

![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=flat-square)
![Platform](https://img.shields.io/badge/Platform-Android_Native-green?style=flat-square&logo=android)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.22-purple?style=flat-square&logo=kotlin)
![Room Database](https://img.shields.io/badge/Database-Room_SQLite-orange?style=flat-square)
![WorkManager](https://img.shields.io/badge/Sync-WorkManager_Worker-blue?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-purple?style=flat-square)

FieldOps is a native Android application engineered for mission-critical field operations, work order dispatch, GPS-verified site inspection checklists, and incident logging in connectivity-denied environments. Built on an offline-first Room SQLite storage architecture with background WorkManager cloud synchronization.

---

## 🏛️ Mobile Architecture

```
  +-------------------------------+      +-------------------------------+
  |       Sensor & Camera         |      |       Fused Location Provider |
  |   (Evidence Photo Capture)    |      |    (GPS Coordinates & RTK)    |
  +---------------+---------------+      +---------------+---------------+
                  | EXIF Geotagging                      | Coordinates & Accuracy
                  v                                      v
  +-------------------------------+      +-------------------------------+
  |     Inspection Checklist      |      |      Anti-Tamper GeoFilter    |
  |     (Pass / Fail / Values)    |      |     (Geofence Verification)   |
  +---------------+---------------+      +---------------+---------------+
                  |                                      |
                  +-------------------+------------------+
                                      |
                                      v
                       +-------------------------------+
                       |   WorkOrderViewModel / Repo   |
                       +---------------+---------------+
                                       |
                                       v
                       +-------------------------------+
                       |      Room SQLite Database     |
                       |    (Local Offline Source)     |
                       +---------------+---------------+
                                       |
                                       | (Delta audit events)
                                       v
                       +-------------------------------+
                       |      WorkManager Worker       |
                       |  (Backoff Exponential Sync)   |
                       +---------------+---------------+
                                       |
                                       v
                       +-------------------------------+
                       |    Central Operations API     |
                       +-------------------------------+
```

---

## 🚀 Architectural Capabilities

- **Offline-First Persistence**: Field technicians execute inspections, record sensor telemetry, and capture photo evidence even with zero cellular or Wi-Fi coverage.
- **GPS-Verified Geofencing**: Every work order and checklist item is cryptographically tagged with precise geographic coordinates and timestamp for anti-tamper compliance.
- **Background WorkManager Sync**: Automatically defers cloud upload batches until active network connectivity is established, with exponential backoff retry.
- **Jetpack Architecture Components**: Clean MVVM structure utilizing Kotlin Coroutines, StateFlow, Room ORM, and Material 3 design patterns.

---

## 📱 Building the App

```bash
git clone https://github.com/kubrvk/FieldOps.git
cd FieldOps

# Build debug APK
./gradlew assembleDebug
```

---

## 🌐 Live Web Demo

Interactive web demonstrator available at: [https://fieldopsapp.web.app](https://fieldopsapp.web.app)

---

## 👤 Author & License

- **Author**: `kubrvk` (Beraat Yetkin) ([GitHub Profile](https://github.com/kubrvk))
- **License**: MIT License.
