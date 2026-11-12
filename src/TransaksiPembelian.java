// Mewakili transaksi pembelian satu jenis produk alas kaki.
// Menyimpan kode transaksi, produk, jumlah pasang, dan total pembayaran.
public class TransaksiPembelian {
    private String kodeTransaksi;
    private AlasKaki alasKaki;
    private int jumlahPasang;
    private static int jumlahTransaksi = 0;

    // Membuat transaksi dengan kode, produk, dan jumlah pasang tertentu.
    // Kode tidak boleh kosong, produk tidak boleh null, dan jumlah harus positif.
    public TransaksiPembelian(String kodeTransaksi, AlasKaki alasKaki, int jumlahPasang) {
        if (kodeTransaksi == null || kodeTransaksi.isBlank()) {
            throw new IllegalArgumentException("Kode transaksi tidak boleh kosong.");
        }
        if (alasKaki == null) {
            throw new IllegalArgumentException("Produk transaksi tidak boleh null.");
        }
        if (jumlahPasang <= 0) {
            throw new IllegalArgumentException("Jumlah pasang harus lebih besar dari 0.");
        }
        this.kodeTransaksi = kodeTransaksi;
        this.alasKaki = alasKaki;
        this.jumlahPasang = jumlahPasang;
        jumlahTransaksi++;
    }

    // Membuat transaksi dengan jumlah default satu pasang.
    public TransaksiPembelian(String kodeTransaksi, AlasKaki alasKaki) {
        this(kodeTransaksi, alasKaki, 1);
    }

    // Mengubah jumlah pasang. Jumlah harus lebih besar dari nol.
    public void setJumlahPasang(int jumlahPasang) {
        if (jumlahPasang <= 0) {
            throw new IllegalArgumentException("Jumlah pasang harus lebih besar dari 0.");
        }
        this.jumlahPasang = jumlahPasang;
    }

    // Mengembalikan jumlah pasang pada transaksi.
    public int getJumlahPasang() {
        return jumlahPasang;
    }

    // Mengembalikan jumlah transaksi yang telah dibuat.
    public static int getJumlahTransaksi() {
        return jumlahTransaksi;
    }

    // Menghitung total harga produk dikali jumlah pasang.
    public double hitungTotal() {
        return alasKaki.getHarga() * jumlahPasang;
    }

    // Menampilkan rincian transaksi dan total pembayaran ke konsol.
    public void tampilkanInfo() {
        System.out.println("Kode Transaksi : " + kodeTransaksi);
        System.out.println("Kode Produk    : " + alasKaki.getKodeProduk());
        System.out.println("Merk           : " + alasKaki.getMerk());
        System.out.println("Harga per Pasang: Rp " + alasKaki.getHarga());
        System.out.println("Jumlah Pasang  : " + jumlahPasang);
        System.out.println("Total Bayar    : Rp " + hitungTotal());
        System.out.println("----------------------------------------");
    }
}
