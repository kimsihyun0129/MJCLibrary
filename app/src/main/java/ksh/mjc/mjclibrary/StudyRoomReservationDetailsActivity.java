package ksh.mjc.mjclibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import java.util.concurrent.atomic.AtomicInteger;

public class StudyRoomReservationDetailsActivity extends AppCompatActivity {

    ImageButton ibBack,ibSelectDate,ibSelectStartTime,ibSelectEndTime,ibUse; //뒤로가기 버튼, 날짜선택/시작시간/종료시간/용도 드롭다운이미지 버튼
    Button btnAddAccompanyingUser, btnReservation;//추가(동반이용자) 버튼, 예약 버튼
    TextView tvStudyRoomName, tvSelectDate, tvSelectStartTime, tvSelectEndTime, tvUse, tvAccompanyingUser;//스터디룸 이름/선택 날짜/선택 시작시간/선택 종료시간/선택 용도/동반이용자 텍스트 뷰
    int theNumberOfAccompanyingUsers = 0;
    int[] timelineNames = {R.id.v9,R.id.v10,R.id.v11,R.id.v12,R.id.v13,R.id.v14,R.id.v15,R.id.v16,R.id.v17,R.id.v18,R.id.v19,R.id.v20,R.id.v21};//시간 막대에 대한 뷰
    View[] timelines = new View[timelineNames.length];// 시간 막대에 대한 배열
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
        tvAccompanyingUser = findViewById(R.id.tvAccompanyingUser);
        btnAddAccompanyingUser = findViewById(R.id.btnAddAccompanyingUser);
        btnReservation = findViewById(R.id.btnReservation);
        tvStudyRoomName = findViewById(R.id.tvStudyRoomName);
        rgAgree = findViewById(R.id.rgAgree);
        rbYes = findViewById(R.id.rbNo);
        rbNo = findViewById(R.id.rbNo);

