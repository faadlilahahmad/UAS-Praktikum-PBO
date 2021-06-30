package com;
public class Supplier {
    private int id_supplier;
    private String nama, alamat, email, no_hp;

    public Supplier() {
    }

    public Supplier(int id_supplier, String nama, String alamat, String email, String no_hp) {
        this.id_supplier = id_supplier;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.no_hp = no_hp;
    }

    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    @Override
    public String toString() {
        return "Supplier{" + "id_supplier=" + id_supplier + ", nama=" + nama + ", alamat=" + alamat + ", email=" + email + ", no_hp=" + no_hp + '}';
    }

}
