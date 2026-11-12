// Produk spesifik sendal jepit yang termasuk kelompok sendal outdoor.
public class SendalJepit extends SendalOutdoor {
    // Constructor meneruskan data produk dan daya cengkeram ke class induk.
    public SendalJepit(String kodeProduk, String merk, double harga,
                       String jenisSendal, String dayaCengkeramSol) {
        super(kodeProduk, merk, harga, jenisSendal, dayaCengkeramSol);
    }
}
