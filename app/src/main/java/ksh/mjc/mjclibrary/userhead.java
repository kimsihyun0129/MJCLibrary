package ksh.mjc.mjclibrary;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class userhead extends AppCompatActivity {
   TextView UserInfor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userheder);

        UserInfor = findViewById(R.id.userInFor);

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


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        BookRequeste bookRequeste = new BookRequeste(responseListener);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(bookRequeste);

    }
}
