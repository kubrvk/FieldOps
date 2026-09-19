# FieldOps

<img align="left" width="40%" src="https://raw.githubusercontent.com/kubrvk/portfolio/main/img/galeri/barkodtakip1.jpg"/>

<h3><a href="https://github.com/kubrvk/FieldOps"><img src="https://img.shields.io/badge/GitHub-kubrvk%2FFieldOps-000000?style=flat-square&logo=github&logoColor=white" height="25"/></a></h3>

![Android Native](https://img.shields.io/badge/Android-3DDC84?style=for-the-badges&logo=android&logoColor=white) ![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badges&logo=kotlin&logoColor=white) ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badges&logo=openjdk&logoColor=white) ![SQLite](https://img.shields.io/badge/SQLite-003B57?style=for-the-badges&logo=sqlite&logoColor=white)

<br>

Offline-first native Android field inventory audit and barcode scanning app with background cloud sync.

<br clear="left"/>

---

## Technical Details

| Component | Specification |
|---|---|
| Platform | Native Android (SDK 24 - 34) |
| Languages | Kotlin & Java |
| Local Database | Room Database (SQLite with Flow/LiveData observing) |
| Barcode Scanner | ZXing (Zebra Crossing) Embedded Fast Camera Scanner |
| Synchronization | WorkManager Background Sync with Conflict Resolution |
| Validation | GPS Location Geotagging & Hardware Camera Integration |

---

## Code Overview & Architecture

```text
FieldOps/
├── app/
│   ├── src/main/java/com/fieldops/
│   │   ├── data/          # Room DB, DAOs, Entity models
│   │   ├── scanner/       # ZXing barcode scanner view controller
│   │   ├── sync/          # WorkManager background sync workers
│   │   ├── ui/            # Audit activities, viewmodels & adapters
│   │   └── util/          # Network monitoring & GPS geolocation
│   ├── src/main/res/      # Layout XMLs, drawables & navigation
│   └── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## License & Author

Developed by **[Beraat Yetkin](https://github.com/kubrvk)**. All rights reserved.
