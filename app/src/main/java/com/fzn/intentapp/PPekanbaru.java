package com.fzn.intentapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PPekanbaru extends ListActivity {
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
                String tel = "tel:0761-21110";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));

            } else if (pilihan.equals("SMS Center")) {
                String sms = "SMS Center Polresta Pekanbaru";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:0761-21110"));
                a.putExtra("sms_body", sms);

            } else if (pilihan.equals("Driving Direction")) {
                String lokasirs = "google.navigation:q=0.526720, 101.450760";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasirs));

            } else if (pilihan.equals("Website")) {
                String web = "https://www.polrestapekanbaru.com";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(web));

            } else if (pilihan.equals("Info di Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Polresta Pekanbaru");

            }
            startActivity(a);
        } catch (Exception err){
            err.printStackTrace();
        }
    }
}
