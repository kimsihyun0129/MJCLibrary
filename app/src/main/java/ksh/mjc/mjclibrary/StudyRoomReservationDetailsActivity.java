package ksh.mjc.mjclibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class StudyRoomReservationDetailsActivity extends AppCompatActivity {

    ImageButton ibBack,ibSelectDate,ibSelectStartTime,ibSelectEndTime,ibUse; //뒤로가기 버튼, 날짜선택/시작시간/종료시간/용도 드롭다운이미지 버튼
    Button btnAddAccompanyingUser, btnReservation;//추가(동반이용자) 버튼, 예약 버튼
    TextView tvStudyRoomName, tvSelectDate, tvSelectStartTime, tvSelectEndTime, tvUse;//스터디룸 이름/선택 날짜/선택 시작시간/선택 종료시간/선택 용도 텍스트 뷰
    int[] viewNames = {R.id.v9,R.id.v10,R.id.v11,R.id.v12,R.id.v13,R.id.v14,R.id.v15,R.id.v16,R.id.v17,R.id.v18,R.id.v19,R.id.v20,R.id.v21};//시간 막대에 대한 뷰
    View[] views = new View[viewNames.length];// 시간 막대에 대한 배열
    RadioGroup rgAgree;//개인정보사용동의 여부 라디오 그룹
    RadioButton rbYes, rbNo;//개인정보사용동의 버튼(예,아니오)
    Calendar calendar = Calendar.getInstance();//날짜를 가져오기 위한 캘린더 인스턴스
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//날짜 형식 지정
    String dateItems[] = new String[7];//현재 날짜로부터 7일을 보여주기 위한 문자열 배열
    String startTimeItems[] = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00"};//시작시간 선택 옵션 문자열 배열
    String endTimeItems[] = {"10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00"};//종료시간 선택 옵션 문자열 배열
    String useItems[] = {"스터디","모임/회의","기타"};//용도 선택 옵션 문자열 배열
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_room_reservation_details);

        //각각의 뷰 인플레이팅
        ibBack = findViewById(R.id.ibBack);
        ibSelectDate = findViewById(R.id.ibSelectDate);
        ibSelectStartTime = findViewById(R.id.ibSelectStartTime);
        ibSelectEndTime = findViewById(R.id.ibSelectEndTime);
        ibUse = findViewById(R.id.ibUse);
        tvSelectDate = findViewById(R.id.tvSelectDate);
        tvSelectStartTime = findViewById(R.id.tvSeletStartTime);
        tvSelectEndTime = findViewById(R.id.tvSelectEndTime);
        tvUse = findViewById(R.id.tvUse);
        btnAddAccompanyingUser = findViewById(R.id.btnAddAccompanyingUser);
        btnReservation = findViewById(R.id.btnReservation);
        tvStudyRoomName = findViewById(R.id.tvStudyRoomName);
        rgAgree = findViewById(R.id.rgAgree);
        rbYes = findViewById(R.id.rbNo);
        rbNo = findViewById(R.id.rbNo);

        //시간 막대 뷰 각각을 인플레이팅
        for(int i=0;i<viewNames.length;i++){
            views[i] = findViewById(viewNames[i]);
        }

        //뒤로가기 버튼을 누르면
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //스터디룸 예약 화면으로 이동
                Intent intent = new Intent(getApplicationContext(),StudyRoomReservationActivity.class);
                startActivity(intent);
            }
        });

        //현재 날짜부터 7일간의 날짜 데이터 생성
        for(int i=0;i<dateItems.length;i++){
            //현재 날짜를 형식을 변환하여 날짜 선택 옵션 배열에 저장
            dateItems[i] = sdf.format(calendar.getTime());
            //루프를 돌 때마다 1일 추가
            calendar.add(Calendar.DAY_OF_YEAR,1);
        }

        //인텐트로 전 액티비티에서 넘겨준 데이터 받기
        Intent intent = getIntent();
        //스터디룸 이름 설정
        tvStudyRoomName.setText(intent.getStringExtra("studyRoomName"));
        //선택된 날짜 설정
        tvSelectDate.setText(intent.getStringExtra("selectDate"));

        //동반이용자 추가 액티비티 인플레이팅
        View activityAddAccompayingUser = getLayoutInflater().inflate(R.layout.activity_add_accompaying_user, null);
        //동반이용자 추가 대화상자 만들기
        AlertDialog.Builder dialogAddAccompanyingUser = new AlertDialog.Builder(StudyRoomReservationDetailsActivity.this);
        dialogAddAccompanyingUser.setView(activityAddAccompayingUser);

        btnAddAccompanyingUser.setOnClickListener(new View.OnClickListener() { //추가 버튼을 클릭하면
            @Override
            public void onClick(View v) {
                //동반이용자 추가 대화상자를 띄워 줌.
                dialogAddAccompanyingUser.show();
            }
        });

        //동반이용자 추가 액티비티에 있는 뷰들 중 사용할 뷰들 인플레이팅
        ImageButton btnClose = activityAddAccompayingUser.findViewById(R.id.btnClose);
        EditText etName = activityAddAccompayingUser.findViewById(R.id.etName);
        EditText etStudentNumber = activityAddAccompayingUser.findViewById(R.id.etStudentNumber);
        Button btnAddAccompanyingUser = activityAddAccompayingUser.findViewById(R.id.btnAddAccompayingUser);
        Button btnSave = activityAddAccompayingUser.findViewById(R.id.btnSave);
        ListView lvAddAccompanyingUser = activityAddAccompayingUser.findViewById(R.id.lvAddList);
        ListView lvRecentAccompayingUser = activityAddAccompayingUser.findViewById(R.id.lvRecentAccompanyingUser);

        //추가한 동반이용자 목록 배열
        ArrayList<ListViewItem> alAddAccompayingUser = new ArrayList<>();
        //추가된 동반이용자 리스트뷰 어댑터
        ListViewAdapter addAccompanyingUserAdapter = new ListViewAdapter(getApplicationContext(),R.layout.added_accompaying_user_item, alAddAccompayingUser);
        //어댑터를 리스트뷰에 연결
        lvAddAccompanyingUser.setAdapter(addAccompanyingUserAdapter);

        btnAddAccompanyingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alAddAccompayingUser.add(new ListViewItem(etName.getText().toString(), Integer.parseInt(etStudentNumber.getText().toString())));
                addAccompanyingUserAdapter.notifyDataSetChanged();
                etName.setText("");
                etStudentNumber.setText("");
            }
        });


        //최근 동반이용자 목록 배열
        ArrayList<ListViewItem> alRecentAccompayingUser = new ArrayList<>();
        alRecentAccompayingUser.add(new ListViewItem("aa",1323));
        //최근 동반 이용자 리스트뷰 어댑터
        ListViewAdapter recentAccompanyingUserAdapter = new ListViewAdapter(getApplicationContext(),R.layout.recent_accompanying_user_item, alRecentAccompayingUser, alAddAccompayingUser, addAccompanyingUserAdapter);
        //어댑터를 리스트뷰에 연결
        lvRecentAccompayingUser.setAdapter(recentAccompanyingUserAdapter);
    }

    //드롭다운 버튼 클릭했을 때 실행시켜줄 메서드(xml에서 onClick속성 사용)
    public void onDropDownImageButtonClick(View v) {
        //여러가지 배열을 담기 위한 배열
        String[] items = null;
        //선택된 것이 날짜 텍스트뷰나 날짜선택에 대한 아이콘이면 날짜 선택 옵션 배열을 items 배열에 넣어줌
        if(v.getId()==R.id.tvSelectDate||v.getId()==R.id.ibSelectDate) items = dateItems;
        //선택된 것이 선택시작시간 텍스트뷰나 선택시작시간에 대한 아이콘이면 시작시간 선택 옵션 배열을 items 배열에 넣어줌
        else if(v.getId()==R.id.tvSeletStartTime||v.getId()==R.id.ibSelectStartTime) items = startTimeItems;
        //선택된 것이 선택종료시간 텍스트뷰나 선택종료시간에 대한 아이콘이면 시작시간 선택 옵션 배열을 items 배열에 넣어줌
        else if(v.getId()==R.id.tvSelectEndTime||v.getId()==R.id.ibSelectEndTime) items = endTimeItems;
        //선택된 것이 용도 텍스트뷰나 용도에 대한 아이콘이면 용도 선택 옵션 배열을 items 배열에 넣어줌
        else if(v.getId()==R.id.tvUse||v.getId()==R.id.ibUse) items = useItems;

        //대화상자 생성
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        //리스너에 안전하게 전달하기 위해 final을 붙임
        final String[] finalItems = items;
        alertDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //선택된 목록에 따라 텍스트 뷰에 해당 값 설정
                if(finalItems == dateItems) {
                    tvSelectDate.setText(finalItems[which]);
                } else if(finalItems ==startTimeItems) {
                    tvSelectStartTime.setText(finalItems[which]);
                } else if(finalItems == endTimeItems) {
                    tvSelectEndTime.setText(finalItems[which]);
                } else if (finalItems == useItems) {
                    tvUse.setText(finalItems[which]);
                }
                //대화상자 닫기
                dialog.dismiss();
            }
        });
        //대화상자를 띄워줌
        alertDialog.show();
    }
}