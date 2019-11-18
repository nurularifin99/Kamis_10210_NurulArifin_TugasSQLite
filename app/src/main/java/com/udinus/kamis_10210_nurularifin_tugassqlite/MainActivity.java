package com.udinus.kamis_10210_nurularifin_tugassqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MahasiswaAdapter.MahasiswaAdapterCallback{
    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;
    private MahasiswaAdapter mahasiswaAdapter;
    private DatabaseHelper databaseHelper;
    private List<MahasiswaModel> mahasiswaModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddMahasiswa.class);
                startActivity(intent);
            }
        });

        databaseHelper = new DatabaseHelper(MainActivity.this);
        mahasiswaModelList = databaseHelper.getAllDataToArray();
        mahasiswaAdapter = new MahasiswaAdapter(this, mahasiswaModelList, this);
        recyclerView = findViewById(R.id.rv_mahasiswa);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mahasiswaAdapter);


    }

    @Override
    public void onRowMahasiswaAdapterClicked(int position) {
        String nim = mahasiswaModelList.get(position).getNim();
        String nama = mahasiswaModelList.get(position).getNama();
        String tgl_lhr = mahasiswaModelList.get(position).getTanggal_lahir();
        String jenis_kelamin = mahasiswaModelList.get(position).getJenis_kelamin();
        String alamat = mahasiswaModelList.get(position).getAlamat();
        String kota = mahasiswaModelList.get(position).getKota();
        Intent intent = new Intent(MainActivity.this, ShowItem.class);
        intent.putExtra("nim", nim);
        intent.putExtra("nama", nama);
        intent.putExtra("tgl_lhr", tgl_lhr);
        intent.putExtra("jenis_kelamin", jenis_kelamin);
        intent.putExtra("alamat", alamat);
        intent.putExtra("kota", kota);
        startActivity(intent);
    }
}
