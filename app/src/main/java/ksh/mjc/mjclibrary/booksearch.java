package ksh.mjc.mjclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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

    RecyclerView bookrv;

    Booksearch_adapter adapter;

    ArrayList<String> bname = new ArrayList<>();
    ArrayList<String> bimg = new ArrayList<>();
    ArrayList<String> bauthor = new ArrayList<>();
    ArrayList<String> bpublisher = new ArrayList<>();
    ArrayList<String> bcode = new ArrayList<>();

    ArrayList<Integer> bloca1 = new ArrayList<>();

    EditText search_book;
    String Book_search;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activirty_search);


        search_book = findViewById(R.id.search_book);
        Book_search = search_book.getText().toString();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray Bname = jsonResponse.getJSONArray("book_name");
                    JSONArray Bimg = jsonResponse.getJSONArray("book_img");
                    JSONArray Bauthor = jsonResponse.getJSONArray("author");
                    JSONArray Bpublisher = jsonResponse.getJSONArray("publisher");
                    JSONArray Bcode = jsonResponse.getJSONArray("book_code");
                    JSONArray Bloca1 = jsonResponse.getJSONArray("book_loca");


                    for (int i = 0; i < Bname.length(); i++) {
                        bname.add(Bname.getString(i));
                        bimg.add(Bimg.getString(i));
                        bauthor.add(Bauthor.getString(i));
                        bpublisher.add(Bpublisher.getString(i));
                        bcode.add(Bcode.getString(i));
                        bloca1.add(Bloca1.getInt(i));

                    }

                    // 비동기 요청 후 RecyclerView 설정
                    setBookView(bname, bimg, bauthor, bpublisher, bcode);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        BookRequeste bookRequeste = new BookRequeste(responseListener);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(bookRequeste);

        bookrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),library.class);
                intent.putExtra("loca1",bloca1);
                startActivity(intent);
            }
        });
        search_book.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterBooks(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    private void setBookView(ArrayList<String> names, ArrayList<String> imgs, ArrayList<String> authors, ArrayList<String> publishers, ArrayList<String> codes) {
        //스터디룸 목록 배열
        ArrayList<booklistitem> albook = new ArrayList<>();

        //각각의 스터디룸 객체를 생성하여 스터디룸 목록 배열에 넣어줌
        for (int i = 0; i < bname.size(); i++) {
            albook.add(new booklistitem(bname.get(i), bimg.get(i), bauthor.get(i), bpublisher.get(i), bcode.get(i)));
        }

        bookrv = findViewById(R.id.rvSearchbook);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        bookrv.setLayoutManager(layoutManager);

        adapter = new Booksearch_adapter(getApplicationContext());
        bookrv.setAdapter(adapter);

    }

    private void filterBooks(String query) {
        ArrayList<String> filteredNames = new ArrayList<>();
        ArrayList<String> filteredImgs = new ArrayList<>();
        ArrayList<String> filteredAuthors = new ArrayList<>();
        ArrayList<String> filteredPublishers = new ArrayList<>();
        ArrayList<String> filteredCodes = new ArrayList<>();

        for (int i = 0; i < bname.size(); i++) {
            if (bname.get(i).toLowerCase().contains(query.toLowerCase())) {
                filteredNames.add(bname.get(i));
                filteredImgs.add(bimg.get(i));
                filteredAuthors.add(bauthor.get(i));
                filteredPublishers.add(bpublisher.get(i));
                filteredCodes.add(bcode.get(i));
            }
        }

        setBookView(filteredNames, filteredImgs, filteredAuthors, filteredPublishers, filteredCodes);
    }
}


