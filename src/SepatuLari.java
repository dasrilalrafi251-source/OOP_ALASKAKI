// Produk spesifik sepatu lari yang termasuk kategori sepatu outdoor.
public class SepatuLari extends SepatuOutdoor {
    // Constructor meneruskan data sepatu dan status waterproof ke induk.
    public SepatuLari(String kodeProduk, String merk, double harga,
                      int ukuran, boolean isWaterproof) {
        super(kodeProduk, merk, harga, ukuran, isWaterproof);
    }
}
