package com.udinus.kamis_10210_nurularifin_tugassqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddMahasiswa extends AppCompatActivity {
    private TextInputEditText xnim, xnama, xtgl_lhr, xalamat, xkota;
    private RadioGroup radioGroup;
    private RadioButton xjenis_kelamin;
    private int selectedId;
    private Button addbtn;
    private  DatabaseHelper databaseHelper;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_mahasiswa);
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        xnim = findViewById(R.id.xnim);
        xnama = findViewById(R.id.xnama);
        xtgl_lhr = findViewById(R.id.xtgl_lhr);
        radioGroup = findViewById(R.id.xjenis_kelamin);
        xalamat = findViewById(R.id.xalamat);
        xkota = findViewById(R.id.xkota);
        addbtn = findViewById(R.id.addbtn);
        xtgl_lhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
        databaseHelper = new DatabaseHelper(this);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xjenis_kelamin = findViewById(radioGroup.getCheckedRadioButtonId());
                boolean isInserted = databaseHelper.insertData(xnim.getText().toString(), xnama.getText().toString(), xtgl_lhr.getText().toString(), xjenis_kelamin.getText().toString(), xalamat.getText().toString(), xkota.getText().toString());
                if (isInserted == true){
                    Toast.makeText(AddMahasiswa.this, "Data berhasil tersimpan", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AddMahasiswa.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(AddMahasiswa.this, "Data gagal tersimpan", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showDatePicker(){
        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                xtgl_lhr.setText(simpleDateFormat.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setCancelable(true);
        datePickerDialog.setCanceledOnTouchOutside(true);
        datePickerDialog.show();
    }

}
