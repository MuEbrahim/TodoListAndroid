package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Pair;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Pair<Boolean,Pair<String,String>>> contact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contact.add(new Pair<>(true,new Pair<>("Muhammed","12344454")));
        contact.add(new Pair<>(false,new Pair<>("ahmed","5123123")));
        contact.add(new Pair<>(false,new Pair<>("Muhammed","595123")));
        contact.add(new Pair<>(false,new Pair<>("Muhammed","609800")));

        contact.add(new Pair<>(true,new Pair<>("Muhammed","12344454")));
        contact.add(new Pair<>(false,new Pair<>("ahmed","5123123")));
        contact.add(new Pair<>(false,new Pair<>("Muhammed","595123")));
        contact.add(new Pair<>(false,new Pair<>("Muhammed","609800")));

        contact.add(new Pair<>(true,new Pair<>("Muhammed","12344454")));
        contact.add(new Pair<>(false,new Pair<>("ahmed","5123123")));
        contact.add(new Pair<>(false,new Pair<>("Muhammed","595123")));
        contact.add(new Pair<>(false,new Pair<>("Muhammed","609800")));

        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rc);
        contactAdaptor contactAdaptor = new contactAdaptor(contact, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(contactAdaptor);
        recyclerView.setLayoutManager(linearLayoutManager);
        contactAdaptor.notifyDataSetChanged();
    }
}
