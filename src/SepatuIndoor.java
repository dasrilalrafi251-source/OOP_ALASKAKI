// Kelompok sepatu indoor yang memiliki atribut sol non-marking.
public class SepatuIndoor extends Sepatu {
    // Menandakan apakah sol tidak meninggalkan bekas pada lantai.
    private boolean solNonMarking;

    // Constructor mengisi data dasar sepatu dan status sol.
    public SepatuIndoor(String kodeProduk, String merk, double harga,
                        int ukuran, boolean solNonMarking) {
        super(kodeProduk, merk, harga, ukuran);
        this.solNonMarking = solNonMarking;
    }

    // Getter boolean menggunakan awalan is untuk membaca status sol.
    public boolean isSolNonMarking() {
        return solNonMarking;
    }

    // Override menampilkan atribut tambahan setelah informasi dasar sepatu.
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Sol Non-Marking: " + (solNonMarking ? "Ya" : "Tidak"));
    }
}
