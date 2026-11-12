// Produk spesifik sepatu futsal yang mewarisi atribut sepatu indoor.
public class SepatuFutsal extends SepatuIndoor {
    // Constructor meneruskan data sepatu dan status sol non-marking ke induk.
    public SepatuFutsal(String kodeProduk, String merk, double harga,
                        int ukuran, boolean solNonMarking) {
        super(kodeProduk, merk, harga, ukuran, solNonMarking);
    }
}
