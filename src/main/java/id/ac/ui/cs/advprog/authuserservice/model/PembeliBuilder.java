package id.ac.ui.cs.advprog.authuserservice.model;

import java.util.List;

public class PembeliBuilder extends UserBuilder<PembeliBuilder> {
    int saldo;
//    List<Transaksi> riwayatTransaksi;
//    List<Produk> library;
    public PembeliBuilder() {
    }

    public PembeliBuilder saldo(int saldo) {
        this.saldo = saldo;
        return this;
    }

//    public PembeliBuilder riwayatTransaksi(List<Transaksi> riwayatTransaksi) {
//        this.riwayatTransaksi = riwayatTransaksi;
//        return this;
//    }

    //    public PembeliBuilder library(List<Produk> library) {
//        this.library = library;
//        return this;
//    }

    @Override
    public Pembeli build() {
        return new Pembeli(this);
    }

    @Override
    protected PembeliBuilder self() {
        return this;
    }
}

