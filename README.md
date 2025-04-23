# 📜Game Konsol "UlarKata" (C#)

## 🧠 Pengertian dan Tujuan Kode

Kode ini adalah implementasi game konsol **"UlarKata"**, sebuah permainan sederhana seperti Snake namun dengan sentuhan personal: tubuh ular dibentuk dari huruf-huruf nama pemain. Tujuan dari kode ini adalah:

- Menghibur pengguna dengan gameplay yang ringan dan personal.
- Menggunakan dasar-dasar pemrograman C# seperti **koleksi**, **struktur kontrol**, **I/O file**, dan **logika game loop**.
- Menyimpan skor tertinggi agar pemain bisa melihat pencapaiannya.

---

## 🧾 Penjelasan Tiap Bagian Kode

### `Main`
- Loop utama yang terus menampilkan menu.
- Menangani input tombol dari pengguna (`1`, `2`, `3`, `ESC`) untuk mengakses fitur game.

### `ShowMenu()`
- Membersihkan layar dan menampilkan opsi menu utama.

### `StartGame()`
- Inti dari gameplay:
  - Meminta nama pengguna.
  - Menginisialisasi ular dengan huruf dari nama pemain.
  - Menampilkan dan menggerakkan ular di area permainan.
  - Menangani input arah (panah).
  - Menambah panjang ular ketika "buah" dimakan.
  - Mendeteksi tabrakan dengan batas atau rintangan berbentuk karakter unik (★, ■, dll).
  - Menyimpan skor saat game selesai.

### `DrawBoundary()`
- Menggambar batas horizontal (`=`) dan vertikal (`|`) dari area bermain.

### `GetRandomShape()`
- Mengembalikan karakter acak dari daftar bentuk unik untuk ditambahkan sebagai rintangan.

### `CheckCollisionWithShapes()`
- Mengecek apakah kepala ular bertabrakan dengan bentuk yang ditambahkan ke layar.

### `ShowHighScores()` dan `DeleteHighScores()`
- Bekerja dengan file `highscores.txt` untuk menampilkan atau menghapus skor.

### `SaveScore()`
- Menyimpan skor ke file dengan format: `Nama: Skor`.

---

## 🧩 Analogi Sederhana Algoritma

Bayangkan kamu sedang bermain dengan mainan ular magnetik:
- Setiap huruf dalam nama kamu adalah potongan tubuh ular.
- Ular itu bergerak di lantai berpola (layar konsol).
- Setiap kali ular makan bola (buah), ia tumbuh lebih panjang dan bisa menabrak benda (bentuk acak) di lantai.
- Kamu mengendalikan arah ular, tapi tidak bisa membuatnya berbalik langsung (misalnya dari kiri langsung ke kanan).

Ini seperti mengendalikan kereta yang makin panjang setiap kali memuat penumpang, dan harus hati-hati supaya tidak menabrak tembok atau penghalang.

---

## ✅ Kesimpulan

Game **UlarKata** menunjukkan bagaimana logika permainan sederhana bisa dibangun dengan bahasa C#. Melalui penggunaan struktur data dasar (`List`, `Tuple`), logika kontrol, dan file handling, permainan ini menjadi media belajar yang menyenangkan sekaligus praktis. Konsep personalisasi melalui nama pemain juga menambah kedekatan emosional dengan pengguna.
