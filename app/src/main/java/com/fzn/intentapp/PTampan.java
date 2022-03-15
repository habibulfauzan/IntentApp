package com.fzn.intentapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PTampan extends ListActivity {
    protected void onCreate (Bundle icicle){
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center", "SMS Center", "Driving Direction", "Info di Google", "Exit"};
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
                String tel = "tel:076164110";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));

            } else if (pilihan.equals("SMS Center")) {
                String sms = "SMS Center Polsek Tampan";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:076164110"));
                a.putExtra("sms_body", sms);

            } else if (pilihan.equals("Driving Direction")) {
                String lokasirs = "google.navigation:q=0.415780, 101.424480";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasirs));

            } else if (pilihan.equals("Info di Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Polsek Tampan");

            }
            startActivity(a);
        } catch (Exception err){
            err.printStackTrace();
        }
    }
}
