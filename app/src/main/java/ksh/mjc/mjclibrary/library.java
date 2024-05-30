package ksh.mjc.mjclibrary;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class library extends AppCompatActivity {

    ImageView lib_search;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_library);

        lib_search = findViewById(R.id.lib_search);



    }
}
