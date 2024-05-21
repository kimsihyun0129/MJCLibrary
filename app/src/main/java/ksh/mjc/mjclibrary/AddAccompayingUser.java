package ksh.mjc.mjclibrary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AddAccompayingUser extends AppCompatActivity {

    EditText etName, etStudentNumber;

    Button btnAddAccompayingUser, btnSave;

    ListView lvAddList, lvRecentAccompayingUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_accompaying_user);

        etName = findViewById(R.id.etName);
        etStudentNumber = findViewById(R.id.etStudentNumber);
        btnAddAccompayingUser = findViewById(R.id.btnAddAccompayingUser);
        btnSave = findViewById(R.id.btnSave);
        lvAddList = findViewById(R.id.lvAddList);
        lvRecentAccompayingUser = findViewById(R.id.lvRecentAccompanyingUser);

        btnAddAccompayingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}