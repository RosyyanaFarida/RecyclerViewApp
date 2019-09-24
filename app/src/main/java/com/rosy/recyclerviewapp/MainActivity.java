package com.rosy.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MahasiswaAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareMahasiswaData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MahasiswaAdapter(mahasiswaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener( new RecyclerTouchListener(getApplicationContext(), recyclerView , new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Mahasiswa mhs = mahasiswaList .get(position);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("data1",mhs.getNama().toString());
                intent.putExtra("data2",mhs.getNim().toString());
                intent.putExtra("data3",mhs.getNohp().toString());
                startActivity(intent);

            }
            @Override
            public void onLongClick(View view, int position) {
            }
        }));

    }

    private void prepareMahasiswaData() {
        mahasiswaList = new ArrayList<>();
        mahasiswaList.add(new Mahasiswa("Rosyyana Farida", "311610560", "0572903165"));
        mahasiswaList.add(new Mahasiswa("Dinar", "311610556", "0572998003"));
        mahasiswaList.add(new Mahasiswa("Aida Nabila", "311610890", "0572903762"));
        mahasiswaList.add(new Mahasiswa("Anjar Imam", "311610576", "0572903191"));
        mahasiswaList.add(new Mahasiswa("Dian Fitri", "311610555", "0572903192"));
    }
    }
