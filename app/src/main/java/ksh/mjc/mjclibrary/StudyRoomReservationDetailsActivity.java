package ksh.mjc.mjclibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StudyRoomReservationDetailsActivity extends AppCompatActivity {

    ImageButton ibBack,ibSelectDate,ibSelectStartTime,ibSelectEndTime,ibUse;
    Button btnAddAccompanyingUser, btnReservation;
    TextView tvStudyRoomName, tvSelectDate, tvSelectStartTime, tvSelectEndTime, tvUse;
    int[] viewNames = {R.id.v9,R.id.v10,R.id.v11,R.id.v12,R.id.v13,R.id.v14,R.id.v15,R.id.v16,R.id.v17,R.id.v18,R.id.v19,R.id.v20,R.id.v21};
    View[] views = new View[viewNames.length];
    RadioGroup rgAgree;
    RadioButton rbYes, rbNo;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//날짜 형식 지정
    String dateItems[] = new String[7];
    String startTimeItems[] = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00"};
    String endTimeItems[] = {"10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00"};
    String useItems[] = {"스터디","모임/회의","기타"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_room_reservation_details);

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

        for(int i=0;i<viewNames.length;i++){
            views[i] = findViewById(viewNames[i]);
        }

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),StudyRoomReservationActivity.class);
                startActivity(intent);
            }
        });

        for(int i=0;i<dateItems.length;i++){
            dateItems[i] = sdf.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_YEAR,1);
        }

        Intent intent = getIntent();
        tvStudyRoomName.setText(intent.getStringExtra("studyRoomName"));
        tvSelectDate.setText(intent.getStringExtra("selectDate"));
    }

    public void onDropDownImageButtonClick(View v) {
        String[] items = null;
        if(v.getId()==R.id.tvSelectDate||v.getId()==R.id.ibSelectDate) items = dateItems;
        else if(v.getId()==R.id.tvSeletStartTime||v.getId()==R.id.ibSelectStartTime) items = startTimeItems;
        else if(v.getId()==R.id.tvSelectEndTime||v.getId()==R.id.ibSelectEndTime) items = endTimeItems;
        else if(v.getId()==R.id.tvUse||v.getId()==R.id.ibUse) items = useItems;

        //다이얼로그 생성
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        String[] finalItems = items;
        alertDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(finalItems == dateItems) {
                    tvSelectDate.setText(finalItems[which]);
                } else if(finalItems ==startTimeItems) {
                    tvSelectStartTime.setText(finalItems[which]);
                } else if(finalItems == endTimeItems) {
                    tvSelectEndTime.setText(finalItems[which]);
                } else if (finalItems == useItems) {
                    tvUse.setText(finalItems[which]);
                }
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}