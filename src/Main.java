import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Titik awal program sekaligus demonstrasi konsep-konsep OOP pada proyek.
public class Main {
    // Method main dijalankan pertama kali oleh Java.
    public static void main(String[] args) {
        // Membuat objek dari class turunan; setiap class mewarisi data dan perilaku induknya.
        SepatuFutsal sepatuFutsal =
                new SepatuFutsal("S001", "Nike", 500000.0, 42, true);
        SepatuPantofel sepatuPantofel =
                new SepatuPantofel("S002", "Bata", 350000.0, 41, false);
        SepatuLari sepatuLari =
                new SepatuLari("S003", "Adidas", 750000.0, 43, false);
        SepatuGunung sepatuGunung =
                new SepatuGunung("S004", "Eiger", 900000.0, 42, true);

        SendalTerapi sendalTerapi =
                new SendalTerapi("D001", "Skechers", 250000.0, "Terapi", "Memory foam");
        SendalKamar sendalKamar =
                new SendalKamar("D002", "Swallow", 30000.0, "Kamar", "Busa");
        SendalGunung sendalGunung =
                new SendalGunung("D003", "Eiger", 200000.0, "Gunung", "Karet bergerigi");
        SendalJepit sendalJepit =
                new SendalJepit("D004", "Swallow", 25000.0, "Jepit", "Karet");

        // Polymorphism: objek berbagai class turunan diperlakukan sebagai tipe AlasKaki.
        List<AlasKaki> semuaProduk = Arrays.asList(
                sepatuFutsal, sepatuPantofel, sepatuLari, sepatuGunung,
                sendalTerapi, sendalKamar, sendalGunung, sendalJepit
        );

        System.out.println("=== DEMO POLYMORPHISM & INFORMASI PRODUK ===");
        for (AlasKaki produk : semuaProduk) {
            System.out.println("\nClass: " + produk.getClass().getSimpleName());
            produk.tampilkanInfo();
        }

        // Aggregation: transaksi menyimpan referensi ke objek produk yang dibuat terpisah.
        TransaksiPembelian transaksi1 =
                new TransaksiPembelian("TRX-01", sepatuFutsal, 2);
        TransaksiPembelian transaksi2 =
                new TransaksiPembelian("TRX-02", sendalJepit);

        System.out.println("\n=== INFORMASI TRANSAKSI 1 ===");
        transaksi1.tampilkanInfo();
        System.out.println("=== INFORMASI TRANSAKSI 2 ===");
        transaksi2.tampilkanInfo();
        System.out.println("Total Transaksi Dibuat: "
                + TransaksiPembelian.getJumlahTransaksi());

        // Collection: katalog dan riwayat pelanggan dikelola dengan HashMap di KatalogToko.
        KatalogToko katalog = new KatalogToko();
        for (AlasKaki produk : semuaProduk) {
            katalog.tambahBarang(produk);
        }
        katalog.tampilkanKatalog();

        // Custom exception: pencarian kode yang tidak ditemukan ditangani dengan catch.
        String[] kodeUji = {"S003", "X999"};
        for (String kode : kodeUji) {
            try {
                AlasKaki ditemukan = katalog.cariBarang(kode);
                System.out.println("[DITEMUKAN] " + kode + " -> "
                        + ditemukan.getMerk() + " (Rp " + ditemukan.getHarga() + ")");
            } catch (ProdukTidakDitemukan e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }

        // Menambahkan transaksi ke riwayat pelanggan, lalu mencari total belanja tertinggi.
        katalog.catatTransaksiPelanggan("Andi", transaksi1);
        katalog.catatTransaksiPelanggan("Andi", transaksi2);
        TransaksiPembelian transaksi3 =
                new TransaksiPembelian("TRX-03", sepatuLari, 1);
        katalog.catatTransaksiPelanggan("Budi", transaksi3);

        katalog.tampilkanPelangganTertinggi();

        // Materi tambahan berjalan otomatis setelah alur utama toko selesai.
        System.out.println("\n=== DEMO MATERI JAVA TAMBAHAN ===");
        jalankanDemoMateriTambahan(args, sepatuFutsal, semuaProduk);
    }

    // Menjalankan contoh konsep Java yang bukan bagian langsung dari alur toko.
    private static void jalankanDemoMateriTambahan(
            String[] args, AlasKaki produkToko, List<AlasKaki> semuaProduk) {
        // Class tanpa constructor tertulis memperoleh default constructor dari Java.
        ContohDefaultConstructor contohDefault = new ContohDefaultConstructor();
        System.out.println("Default constructor: "
                + contohDefault.getClass().getSimpleName());

        // Adapter memakai produk katalog asli sebagai data untuk abstract class dan interface.
        ProdukDemo produk = new ProdukDenganKemampuan(produkToko);

        // Dynamic dispatch memilih implementasi berdasarkan class objek sebenarnya.
        produk.tampilkanInfo();
        produk.tampilkanInfo(true);

        // Upcasting dan downcasting memakai objek produk asli dari katalog.
        if (produkToko instanceof SepatuFutsal) {
            SepatuFutsal sepatu = (SepatuFutsal) produkToko;
            System.out.println("Ukuran sepatu " + sepatu.getKodeProduk()
                    + ": " + sepatu.getUkuran());
        }

        // Downcasting ke adapter mengambil kemampuan interface yang diimplementasikannya.
        if (produk instanceof ProdukDenganKemampuan) {
            ProdukDenganKemampuan produkBerfitur = (ProdukDenganKemampuan) produk;
            System.out.println("Diskon 10%: Rp " + produkBerfitur.hitungDiskon(10));
            System.out.println("Biaya kirim: Rp " + produkBerfitur.hitungBiayaKirim());
        }

        // Association: layanan menerima objek produk katalog yang sama.
        new LayananInfo().cetakLabel(produkToko);

        // Composition: paket membuat komponen detail dari data produk katalog.
        PaketProduk paket = new PaketProduk(produkToko);
        System.out.println("Komposisi: " + paket.getDeskripsi());

        // LinkedList menyimpan objek produk dan mempertahankan urutan penambahannya.
        LinkedList<AlasKaki> antrean = new LinkedList<>(semuaProduk);
        System.out.println("LinkedList kode produk: ");
        for (AlasKaki item : antrean) {
            System.out.println("- " + item.getKodeProduk() + " " + item.getMerk());
        }

        // HashSet mengumpulkan nama class produk unik dari katalog yang sama.
        Set<String> kategoriUnik = new HashSet<>();
        for (AlasKaki item : semuaProduk) {
            kategoriUnik.add(item.getClass().getSimpleName());
        }
        kategoriUnik.add(produkToko.getClass().getSimpleName());
        System.out.println("HashSet class produk unik: " + kategoriUnik);

        // Argumen pertama dapat menguji input angka, pembagi nol, atau input non-angka.
        String nilaiPembagi = args.length > 0 && !"--demo".equals(args[0])
                ? args[0] : "2";
        try {
            int pembagi = Integer.parseInt(nilaiPembagi);
            System.out.println("Hasil pembagian: " + (100 / pembagi));
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka bulat.");
        } catch (ArithmeticException e) {
            System.out.println("Pembagi tidak boleh nol.");
        } finally {
            System.out.println("Blok finally selalu dijalankan.");
        }
    }

    // Tidak ada constructor tertulis sehingga Java menyediakan default constructor.
    private static class ContohDefaultConstructor {
    }

    // Abstract class membungkus produk nyata dan menyediakan perilaku umum demo.
    private static abstract class ProdukDemo {
        private final AlasKaki produk;

        protected ProdukDemo(AlasKaki produk) {
            this.produk = produk;
        }

        public abstract void tampilkanInfo();

        // Method overloading: nama sama, parameter berbeda.
        public void tampilkanInfo(boolean tampilkanHarga) {
            tampilkanInfo();
            if (tampilkanHarga) {
                System.out.println("Harga: Rp " + produk.getHarga());
            }
        }

        // final menjaga agar adapter selalu memakai referensi produk yang sama.
        public final AlasKaki getProduk() {
            return produk;
        }

        protected double getHarga() {
            return produk.getHarga();
        }
    }

    // Interface mendefinisikan kontrak kemampuan yang dapat diterapkan oleh class.
    private interface BisaDiskon {
        double hitungDiskon(double persentase);
    }

    private interface BisaDikirim {
        double hitungBiayaKirim();
    }

    // Adapter meng-override abstract method dan memberi kemampuan pada produk katalog.
    private static class ProdukDenganKemampuan extends ProdukDemo
            implements BisaDiskon, BisaDikirim {
        private ProdukDenganKemampuan(AlasKaki produk) {
            super(produk);
        }

        @Override
        public void tampilkanInfo() {
            getProduk().tampilkanInfo();
        }

        @Override
        public double hitungDiskon(double persentase) {
            return getHarga() * persentase / 100;
        }

        @Override
        public double hitungBiayaKirim() {
            return 15000;
        }
    }

    // Association ditunjukkan dengan menerima objek produk melalui parameter.
    private static class LayananInfo {
        private void cetakLabel(AlasKaki produk) {
            System.out.println("Label layanan: " + produk.getKodeProduk()
                    + " - " + produk.getMerk());
        }
    }

    // Composition: objek detail dimiliki dan dibuat di dalam PaketProduk.
    private static class PaketProduk {
        private final DetailPaket detail;

        private PaketProduk(AlasKaki produk) {
            detail = new DetailPaket(produk.getKodeProduk(), produk.getMerk());
        }

        private String getDeskripsi() {
            return detail.getDeskripsi();
        }
    }

    private static class DetailPaket {
        private final String kodeProduk;
        private final String merk;

        private DetailPaket(String kodeProduk, String merk) {
            this.kodeProduk = kodeProduk;
            this.merk = merk;
        }

        private String getDeskripsi() {
            return kodeProduk + " - " + merk;
        }
    }
}
