package com;
public class Game {
    private int id_game;
    private String judul;
    private String genre;
    private int harga;

    public Game() {
    }

    public Game(int id_game, String judul, String genre, int harga) {
        this.id_game = id_game;
        this.judul = judul;
        this.genre = genre;
        this.harga = harga;
    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "game{" + "id_game=" + id_game + ", judul=" + judul + ", genre=" + genre + ", harga=" + harga + '}';
    }
    
    
}
