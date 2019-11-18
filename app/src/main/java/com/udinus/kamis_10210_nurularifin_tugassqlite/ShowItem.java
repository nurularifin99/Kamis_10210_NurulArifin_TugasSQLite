package com.udinus.kamis_10210_nurularifin_tugassqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class ShowItem extends AppCompatActivity {
    private String nim, nama, tgl_lhr, jenis_kelamin, alamat, kota;
    private TextView tnim, tnama, ttgl_lhr, tjenis_kelamin, talamat, tkota;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);
//        tnim = findViewById(R.id.tnim);
//        tnama = findViewById(R.id.tnama);
//        ttgl_lhr = findViewById(R.id.ttgl_lhr);
//        tjenis_kelamin = findViewById(R.id.tjenis_kelamin);
//        talamat = findViewById(R.id.talamat);
//        tkota = findViewById(R.id.tkota);
        toolbar = findViewById(R.id.toolbarnew);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout = findViewById(R.id.collapse);
        collapsingToolbarLayout.setTitle(nim);
        nim = getIntent().getExtras().getString("nim");
        nama = getIntent().getExtras().getString("nama");
        tgl_lhr = getIntent().getExtras().getString("tgl_lhr");
        jenis_kelamin = getIntent().getExtras().getString("jenis_kelamin");
        alamat = getIntent().getExtras().getString("alamat");
        kota = getIntent().getExtras().getString("kota");

//        tnim.setText(nim);
//        tnama.setText(nama);
//        ttgl_lhr.setText(tgl_lhr);
//        tjenis_kelamin.setText(jenis_kelamin);
//        talamat.setText(alamat);
//        tkota.setText(kota);
    }

}
