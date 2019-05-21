package com.example.adisaktijrs.learnenglish;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class second extends AppCompatActivity {
    ImageButton b1,b2;
    TextView t1,t2;
    ImageView img1;
    public int a = 0;
    public static ArrayList<String[]> akhir = new ArrayList<String[]>();
    public int batas;
    public String gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Belajar");
        setContentView(R.layout.activity_second);

        Resources res = getResources();
        final String kosakata[] = res.getStringArray(R.array.kosakata);

        int len = kosakata.length;
        for(int i=0;i<len;i++){
            String[] pecah = kosakata[i].split(",");
            akhir.add(pecah);
        }

        b1 = (ImageButton) findViewById(R.id.btn_next);
        b2 = (ImageButton) findViewById(R.id.btn_prev);
        t1 = (TextView) findViewById(R.id.teks_kata_ing);
        t2 = (TextView) findViewById(R.id.teks_kata_indo);
        img1 = (ImageView) findViewById(R.id.img_kata);
        t1.setText(akhir.get(a)[0]);
        t2.setText(akhir.get(a)[1]);
        //a++;
        batas = kosakata.length;
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //t1.setText(Arrays.toString(kosakata));

                if (a == (batas-1)) {
                    showDialog1();
                }else {
                    a++;
                    gambar = akhir.get(a)[2];
                    t1.setText(akhir.get(a)[0]);
                    t2.setText(akhir.get(a)[1]);
                    img1.setImageResource(getResources().getIdentifier(gambar, "drawable", getPackageName()));
                    //img1.setImageResource(R.drawable.pena);
                    //a++;
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a == 0) {
                    showDialog2();
                }else {
                    a--;
                    gambar = akhir.get(a)[2];
                    t1.setText(akhir.get(a)[0]);
                    t2.setText(akhir.get(a)[1]);
                    img1.setImageResource(getResources().getIdentifier(gambar, "drawable", getPackageName()));
                    //a--;
                }
            }
        });

    }

    private void showDialog1(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Selamat!");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Selamat anda sudah mempelajari semua kosakata")
                .setIcon(R.drawable.ic_whatshot_black_24dp)
                .setCancelable(true)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // do something
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

    private void showDialog2(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Upssss");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Silakan klik tombol ke arah kanan")
                .setIcon(R.drawable.ic_warning_black_24dp)
                .setCancelable(true);

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }
}
