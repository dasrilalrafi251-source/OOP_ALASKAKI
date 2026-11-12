import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Mengelola katalog produk dan ringkasan transaksi untuk setiap pelanggan.
public class KatalogToko {
    // HashMap menyimpan produk berdasarkan kode agar pencarian berdasarkan kunci mudah dilakukan.
    private Map<String, AlasKaki> daftarBarang = new HashMap<>();
    // HashMap kedua menyimpan daftar transaksi dengan nama pelanggan sebagai kunci.
    private Map<String, List<TransaksiPembelian>> riwayatPelanggan = new HashMap<>();

    // Memasukkan produk ke katalog; kode produk menjadi kunci HashMap.
    public void tambahBarang(AlasKaki produk) {
        if (produk == null) {
            throw new IllegalArgumentException("Produk tidak boleh null.");
        }
        daftarBarang.put(produk.getKodeProduk(), produk);
    }

    // Mencari produk berdasarkan kode dan melempar custom exception jika tidak ada.
    public AlasKaki cariBarang(String kodeProduk) throws ProdukTidakDitemukan {
        if (!daftarBarang.containsKey(kodeProduk)) {
            throw new ProdukTidakDitemukan(
                    "Produk dengan kode '" + kodeProduk + "' tidak ditemukan di katalog!"
            );
        }
        return daftarBarang.get(kodeProduk);
    }

    // Menampilkan semua produk; values() mengambil isi HashMap tanpa kunci.
    public void tampilkanKatalog() {
        System.out.println("=== DAFTAR KATALOG BARANG TOKO ===");
        for (AlasKaki item : daftarBarang.values()) {
            System.out.println("- [" + item.getKodeProduk() + "] "
                    + item.getMerk() + " | Harga: Rp " + item.getHarga()
                    + " | Kelas: " + item.getClass().getSimpleName());
        }
        System.out.println("Total Jenis Barang: " + daftarBarang.size());
        System.out.println("----------------------------------------");
    }

    // Mencatat transaksi pelanggan; computeIfAbsent membuat daftar baru saat diperlukan.
    public void catatTransaksiPelanggan(String namaPelanggan, TransaksiPembelian trx) {
        if (namaPelanggan == null || namaPelanggan.isBlank() || trx == null) {
            throw new IllegalArgumentException("Nama pelanggan dan transaksi wajib diisi.");
        }
        riwayatPelanggan.computeIfAbsent(namaPelanggan, k -> new ArrayList<>()).add(trx);
    }

    // Menjumlahkan nilai seluruh transaksi milik pelanggan, atau 0 jika belum ada.
    public double hitungTotalBelanja(String namaPelanggan) {
        List<TransaksiPembelian> daftar = riwayatPelanggan.get(namaPelanggan);
        if (daftar == null || daftar.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (TransaksiPembelian trx : daftar) {
            total += trx.hitungTotal();
        }
        return total;
    }

    // Menemukan dan menampilkan semua pelanggan yang memiliki total belanja tertinggi.
    public void tampilkanPelangganTertinggi() {
        if (riwayatPelanggan.isEmpty()) {
            System.out.println("Belum ada riwayat transaksi pelanggan.");
            return;
        }

        double tertinggi = -1;
        for (String nama : riwayatPelanggan.keySet()) {
            tertinggi = Math.max(tertinggi, hitungTotalBelanja(nama));
        }

        System.out.println("=== PELANGGAN DENGAN BELANJA TERTINGGI ===");
        for (String nama : riwayatPelanggan.keySet()) {
            if (Double.compare(hitungTotalBelanja(nama), tertinggi) == 0) {
                System.out.println("Nama Pelanggan : " + nama);
                System.out.println("Jumlah Transaksi: " + riwayatPelanggan.get(nama).size());
                System.out.println("Total Belanja  : Rp " + tertinggi);
                System.out.println("----------------------------------------");
            }
        }
    }
}
