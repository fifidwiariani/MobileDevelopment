package com.example.user_input;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed_sisi;
    Button btn_hitung;
    TextView tv_hasil;
    Spinner spinner_pilihan;
    String[] pilihanHitng = {"Volume", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_sisi = findViewById(R.id.ed_sisi);
        btn_hitung = findViewById(R.id.btn_hitung);
        tv_hasil = findViewById(R.id.tv_hasil);
        spinner_pilihan = findViewById(R.id.spinner_pilihan);

        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner_pilihan.getSelectedItem().toString().equals(pilihanHitng[0])) {
                    //rumus volume
                    rumusVolume();
                    //crtl+alt+M
                } else if (spinner_pilihan.getSelectedItem().toString().equals(pilihanHitng[1])) {
                    //rumus keliling
                    Double sisi = Double.valueOf(ed_sisi.getText().toString());
                    rumusKeliling(sisi);
                } else if (spinner_pilihan.getSelectedItem().toString().equals(pilihanHitng[2])) {
                    //rumus luas permukaan
                    Double hasil = rumusLuasPermukaan();
                    tv_hasil.setText(hasil.toString());
                }
            }
        });

        //data
        //adapter
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, pilihanHitng);
        spinner_pilihan.setAdapter(adapter);
    }

    private Double rumusLuasPermukaan() {
        Double sisi = Double.valueOf(ed_sisi.getText().toString());
        Double hasil = 12 * sisi;
        return hasil;
    }

    private void rumusKeliling(Double sisi) {
        Double hasil = 6 * sisi * sisi;
        tv_hasil.setText(hasil.toString());
    }

    private void rumusVolume() {
        Double sisi = Double.valueOf(ed_sisi.getText().toString());
        Double hasil = sisi * sisi * sisi;
        tv_hasil.setText(hasil.toString());
    }
}
