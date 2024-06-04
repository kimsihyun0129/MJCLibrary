package ksh.mjc.mjclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class booksearch extends AppCompatActivity {

    RecyclerView bookrv;

    Booksearch_adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activirty_search);

        bookrv = findViewById(R.id.rvSearchbook);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        bookrv.setLayoutManager(layoutManager);

        adapter = new Booksearch_adapter(getApplicationContext());
        bookrv.setAdapter(adapter);



    }
}
