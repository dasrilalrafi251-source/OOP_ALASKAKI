// Produk spesifik sendal terapi yang menggunakan data sendal indoor.
public class SendalTerapi extends SendalIndoor {
    // Constructor meneruskan data ke SendalIndoor untuk validasi dan inisialisasi.
    public SendalTerapi(String kodeProduk, String merk, double harga,
                        String jenisSendal, String bahanBantalanEmpuk) {
        super(kodeProduk, merk, harga, jenisSendal, bahanBantalanEmpuk);
    }
}
