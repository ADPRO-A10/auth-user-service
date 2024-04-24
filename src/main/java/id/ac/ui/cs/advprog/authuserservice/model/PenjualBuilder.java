package id.ac.ui.cs.advprog.authuserservice.model;

import java.util.List;

public class PenjualBuilder extends UserBuilder<PenjualBuilder> {
//    List<Transaksi> riwayatTransaksi;
//    List<Produk> katalog;
    public PenjualBuilder() {
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
    public Penjual build() {
        return new Penjual(this);
    }

    @Override
    protected PenjualBuilder self() {
        return this;
    }
}

