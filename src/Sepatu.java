// Class dasar sepatu; mewarisi identitas dan harga dari AlasKaki.
public class Sepatu extends AlasKaki {
    // Ukuran merupakan atribut khusus sepatu dan bersifat private.
    private int ukuran;

    // Constructor mengisi data umum dan memastikan ukuran valid.
    public Sepatu(String kodeProduk, String merk, double harga, int ukuran) {
        super(kodeProduk, merk, harga);
        if (ukuran <= 0) {
            throw new IllegalArgumentException("Ukuran sepatu harus lebih besar dari 0.");
        }
        this.ukuran = ukuran;
    }

    // Getter untuk membaca ukuran sepatu.
    public int getUkuran() {
        return ukuran;
    }

    // Menampilkan informasi yang khusus dimiliki sepatu.
    public void infoSepatu() {
        System.out.println("Jenis        : Sepatu");
        System.out.println("Ukuran       : " + ukuran);
    }

    // Override menggabungkan informasi AlasKaki dengan informasi ukuran sepatu.
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        infoSepatu();
    }
}
