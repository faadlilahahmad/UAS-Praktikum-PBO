package com;

import exec.ExecuteSupplier;
import java.util.ArrayList;
import java.util.List;

public class ConvertSupplierToObject {
    public String[][] getSupplier(){
        List<Supplier> mySp = new ArrayList<Supplier>();
        ExecuteSupplier eSp = new ExecuteSupplier();
        mySp = eSp.getSupplier();
        String[][] dataSupplier = new String[mySp.size()][5];
        int i=0;
        for(Supplier sp : mySp){
            dataSupplier[i][0] = ""+sp.getId_supplier();
            dataSupplier[i][1] = sp.getNama();
            dataSupplier[i][2] = sp.getAlamat();
            dataSupplier[i][3] = sp.getEmail();
            dataSupplier[i][4] = sp.getNo_hp();
            i++;
        }
        return dataSupplier;
    }
    
}
