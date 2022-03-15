package com.fzn.intentapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RS extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listRS = new String[] {"RS Awal Bross", "RS Eka Hospital", "RS Jiwa Tampan", "RS Tabrani"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listRS));
    }

    protected void onListItemClick (ListView l, View v, int posisi, long id){
        super.onListItemClick(l, v, posisi, id);
        Object o = this.getListAdapter().getItem(posisi);
        String pilihan = o.toString();
        viewPilihan(pilihan);
    }

    private void viewPilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("RS Awal Bross")) {
                a = new Intent(this, RSAwalBross.class);

            } else if (pilihan.equals("RS Eka Hospital")) {
                a = new Intent(this, RSEkaHospital.class);

            } else if (pilihan.equals("RS Jiwa Tampan")) {
                a = new Intent(this, RSJiwaTampan.class);

            } else if (pilihan.equals("RS Tabrani")) {
                a = new Intent(this, RSTabrani.class);

            }
            startActivity(a);
        } catch (Exception err){
            err.printStackTrace();
        }
    }
}
