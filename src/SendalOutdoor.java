// Kelompok sendal untuk luar ruangan dengan atribut daya cengkeram sol.
public class SendalOutdoor extends Sendal {
    // Detail sol disimpan private untuk menjaga enkapsulasi.
    private String dayaCengkeramSol;

    // Constructor meneruskan data umum dan memvalidasi detail sol.
    public SendalOutdoor(String kodeProduk, String merk, double harga,
                         String jenisSendal, String dayaCengkeramSol) {
        super(kodeProduk, merk, harga, jenisSendal);
        if (dayaCengkeramSol == null || dayaCengkeramSol.isBlank()) {
            throw new IllegalArgumentException("Daya cengkeram sol tidak boleh kosong.");
        }
        this.dayaCengkeramSol = dayaCengkeramSol;
    }

    // Getter untuk membaca informasi daya cengkeram sol.
    public String getDayaCengkeramSol() {
        return dayaCengkeramSol;
    }

    // Override menambahkan detail cengkeraman sol ke informasi sendal.
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Cengkeraman Sol: " + dayaCengkeramSol);
    }
}
