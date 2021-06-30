package com;
public class Pembeli {
    private int id_pembeli;
    public String username,password,nama,alamat,email,no_hp;

    public Pembeli() {
    }

    public Pembeli(int id_pembeli, String username, String password, String nama, String alamat, String email, String no_hp) {
        this.id_pembeli = id_pembeli;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.no_hp = no_hp;
    }

    public int getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(int id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Pembeli{" + "id_pembeli=" + id_pembeli + ", username=" + username + ", password=" + password + ", nama=" + nama + ", alamat=" + alamat + ", email=" + email + ", no_hp=" + no_hp + '}';
    }
    
}
