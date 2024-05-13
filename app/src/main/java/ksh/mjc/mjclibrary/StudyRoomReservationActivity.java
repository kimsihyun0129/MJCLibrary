package ksh.mjc.mjclibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StudyRoomReservationActivity extends AppCompatActivity {

    ImageButton ibBack,ibSelectDate;//뒤로가기 버튼, 날짜선택버튼
    TextView tvSelectDate;//날짜선택 텍스트뷰
    RecyclerView rvStudyRoom;//리사이클러뷰
    String[] studyRoomNames = {"창의학습공간 스터디룸1", "창의학습공간 스터디룸2", "창의학습공간 스터디룸3", "세미나룸", "스터디라운지 스터디룸1", "스터디라운지 스터디룸2", "스터디라운지 스터디룸3"};
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//날짜 형식 지정
    String dateItems[] = new String[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_room_reservation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ibBack = findViewById(R.id.ibBack);
        ibSelectDate = findViewById(R.id.ibSelectDate);
        tvSelectDate = findViewById(R.id.tvSelectDate);
        rvStudyRoom = findViewById(R.id.rvStudyRoom);

        tvSelectDate.setText(sdf.format(calendar.getTime()));

        for(int i=0;i<dateItems.length;i++){
            dateItems[i] = sdf.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_YEAR,1);
        }

        //1. 리사이클러뷰에 표시할 데이터
        List<Item> items = new ArrayList<Item>();
        for(int i=0;i<studyRoomNames.length; i++){
            items.add(new Item(studyRoomNames[i]));
        }

        //2. 어댑터 생성
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,items);

        //3. 리사이클러뷰를 어떻게 표시할 것인지 생성(리니어레이아웃)
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvStudyRoom.setLayoutManager(layoutManager);

        //리사이클러뷰와 어댑터를 연결
        rvStudyRoom.setAdapter(adapter);
    }

    public void onSelectDateButtonClick(View v) { //예약날짜나 드롭다운아이콘 버튼 클릭했을 경우
        //다이얼로그 생성
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setSingleChoiceItems(dateItems, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvSelectDate.setText(dateItems[which]);//희망 날짜를 선택한 날짜로 변경
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}