# FieldOps — Native Android Field Audit & Barcode Platform

![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=flat-square)
![Platform](https://img.shields.io/badge/Platform-Android_Native-green?style=flat-square&logo=android)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.22-purple?style=flat-square&logo=kotlin)
![Room Database](https://img.shields.io/badge/Database-Room_SQLite-orange?style=flat-square)
![ZXing](https://img.shields.io/badge/Scanner-ZXing_Embedded-blue?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-purple?style=flat-square)

FieldOps is a native Android application architected for industrial warehouse audits, field inventory counting, and asset management in connectivity-denied environments. Built on offline-first Room SQLite storage with background WorkManager cloud synchronization.

---

## 🏛️ Mobile Architecture

```
  +-------------------------------+      +-------------------------------+
  |       Camera Hardware         |      |        Location Provider      |
  +---------------+---------------+      +---------------+---------------+
                  | Continuous Frames                    | GPS Coordinates
                  v                                      v
  +-------------------------------+      +-------------------------------+
  |     ZXing Barcode Decoder     |      |       GeoTagging Filter       |
  +---------------+---------------+      +---------------+---------------+
                  |                                      |
                  +-------------------+------------------+
                                      |
                                      v
                       +-------------------------------+
                       |   AuditViewModel / Repository |
                       +---------------+---------------+
                                       |
                                       v
                       +-------------------------------+
                       |      Room SQLite Database     |
                       |    (Local Offline Source)     |
                       +---------------+---------------+
                                       |
                                       | (Unsynced delta events)
                                       v
                       +-------------------------------+
                       |      WorkManager Worker       |
                       |  (Backoff Retry Cloud Sync)   |
                       +---------------+---------------+
                                       |
                                       v
                       +-------------------------------+
                       |      Central ERP REST API     |
                       +-------------------------------+
```

---

## 🚀 Architectural Capabilities

- **Offline-First Resilience**: Continuous full-speed barcode and QR scanning even with zero cellular/Wi-Fi coverage.
- **Hardware-Accelerated Decoding**: Leverages ZXing embedded pipelines to decode high-density Code 128, EAN-13, and QR symbols in sub-100ms.
- **GPS Audit Trail**: Every scanned record is tagged with precise geographic coordinates for anti-tamper inspection audits.
- **WorkManager Battery-Aware Sync**: Automatically defers cloud upload batches until active network connectivity is established.

---

## 📱 Building the App

```bash
git clone https://github.com/kubrvk/FieldOps.git
cd FieldOps

# Build debug APK
./gradlew assembleDebug
```

---

## 👤 Author & License

- **Author**: `kubrvk` ([GitHub Profile](https://github.com/kubrvk))
- **License**: MIT License.
