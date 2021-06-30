package com;
public class Transaksi {
    int id_transaksi,id_game,id_pembeli,id_supplier;
    String tgl_transaksi,fknamapembeli,fknamagame;

    public Transaksi() {
    }

    public Transaksi(int id_transaksi, int id_game, int id_pembeli, int id_supplier, String tgl_transaksi, 
            String fknamapembeli, String fknamagame) {
        this.id_transaksi = id_transaksi;
        this.id_game = id_game;
        this.id_pembeli = id_pembeli;
        this.id_supplier = id_supplier;
        this.tgl_transaksi = tgl_transaksi;
        this.fknamapembeli = fknamapembeli;
        this.fknamagame = fknamagame;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public int getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(int id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getTgl_transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_transaksi(String tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public String getFknamapembeli() {
        return fknamapembeli;
    }

    public void setFknamapembeli(String fknamapembeli) {
        this.fknamapembeli = fknamapembeli;
    }
    
    public String getfknamagame() {
        return fknamagame;
    }

    public void setfknamagame(String fknamagame) {
        this.fknamagame = fknamagame;
    }

    @Override
    public String toString() {
        return "Transaksi{" + "id_transaksi=" + id_transaksi + ", id_game=" + id_game + ", id_pembeli=" + id_pembeli + ", id_supplier=" + id_supplier + ", tgl_transaksi=" + tgl_transaksi + ", fknamapembeli=" + fknamapembeli + ", fknamagame=" + fknamagame + '}';
    }

    

    
    
}
