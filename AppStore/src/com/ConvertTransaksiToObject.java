package com;

import exec.ExecuteTransaksi;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faadlilah Ahmad Purwanto
 */
public class ConvertTransaksiToObject {
    public String[][] getTransaksi(){
        List<Transaksi> myTs = new ArrayList<Transaksi>();
        ExecuteTransaksi eTs = new ExecuteTransaksi();
        myTs = eTs.getTransaksi();
        String[][] dataTransaksi = new String[myTs.size()][7];
        int i=0;
        for(Transaksi ts : myTs){
            dataTransaksi[i][0] = ""+ts.getId_transaksi();
            dataTransaksi[i][1] = ts.getTgl_transaksi();
            dataTransaksi[i][2] = ""+ts.getId_game();
            dataTransaksi[i][3] = ts.getfknamagame();
            dataTransaksi[i][4] = ""+ts.getId_pembeli();
            dataTransaksi[i][5] = ts.getFknamapembeli();
            dataTransaksi[i][6] = ""+ts.getId_supplier();
            i++;
        }
        return dataTransaksi;
    }
}
