package ksh.mjc.mjclibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class StudyRoomReservationActivity extends AppCompatActivity {
    ImageButton ibBack,ibSelectDate;//뒤로가기 버튼, 날짜선택버튼
    static TextView tvSelectDate;//날짜 선택 텍스트뷰
    RecyclerView rvStudyRoom;//스터디룸 정보를 띄워줄 리사이클러뷰
    //TODO 1.db에서 스터디룸 이름 및 최소/최대 인원 가져오기
    String[] studyRoomNames = {"창의학습공간 스터디룸1", "창의학습공간 스터디룸2", "창의학습공간 스터디룸3", "세미나룸", "스터디라운지 스터디룸1", "스터디라운지 스터디룸2", "스터디라운지 스터디룸3"};
    int[] studyRoomMinNumberOfPeoples = {3,3,3,7,3,3,3}, studyroomMaxNumberOfPeoples={6,6,6,20,6,6,6};//스터디룸 최소/최대 인원
    //TODO 2.밑에다가 넣어도 되는지 확인하기
    Calendar calendar = Calendar.getInstance();//현재 날짜를 불러오기 위한 캘린더 객체 생성
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//날짜 형식 지정
    String dateItems[] = new String[7];//날짜 선택 옵션 배열
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_room_reservation);

        //툴바 달기
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //각각의 뷰 인플레이팅
        ibBack = findViewById(R.id.ibBack);
        ibSelectDate = findViewById(R.id.ibSelectDate);
        tvSelectDate = findViewById(R.id.tvSelectDate);
        rvStudyRoom = findViewById(R.id.rvStudyRoom);

        //날짜 텍스트뷰를 현재 날짜로 초기화
        tvSelectDate.setText(sdf.format(calendar.getTime()));

        //뒤로기가 버튼을 클릭하면
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //인텐트를 이용해 메인화면으로 이동
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        //날짜 선택 옵션 배열에 각 항목을 오늘 날짜로부터 하루 단위로 넣어줌
        for(int i=0;i<dateItems.length;i++){
            dateItems[i] = sdf.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_YEAR,1);
        }

        //스터디룸 목록 배열
        ArrayList<StudyRoom> alStudyRoom = new ArrayList<>();

        //각각의 스터디룸 객체를 생성하여 스터디룸 목록 배열에 넣어줌
        for(int i=0;i<studyRoomNames.length; i++){
            alStudyRoom.add(new StudyRoom(studyRoomNames[i],studyRoomMinNumberOfPeoples[i],studyroomMaxNumberOfPeoples[i]));
        }

        //리사이클러뷰(스터디룸 목록) 어댑터 생성
        RecyclerViewAdapter studyRoomAdapter = new RecyclerViewAdapter(this,alStudyRoom);
        //리사이클러뷰를 어떻게 표시할 것인지 생성(리니어레이아웃)
        rvStudyRoom.setLayoutManager(new LinearLayoutManager(this));
        //리사이클러뷰에 어댑터 연결
        rvStudyRoom.setAdapter(studyRoomAdapter);
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