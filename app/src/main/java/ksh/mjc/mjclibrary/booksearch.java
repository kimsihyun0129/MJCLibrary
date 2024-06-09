package ksh.mjc.mjclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
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

    int[] img = {R.drawable.book1,R.drawable.book2,R.drawable.book3,R.drawable.book4,R.drawable.book5,R.drawable.book6,R.drawable.book7,R.drawable.book8,R.drawable.book9,R.drawable.book10};
    ArrayList<Bookdata> bookdatalist ;
    BooklistAdapter booklistAdapter;
    List<String> book;
    String Book_search;
    ArrayList<Integer> Book_location = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activirty_search);


        searchbtn = findViewById(R.id.searchbtn);

        search_book = findViewById(R.id.search_book);
        bookrv = findViewById(R.id.listSearchbook);
        book = new ArrayList<String>();
        bookdatalist = new ArrayList<Bookdata>();
        booklistAdapter = new BooklistAdapter(this,bookdatalist);
        bookrv.setAdapter(booklistAdapter);


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book_search = search_book.getText().toString();
                bookdatalist.clear();
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

                            for (int i = 0; i < bookname.length(); i++) {
                                if(Book_search.equals(bookname.getString(i))){
                                    bookdatalist.add(new Bookdata(bookname.getString(i),bookauthor.getString(i),bookpublisher.getString(i),bookcode.getString(i),img[i]));
                                    Book_location.add(bookloca.getInt(i));
                                }
                            }  booklistAdapter.notifyDataSetChanged();



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                BookRequeste bookRequeste = new BookRequeste(responseListener);
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(bookRequeste);

                bookrv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), library.class);
                        intent.putExtra("location", Book_location);
                        startActivity(intent);
                    }
                });


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
