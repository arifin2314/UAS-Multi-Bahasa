package com.example.arifin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arifin.model.wisata;
import com.example.arifin.model.religi;
import com.example.arifin.model.pengunungan;
import com.example.arifin.model.pantai;
import com.example.arifin.model.air_terjun;

public class ProfileActivity extends AppCompatActivity {
    wisata wisata;
    TextView txJenis, nama_wisata, txlokasi,txDeskripsi,txJudul;
    ImageView ivFotoWisaat;
    Button kembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Intent intent = getIntent();
        wisata = (wisata) intent.getSerializableExtra(DaftarWisataActivity.WISATA_TERPILIH);
        inisialisasiView();
        tampilkanProfil(wisata);
    }

    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txJenis);
        txlokasi = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoWisaat = findViewById(R.id.gambarHewan);
        kembali = findViewById(R.id.btn_back_to_list);
        kembali.setOnClickListener(view -> {
            onBackPressed();
        });
    }


    private void tampilkanProfil(wisata wisata) {
        Log.d("Profil","Menampilkan "+wisata.getJenis());
        if (wisata instanceof pengunungan) {
            txJudul.setText(R.string.pgn);
        }else if (wisata instanceof pantai) {
            txJudul.setText(R.string.pti);
        }else if (wisata instanceof religi) {
            txJudul.setText(R.string.rlg);
        }else if (wisata instanceof air_terjun) {
            txJudul.setText(R.string.terjun);
        }
        txJenis.setText(wisata.getNama_wisata());
        txlokasi.setText(wisata.getLokasi());
        txDeskripsi.setText(wisata.getDeskripsi());
        ivFotoWisaat.setImageDrawable(this.getDrawable(wisata.getPoto()));
    }

}
