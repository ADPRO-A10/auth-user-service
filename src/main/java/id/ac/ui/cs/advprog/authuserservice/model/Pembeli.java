package id.ac.ui.cs.advprog.authuserservice.model;

public class Pembeli extends User {
    private int saldo;
//    To be implemented form another API
//    private List<Transaksi> riwayatTransaksi;
//    private List<Produk> library;

    public Pembeli(PembeliBuilder builder) {
        super(builder);
        this.saldo = builder.saldo;
//        To be implemented from another API
//        this.riwayatTransaksi = builder.riwayatTransaksi;
//        this.library = builder.library;
    }
}
