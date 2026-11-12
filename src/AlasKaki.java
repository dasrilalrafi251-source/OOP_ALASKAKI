// Kelas induk untuk semua produk; menunjukkan enkapsulasi melalui atribut private.
public class AlasKaki {
    // Data identitas dan harga disimpan private agar diakses lewat method publik.
    private String kodeProduk;
    private String merk;
    private double harga;

    // Constructor mengisi data umum dan memvalidasi nilai sebelum objek digunakan.
    public AlasKaki(String kodeProduk, String merk, double harga) {
        if (kodeProduk == null || kodeProduk.isBlank()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        if (merk == null || merk.isBlank()) {
            throw new IllegalArgumentException("Merk tidak boleh kosong.");
        }
        this.kodeProduk = kodeProduk;
        this.merk = merk;
        setHarga(harga);
    }

    // Getter menyediakan akses baca tanpa membuka atribut secara langsung.
    public String getKodeProduk() {
        return kodeProduk;
    }

    public String getMerk() {
        return merk;
    }

    public double getHarga() {
        return harga;
    }

    // Setter mengendalikan perubahan harga agar nilainya tidak negatif.
    public void setHarga(double harga) {
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif.");
        }
        this.harga = harga;
    }

    // Menampilkan informasi umum; dapat dioverride oleh class turunannya.
    public void tampilkanInfo() {
        System.out.println("Kode Produk : " + kodeProduk);
        System.out.println("Merk        : " + merk);
        System.out.println("Harga       : Rp " + harga);
    }
}
