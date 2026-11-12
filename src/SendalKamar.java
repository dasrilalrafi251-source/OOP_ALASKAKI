// Produk spesifik sendal kamar yang mewarisi atribut sendal indoor.
public class SendalKamar extends SendalIndoor {
    // Constructor memakai validasi dan inisialisasi dari class induk.
    public SendalKamar(String kodeProduk, String merk, double harga,
                       String jenisSendal, String bahanBantalanEmpuk) {
        super(kodeProduk, merk, harga, jenisSendal, bahanBantalanEmpuk);
    }
}
