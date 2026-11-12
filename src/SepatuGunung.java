// Produk spesifik sepatu gunung yang termasuk kategori sepatu outdoor.
public class SepatuGunung extends SepatuOutdoor {
    // Constructor meneruskan data sepatu dan status waterproof ke induk.
    public SepatuGunung(String kodeProduk, String merk, double harga,
                        int ukuran, boolean isWaterproof) {
        super(kodeProduk, merk, harga, ukuran, isWaterproof);
    }
}
