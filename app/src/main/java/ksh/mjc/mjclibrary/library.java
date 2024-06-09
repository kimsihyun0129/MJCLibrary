package ksh.mjc.mjclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class library extends AppCompatActivity {

    ImageView lib_search;
    int code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_library);



        lib_search = findViewById(R.id.lib_search);
        Intent intent  = getIntent();
        code = intent.getIntExtra("location",0);

        if(code <=0 || code >=100){
            if(code<=0||code>=14) {
                lib_search.setImageResource(R.drawable.library1_0_14);
            }
            if(code<14||code>=28) {
                lib_search.setImageResource(R.drawable.library1_14_28);
            }
            if(code<28||code>=42) {
                lib_search.setImageResource(R.drawable.library1_28_42);
            }
            if(code<42||code>=56) {
                lib_search.setImageResource(R.drawable.library1_42_56);
            }
            if(code<56||code>=70) {
                lib_search.setImageResource(R.drawable.library1_56_70);
            }
            if(code<70||code>=84) {
                lib_search.setImageResource(R.drawable.library1_70_84);
            }
            if(code<84||code>=100) {
                lib_search.setImageResource(R.drawable.library1_84_100);
            }
        }




    }
}
