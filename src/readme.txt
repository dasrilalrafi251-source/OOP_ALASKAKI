PROYEK TOKO ALAS KAKI - JAVA OOP

PENJELASAN MATERI DAN FUNGSI SETIAP FILE

1. AlasKaki.java
   Class induk untuk semua produk. Menyimpan kode produk, merk, dan harga.
   Contoh enkapsulasi melalui atribut private, getter, setter harga, validasi
   data pada constructor, dan method tampilkanInfo().

2. Sepatu.java
   Class dasar untuk produk sepatu yang mewarisi AlasKaki. Menambahkan atribut
   ukuran, getter ukuran, dan informasi khusus sepatu.

3. SepatuIndoor.java
   Class turunan Sepatu untuk kategori sepatu indoor. Menyimpan status sol
   non-marking dan meng-override tampilkanInfo() untuk menampilkan informasi itu.

4. SepatuOutdoor.java
   Class turunan Sepatu untuk kategori sepatu outdoor. Menyimpan status
   waterproof dan menambahkannya pada tampilan informasi produk.

5. SepatuFutsal.java
   Class produk spesifik sepatu futsal. Mewarisi data dan perilaku SepatuIndoor.

6. SepatuPantofel.java
   Class produk spesifik sepatu pantofel. Mewarisi data dan perilaku
   SepatuIndoor.

7. SepatuLari.java
   Class produk spesifik sepatu lari. Mewarisi data dan perilaku SepatuOutdoor.

8. SepatuGunung.java
   Class produk spesifik sepatu gunung. Mewarisi data dan perilaku
   SepatuOutdoor.

9. Sendal.java
   Class dasar untuk produk sendal yang mewarisi AlasKaki. Menambahkan jenis
   sendal dan meng-override tampilkanInfo() untuk memasukkan informasi tersebut.

10. SendalIndoor.java
    Class turunan Sendal untuk kategori sendal indoor. Menyimpan bahan bantalan
    empuk dan menambahkannya pada informasi produk.

11. SendalOutdoor.java
    Class turunan Sendal untuk kategori sendal outdoor. Menyimpan informasi
    daya cengkeram sol dan menambahkannya pada informasi produk.

12. SendalKamar.java
    Class produk spesifik sendal kamar yang mewarisi SendalIndoor.

13. SendalTerapi.java
    Class produk spesifik sendal terapi yang mewarisi SendalIndoor.

14. SendalGunung.java
    Class produk spesifik sendal gunung yang mewarisi SendalOutdoor.

15. SendalJepit.java
    Class produk spesifik sendal jepit yang mewarisi SendalOutdoor.

16. TransaksiPembelian.java
    Mewakili pembelian produk. Menyimpan kode transaksi, referensi produk
    AlasKaki, dan jumlah pasang. Contoh agregasi, constructor overloading,
    atribut static untuk menghitung transaksi, validasi jumlah, perhitungan
    total pembayaran, dan penampilan detail transaksi.

17. ProdukTidakDitemukan.java
    Custom checked exception untuk memberi tahu bahwa kode produk tidak ada
    di katalog. Pesan kesalahan diteruskan ke class Exception.

18. KatalogToko.java
    Mengelola katalog produk dan riwayat transaksi pelanggan. Menggunakan
    HashMap (struktur data berbasis pasangan kunci-nilai/hash table) untuk
    mencari produk dengan kode dan menyimpan transaksi per nama pelanggan.
    Class ini juga mencatat transaksi, menghitung total belanja, menampilkan
    katalog, serta mencari pelanggan dengan belanja tertinggi.

19. Main.java
    Titik awal program (method main) dan contoh penggunaan seluruh class.
    Membuat produk, menunjukkan inheritance dan polymorphism, membuat transaksi,
    menguji pencarian katalog serta custom exception, dan menampilkan pelanggan
    dengan total belanja tertinggi. Setelah alur toko, file ini otomatis
    menjalankan demo materi Java tambahan dengan produk yang sama.

MATERI OOP YANG DIGUNAKAN
- Inheritance (pewarisan): class produk memakai data/perilaku dari class induk.
- Encapsulation (enkapsulasi): atribut dibuat private dan diakses melalui method.
- Polymorphism: objek berbagai class produk diproses melalui tipe AlasKaki;
  method tampilkanInfo() menampilkan informasi sesuai class objeknya.
- Aggregation (agregasi): TransaksiPembelian menyimpan referensi ke objek produk.
- Collection: List menyimpan kelompok produk/transaksi dan HashMap menyimpan
  data berdasarkan kunci.
- Custom exception: ProdukTidakDitemukan menangani kegagalan pencarian produk.

MATERI JAVA TAMBAHAN DI MAIN.JAVA
Demo materi tambahan berjalan otomatis setelah program toko saat menjalankan
`java Main`. Demo menggunakan kembali produk S001 (Nike) dan daftar produk
katalog, bukan membuat produk contoh terpisah:
- Default constructor menggunakan class helper tanpa constructor tertulis.
- Abstract class, abstract method, interface, dan implementasi beberapa interface.
- Constructor chaining dengan super dan this; overriding serta method overloading.
- Keyword final pada field dan method.
- Upcasting/downcasting, instanceof, polymorphism, dan dynamic dispatch pada
  produk serta adapter kemampuan demo.
- Association dan composition menggunakan kode/merk produk katalog.
- Collection LinkedList dan HashSet diisi dari objek produk katalog; List,
  HashMap, dan generics juga digunakan pada fitur toko.
- Beberapa blok catch dan finally. Argumen command line opsional menguji input.

CARA MENJALANKAN
1. Simpan semua file .java dalam satu folder.
2. Buka terminal pada folder tersebut.
3. Kompilasi: javac *.java
4. Jalankan: java Main
   Program toko dan demo materi tambahan berjalan berurutan.
   Contoh uji input bukan angka untuk demo: java Main abc
   Contoh uji pembagian dengan nol untuk demo: java Main 0

CATATAN
- Semua class menggunakan package default (tidak ada deklarasi package).
- Nama file harus sama persis dengan nama public class.
- Materi instalasi JDK/IDE dan langkah penggunaan lingkungan praktikum bukan
  bagian dari kode proyek, sehingga tidak didemonstrasikan oleh source code.
