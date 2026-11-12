// Class dasar untuk produk sendal; mewarisi identitas dan harga dari AlasKaki.
public class Sendal extends AlasKaki {
    // Atribut khusus sendal, dienkapsulasi agar aksesnya melalui getter.
    private String jenisSendal;

    // Constructor menginisialisasi bagian AlasKaki dan data jenis sendal.
    public Sendal(String kodeProduk, String merk, double harga, String jenisSendal) {
        super(kodeProduk, merk, harga);
        if (jenisSendal == null || jenisSendal.isBlank()) {
            throw new IllegalArgumentException("Jenis sendal tidak boleh kosong.");
        }
        this.jenisSendal = jenisSendal;
    }

    // Getter untuk membaca jenis sendal.
    public String getJenisSendal() {
        return jenisSendal;
    }

    // Menampilkan informasi yang hanya dimiliki produk sendal.
    public void infoSendal() {
        System.out.println("Jenis Sendal : " + jenisSendal);
    }

    // Override menambahkan info sendal setelah informasi umum dari AlasKaki.
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        infoSendal();
    }
}
