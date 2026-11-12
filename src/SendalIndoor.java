// Kelompok sendal untuk penggunaan dalam ruangan, dengan data bahan bantalan.
public class SendalIndoor extends Sendal {
    // Menyimpan bahan bantalan yang khusus untuk sendal indoor.
    private String bahanBantalanEmpuk;

    // Constructor mengisi data induk dan memvalidasi bahan bantalan.
    public SendalIndoor(String kodeProduk, String merk, double harga,
                        String jenisSendal, String bahanBantalanEmpuk) {
        super(kodeProduk, merk, harga, jenisSendal);
        if (bahanBantalanEmpuk == null || bahanBantalanEmpuk.isBlank()) {
            throw new IllegalArgumentException("Bahan bantalan tidak boleh kosong.");
        }
        this.bahanBantalanEmpuk = bahanBantalanEmpuk;
    }

    // Getter untuk membaca bahan bantalan.
    public String getBahanBantalanEmpuk() {
        return bahanBantalanEmpuk;
    }

    // Override menambahkan bahan bantalan pada informasi produk.
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bahan Bantalan: " + bahanBantalanEmpuk);
    }
}
