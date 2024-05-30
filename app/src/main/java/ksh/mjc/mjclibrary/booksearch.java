package ksh.mjc.mjclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class booksearch extends AppCompatActivity {

    private ListView listView;
    private Booksearch_adapter adapter;
    private List<booklistitem> booklist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activirty_search);

        Intent intent = getIntent();

        listView = findViewById(R.id.Booklist);
        booklist = new ArrayList<booklistitem>();

        adapter = new Booksearch_adapter(getApplicationContext(),booklist);
        listView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("Booklist"));

            JSONArray jsonArray = jsonObject.getJSONArray("");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
