package ksh.mjc.mjclibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnBooksearch, btnStudyRoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBooksearch = findViewById(R.id.btnBookResearch);
        btnStudyRoom = findViewById(R.id.btnStudyRoom);

        //도서 검색 버튼을 클릭하면
        btnBooksearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 인텐트 사용하여 도서검색 화면으로 이동
            }
        });

        //스터디룸 예약 버튼을 클릭하면
        btnStudyRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //인텐트를 사용하여 스터디룸 예약 화면으로 이동
                Intent intent = new Intent(MainActivity.this, StudyRoomReservationActivity.class);
                startActivity(intent);
            }
        });
    }
}