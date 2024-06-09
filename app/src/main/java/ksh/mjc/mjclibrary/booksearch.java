package ksh.mjc.mjclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class booksearch extends AppCompatActivity {


    AutoCompleteTextView search_book;
    ListView bookrv;
    Button searchbtn;

    List<String> book;
    String Book_search;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activirty_search);


        searchbtn = findViewById(R.id.searchbtn);
        search_book = findViewById(R.id.search_book);
        bookrv = findViewById(R.id.listSearchbook);
        book = new ArrayList<String>();



        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book_search = search_book.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            JSONArray bookname = jsonResponse.getJSONArray("book_name");
                            JSONArray bookauthor = jsonResponse.getJSONArray("author");
                            JSONArray bookpublisher = jsonResponse.getJSONArray("publisher");
                            JSONArray bookcode = jsonResponse.getJSONArray("book_code");
                            JSONArray bookloca = jsonResponse.getJSONArray("book_loca");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };


            }
        });
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray bookname = jsonResponse.getJSONArray("book_name");


                    for (int i = 0; i < bookname.length(); i++) {
                        book.add(bookname.getString(i));
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        BookRequeste bookRequeste = new BookRequeste(responseListener);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(bookRequeste);


        search_book.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,book));
    }

}
