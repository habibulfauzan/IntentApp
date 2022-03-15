package com.fzn.intentapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSJiwaTampan extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center", "SMS Center", "Driving Direction", "Website", "Info di Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listAct));
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
            if (pilihan.equals("Call Center")) {
                String tel = "tel:081363830375";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));

            } else if (pilihan.equals("SMS Center")) {
                String sms = "SMS Center RS Jiwa Tampan";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:0813638303755"));
                a.putExtra("sms_body", sms);

            } else if (pilihan.equals("Driving Direction")) {
                String lokasirs = "google.navigation:q=0.4525011, 101.3610750";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasirs));

            } else if (pilihan.equals("Website")) {
                String web = "https://rsjiwatampan.riau.go.id/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));

            } else if (pilihan.equals("Info di Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Rumah Sakit Jiwa Tampan");

            }
            startActivity(a);
        } catch (Exception err){
            err.printStackTrace();
        }
    }
}
