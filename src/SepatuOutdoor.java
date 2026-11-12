// Kelompok sepatu luar ruang dengan atribut status tahan air.
public class SepatuOutdoor extends Sepatu {
    // Menyimpan apakah sepatu memiliki perlindungan waterproof.
    private boolean isWaterproof;

    // Constructor mengisi data dasar sepatu dan status tahan air.
    public SepatuOutdoor(String kodeProduk, String merk, double harga,
                         int ukuran, boolean isWaterproof) {
        super(kodeProduk, merk, harga, ukuran);
        this.isWaterproof = isWaterproof;
    }

    // Getter boolean untuk membaca status waterproof.
    public boolean isWaterproof() {
        return isWaterproof;
    }

    // Override menambahkan informasi waterproof pada detail sepatu.
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Waterproof   : " + (isWaterproof ? "Ya" : "Tidak"));
    }
}
