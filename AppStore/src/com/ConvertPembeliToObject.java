package com;

import exec.ExecutePembeli;
import java.util.ArrayList;
import java.util.List;
import static view.LoginForm.a;
import static view.LoginForm.b;

public class ConvertPembeliToObject {
    public String[][] getPembeli(){
        List<Pembeli> myPm = new ArrayList<Pembeli>();
        ExecutePembeli ePm = new ExecutePembeli();
        myPm = ePm.getPembeli(a, b);
        String[][] dataPembeli = new String[myPm.size()][7];
        int i=0;
        for(Pembeli pm : myPm){
            dataPembeli[i][0] = ""+pm.getId_pembeli();
            dataPembeli[i][1] = pm.getUsername();
            dataPembeli[i][2] = pm.getPassword();
            dataPembeli[i][3] = pm.getNama();
            dataPembeli[i][4] = pm.getAlamat();
            dataPembeli[i][5] = pm.getEmail();
            dataPembeli[i][6] = pm.getNo_hp();
            i++;
        }
        return dataPembeli;
    }

}
