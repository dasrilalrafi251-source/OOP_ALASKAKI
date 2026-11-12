// Produk spesifik sendal gunung; mewarisi sifat sendal luar ruang.
public class SendalGunung extends SendalOutdoor {
    // Constructor meneruskan seluruh data produk ke constructor class induk.
    public SendalGunung(String kodeProduk, String merk, double harga,
                        String jenisSendal, String dayaCengkeramSol) {
        super(kodeProduk, merk, harga, jenisSendal, dayaCengkeramSol);
    }
}
