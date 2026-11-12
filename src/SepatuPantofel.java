// Produk spesifik sepatu pantofel yang mewarisi atribut sepatu indoor.
public class SepatuPantofel extends SepatuIndoor {
    // Constructor meneruskan data sepatu dan status sol non-marking ke induk.
    public SepatuPantofel(String kodeProduk, String merk, double harga,
                          int ukuran, boolean solNonMarking) {
        super(kodeProduk, merk, harga, ukuran, solNonMarking);
    }
}
