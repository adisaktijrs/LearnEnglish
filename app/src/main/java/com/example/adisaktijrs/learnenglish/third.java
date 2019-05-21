package com.example.adisaktijrs.learnenglish;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class third extends AppCompatActivity {

    public static ArrayList<String[]> akhir = new ArrayList<String[]>();
    public static ArrayList<Integer> nomor2 = new ArrayList<Integer>(akhir.size());
    public static ArrayList<Integer> nomor = new ArrayList<Integer>(4);

    TextView t1;
    Button b1,b2,b3,b4,bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Kuis");
        setContentView(R.layout.activity_third);

        Resources res = getResources();
        final String kosakata[] = res.getStringArray(R.array.kosakata);

        int len = kosakata.length;
        for(int i=0;i<len;i++){
            String[] pecah = kosakata[i].split(",");
            akhir.add(pecah);
        }

        for (int a=0; a< akhir.size(); a++) {
            nomor2.add(a);
        }
        Collections.shuffle(nomor2);

        for (int a=0; a<4; a++) {
            nomor.add(a);
        }
        Collections.shuffle(nomor);

        t1 = (TextView) findViewById(R.id.textKata);
        b1 = (Button) findViewById(R.id.btnA);
        b2 = (Button) findViewById(R.id.btnB);
        b3 = (Button) findViewById(R.id.btnC);
        b4 = (Button) findViewById(R.id.btnD);

        t1.setText(akhir.get(nomor2.get(nomor.get(0)))[0]);

        b1.setText(akhir.get(nomor2.get(0))[1]);
        b2.setText(akhir.get(nomor2.get(1))[1]);
        b3.setText(akhir.get(nomor2.get(2))[1]);
        b4.setText(akhir.get(nomor2.get(3))[1]);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nomor2.get(nomor.get(0)).equals(nomor2.get(0))) {
                    pesanBenar();
                } else {
                    pesanSalah();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nomor2.get(nomor.get(0)).equals(nomor2.get(1))) {
                    pesanBenar();
                } else {
                    pesanSalah();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nomor2.get(nomor.get(0)).equals(nomor2.get(2))) {
                    pesanBenar();
                } else {
                    pesanSalah();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nomor2.get(nomor.get(0)).equals(nomor2.get(3))) {
                    pesanBenar();
                } else {
                    pesanSalah();
                }
            }
        });



    }

    private void pesanBenar(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Selamat");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Jawaban Anda benar!")
                .setIcon(R.drawable.ic_sentiment_very_satisfied_black_24dp)
                .setCancelable(false)
                .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

    private void pesanSalah(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Tetap Semangat");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Jawaban Anda kurang tepat! Arti yang benar dari "+ akhir.get(nomor2.get(nomor.get(0)))[0]+" adalah "+ akhir.get(nomor2.get(nomor.get(0)))[1])
                .setIcon(R.drawable.ic_sentiment_very_dissatisfied_black_24dp)
                .setCancelable(false)
                .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                        overridePendingTransition(0, 0);
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

} //yeahhhhhhhhhhhhhhhhhhhhhh activity terakhir kelarrrrrrrrrrr
