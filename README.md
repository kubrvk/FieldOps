# FieldOps 🚜
> **Saha Operasyonları & Sevk Masası • Endüstriyel Dispatcher ve Mobil Denetim Konsolu**

[![Canlı Demo](https://img.shields.io/badge/Canl%C4%B1_Demo-fieldopsapp.web.app-d97706?style=for-the-badge&logo=google-chrome&logoColor=white)](https://fieldopsapp.web.app)
[![Lisans](https://img.shields.io/badge/Lisans-MIT-blue.svg?style=for-the-badge)](LICENSE)
[![Teknoloji](https://img.shields.io/badge/Teknoloji-Vanilla_ES6%2B_No_Framework-yellow?style=for-the-badge&logo=javascript)](https://developer.mozilla.org)
[![Arayüz](https://img.shields.io/badge/Tasar%C4%B1m-End%C3%BCstriyel_Split_Screen-amber?style=for-the-badge&logo=css3)](https://developer.mozilla.org)
[![Dil](https://img.shields.io/badge/Dil-T%C3%BCrk%C3%A7e_%7C_English-green?style=for-the-badge)](https://fieldopsapp.web.app)

---

## 📸 Canlı Önizleme (Previews)

### 1. İki Kolonlu Saha Sevk & Denetim Konsolu (Split-Screen)
Sol kolonda filtrelenebilir iş emri sevk listesi, sağ kolonda canlı GPS doğrulaması, ISO-9001 denetim formu ve **İş Emrini Sil** aksiyonu:
![FieldOps Konsol Önizleme](docs/preview-dashboard.png)

### 2. Endüstriyel Dispatcher Giriş Terminali (Rugged Terminal)
Sarı/siyah güvenlik tehlike şeridi (hazard stripes), canlı GPS koordinat şeridi, RF-ID / personel sicil no alanları ve önceden tanımlı roller:
![FieldOps Login Önizleme](docs/preview-login.png)

---

## 🌟 Öne Çıkan Özellikler

### 1. Sektöre Özgü Endüstriyel Dispatcher Mimarisi
- **İki Kolonlu Saha Konsolu (Split-Screen)**:
  - **Sol Kolon (`.fo-orders-pane`)**: Aciliyet seviyelerine göre filtrelenebilir iş emirleri listesi (Kritik, İşlemde, Tamamlandı), arama çubuğu ve görev sayaçları.
  - **Sağ Kolon (`.fo-studio-pane`)**: Seçili iş emrinin detaylı inceleme stüdyosu; canlı GPS koordinat okuyucu, ISO-9001 muayene kriterleri onay kutuları ve teknisyen dijital imza alanı.
- **Canlı Telemetri & SQLite Kuyruğu**: Saha bağlantısı kopsa dahi çevrimdışı iş emri kuyruğunu simüle eden durum bandı.

### 2. Güvenli İş Emri Silme (Order Deletion) Mekanizması
- **Belirgin Silme Butonu**: İnceleme stüdyosunun sağ üstünde "Denetimi Tamamla" butonunun hemen yanında kırmızı etiketli **"İş Emrini Sil" (`bi-trash3`)** butonu yer alır.
- **Onay Modalı (`#deleteConfirmModal`)**: İstem dışı silmeleri önlemek için iş emri koduyla birlikte onay penceresi açılır.
- **Reaktif Metrik Güncellemesi**: Silinen iş emri listeden düşer, `localStorage` (`fo_orders`) güncellenir; aktif, kritik ve kuyruk sayaçları anında otomatik yeniden toplanır.

### 3. Oturum Kalıcılığı (Session Persistence) & Zero-Flicker Başlangıç
- **Sayfa Yenilemelerinde Oturumu Hatırla**: Giriş başarılı olduğunda `localStorage.setItem('fo_logged_in', 'true')` kaydı işlenir.
- **Sıfır Titreme (Zero-Flicker)**: Sayfa yenilendiğinde (F5) inline script kontrolü sayesinde giriş ekranı hiç açılmadan doğrudan operasyon masası gelir.
- **Güvenli Çıkış**: Sağ üstteki kırmızı **"Çıkış"** butonuna basıldığında oturum sıfırlanır ve giriş terminaline güvenle dönülür.
- **Hazır Demo Bilgileri**: Giriş ekranında e-posta ve şifre hazır girili gelir; altındaki hızlı rol butonlarıyla (`Saha Sorumlusu`, `Teknisyen / Kullanıcı`, `Kurumsal Müşteri`) tek tıkla kimlik değiştirilebilir.

### 4. Çift Dilli Tam Destek (TR | EN)
- Sağ üstteki `[ TR | EN ]` dil seçici ile tüm saha kontrolleri, iş emri detayları, modal başlıkları ve bildirimler dinamik olarak çevrilir.
- Başlangıç varsayılan dili **Türkçe**'dir.

---

## 🛠️ Teknoloji Yığını (Tech Stack)

| Katman | Teknoloji | Rolü |
| :--- | :--- | :--- |
| **Arayüz (UI)** | HTML5, CSS3, Flexbox & CSS Grid | Endüstriyel amber ve antrasit renk paletine sahip split-screen konsol |
| **İş Mantığı** | Vanilla JavaScript (ES6+) | Reaktif iş emri filtreleme, denetim onayı ve imza yönetimi |
| **İkonlar** | Bootstrap Icons v1.11.3 | Vektörel sistem ikonları |
| **Veri Depolama** | HTML5 `localStorage` | İş emirleri, oturum bilgileri ve dil tercihleri |
| **Hosting** | Firebase Hosting | Google altyapısı üzerinde yüksek erişilebilir statik dağıtım |

---

## 📁 Proje Dizin Yapısı

```
FieldOps/
├── index.html              # Bağımsız ve optimize edilmiş tek sayfa uygulama
├── docs/                   # Dokümantasyon ve ekran görüntüleri
│   ├── preview-dashboard.png # Saha sevk konsolu yüksek çözünürlüklü önizleme
│   └── preview-login.png     # Dispatcher terminal giriş ekranı önizleme
└── README.md               # Proje dokümantasyonu
```

---

## ⚡ Hızlı Başlangıç (Local Setup)

1. Depoyu yerel bilgisayarınıza indirin:
   ```bash
   git clone https://github.com/kubrvk/FieldOps.git
   cd FieldOps
   ```
2. `index.html` dosyasını tarayıcınızda açın:
   ```bash
   start index.html
   ```
3. Alternatif yerel HTTP sunucusu ile çalıştırmak için:
   ```bash
   npx serve .
   ```
4. Tarayıcınızda açılan adrese gidin.
   - *Giriş ekranını atlayıp doğrudan konsolu açmak için:* `http://localhost:3000/?demo=1`

---

## 🌐 Canlı Sistem

- **Canlı URL**: [https://fieldopsapp.web.app](https://fieldopsapp.web.app)
- **Doğrudan Demo Bağlantısı**: [https://fieldopsapp.web.app/?demo=1](https://fieldopsapp.web.app/?demo=1)

---

## 👤 Geliştirici

**Developed by Beraat Yetkin**
- GitHub: [@kubrvk](https://github.com/kubrvk)
- Proje Deposu: [FieldOps](https://github.com/kubrvk/FieldOps)
- Portfolyo: [Beraat Yetkin Portfolio](https://github.com/kubrvk/portfolio)