        //시간 막대 뷰 각각을 인플레이팅
        for(int i=0;i<timelineNames.length;i++){
            timelines[i] = findViewById(timelineNames[i]);
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
        //동반이용자 추가 대화상자 빌더 생성
        AlertDialog.Builder dialogBuilderAddAccompanyingUser = new AlertDialog.Builder(StudyRoomReservationDetailsActivity.this);
        //동반이용자 추가 대화상자 뷰 설정
        dialogBuilderAddAccompanyingUser.setView(activityAddAccompayingUser);
        //대화상자 객체 생성
        AlertDialog dialogAddAccopanyingUser = dialogBuilderAddAccompanyingUser.create();

        btnAddAccompanyingUser.setOnClickListener(new View.OnClickListener() { //추가 버튼을 클릭하면
            @Override
            public void onClick(View v) {
                //동반이용자 추가 대화상자를 띄워 줌.
                dialogAddAccopanyingUser.show();
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

        //닫기 버튼을 누르면
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //대화상자 닫기
                dialogAddAccopanyingUser.dismiss();
            }
        });

        //추가한 동반이용자 목록 배열
        ArrayList<Student> alAddAccompayingUser = new ArrayList<>();
        //추가된 동반이용자 리스트뷰 어댑터
        ListViewAdapter addAccompanyingUserAdapter = new ListViewAdapter(getApplicationContext(),R.layout.added_accompaying_user_item, alAddAccompayingUser);
        //어댑터를 리스트뷰에 연결
        lvAddAccompanyingUser.setAdapter(addAccompanyingUserAdapter);

        //동반이용자 추가 버튼을 누르면
        btnAddAccompanyingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //추가 동반이용자 목록에 추가
                alAddAccompayingUser.add(new Student(etName.getText().toString(), Integer.parseInt(etStudentNumber.getText().toString())));
                //어댑터에 변경 사실을 알림
                addAccompanyingUserAdapter.notifyDataSetChanged();
                //에디트 텍스트 모두 비워줌
                etName.setText("");
                etStudentNumber.setText("");
            }
        });

        //최근 동반이용자 목록 배열
        ArrayList<Student> alRecentAccompayingUser = new ArrayList<>();
        alRecentAccompayingUser.add(new Student("aa",1323));
        //최근 동반 이용자 리스트뷰 어댑터
        ListViewAdapter recentAccompanyingUserAdapter = new ListViewAdapter(getApplicationContext(),R.layout.recent_accompanying_user_item, alRecentAccompayingUser, alAddAccompayingUser, addAccompanyingUserAdapter);
        //어댑터를 리스트뷰에 연결
        lvRecentAccompayingUser.setAdapter(recentAccompanyingUserAdapter);

        //저장 버튼을 클릭하면
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //동반이용자 수를 추가동반이용자 배열의 크기로 지정
                theNumberOfAccompanyingUsers = alAddAccompayingUser.size();
                tvAccompanyingUser.setText("동반이용자:"+theNumberOfAccompanyingUsers+"명");
                //대화 상자 닫기(실제 DB에 저장은 예약 버튼 눌렀을 경우에 함)
                dialogAddAccopanyingUser.dismiss();
            }
        });

        //예약 버튼을 클릭하면
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvSelectStartTime.getText().toString().equals("") //시작시간을 선택하지 않았거나
                        ||tvSelectEndTime.getText().toString().equals("") //종료시간을 선택하지 않았거나
                        ||tvUse.getText().toString().equals("") //용도를 선택하지 않았거나
                        ||theNumberOfAccompanyingUsers+1<3||theNumberOfAccompanyingUsers+1>6 //제한 인원을 맞추지 못했거나
                        ||rgAgree.getCheckedRadioButtonId()!=R.id.rbYes) { //개인정보사용동의를 하지 않았을 경우
                    //각각에 대한 알림 메시지를 다르게하여 대화상자 출력
                    String message = "";
                    if(tvSelectStartTime.getText().toString().equals("")) message="예약시작시간이 선택되지 않았습니다.";
                    else if(tvSelectEndTime.getText().toString().equals("")) message="예약종료시간이 선택되지 않았습니다.";
                    else if(tvUse.getText().toString().equals("")) message="용도가 선택되지 않았습니다.";
                    else if(theNumberOfAccompanyingUsers+1<3||theNumberOfAccompanyingUsers+1>6) message="제한 인원이 충족되지 않았습니다.";
                    else if(rgAgree.getCheckedRadioButtonId()!=R.id.rbYes) message="개인정보사용동의를 하지 않았습니다.";
                    AlertDialog.Builder dialog = new AlertDialog.Builder(StudyRoomReservationDetailsActivity.this);
                    dialog.setMessage(message);
                    dialog.setPositiveButton("확인",null);
                    dialog.show();
                } else { //모두 제대로 입력하였을 경우
                    //예약 정보 확인 대화상자를 띄워줌
                    AlertDialog.Builder dialog = new AlertDialog.Builder(StudyRoomReservationDetailsActivity.this);
                    dialog.setTitle("예약 정보 확인");
                    dialog.setMessage(tvSelectDate.getText().toString()+"\n"+tvSelectStartTime.getText().toString()+"-"+tvSelectEndTime.getText().toString()+"\n"+tvStudyRoomName.getText().toString()+"\n예약하시겠습니까?");
                    dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //TODO db에 저장하기
                        }
                    });
                    dialog.setNegativeButton("취소",null);
                    dialog.show();
                }
            }
        });
    }

    //리스너에 안전하게 전달하기 위해 final 사용
    final AtomicInteger startTime = new AtomicInteger(0); //선택한 예약시작시간
    final AtomicInteger endTime = new AtomicInteger(0); //선택한 예약종료시간
    //드롭다운 버튼 클릭했을 때 실행시켜줄 메서드(xml에서 onClick속성 사용)
    public void onDropDownImageButtonClick(View v) {
        // 여러 가지 배열을 담기 위한 배열
        String[] items = null;

        // 선택된 것이 날짜 텍스트뷰나 날짜 선택에 대한 아이콘이면 날짜 선택 옵션 배열을 items 배열에 넣어줌
        if (v.getId() == R.id.tvSelectDate || v.getId() == R.id.ibSelectDate) {
            items = dateItems;
        } else if (v.getId() == R.id.tvSeletStartTime || v.getId() == R.id.ibSelectStartTime) {
            items = startTimeItems;
        } else if (v.getId() == R.id.tvSelectEndTime || v.getId() == R.id.ibSelectEndTime) {
            items = endTimeItems;
        } else if (v.getId() == R.id.tvUse || v.getId() == R.id.ibUse) {
            items = useItems;
        }

        // 대화상자 생성
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        // 리스너에 안전하게 전달하기 위해 final 사용
        final String[] finalItems = items;

        alertDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 선택된 목록에 따라 텍스트 뷰에 해당 값 설정
                if (finalItems == dateItems) {
                    tvSelectDate.setText(finalItems[which]);
                } else if (finalItems == startTimeItems) {
                    startTime.set(Integer.parseInt(finalItems[which].substring(0, 2)));
                    tvSelectStartTime.setText(finalItems[which]);
                } else if (finalItems == endTimeItems) {
                    endTime.set(Integer.parseInt(finalItems[which].substring(0, 2)));
                    if (endTime.get() - startTime.get() < 1) { //종료시간이 잘못 선택되었다면
                        //대화상자를 띄워줌
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(StudyRoomReservationDetailsActivity.this);
                        alertDialog.setMessage("종료시간이 잘못 선택되었습니다.");
                        alertDialog.setPositiveButton("확인",null);
                        alertDialog.show();
                    } else if(endTime.get() - startTime.get() > 2) { //예약 시간이 2시간을 초과한다면
                        //대화상자를 띄워줌
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(StudyRoomReservationDetailsActivity.this);
                        alertDialog.setMessage("예약 시간은 최대 2시간입니다.");
                        alertDialog.setPositiveButton("확인",null);
                        alertDialog.show();
                    } else { //예약시간을 제대로 선택했다면
                        //예약종료시간 텍스트뷰 설정
                        tvSelectEndTime.setText(finalItems[which]);
                    }
                } else if (finalItems == useItems) {
                    tvUse.setText(finalItems[which]);
                }
                // 대화상자 닫기
                dialog.dismiss();
            }
        });
        //대화상자를 띄워줌
        alertDialog.show();
    }
}