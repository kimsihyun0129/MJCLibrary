package ksh.mjc.mjclibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StudyRoomReservationActivity extends AppCompatActivity {

    ImageButton ibBack,ibSelectDate;//뒤로가기 버튼, 날짜선택버튼
    TextView tvSelectDate;//날짜선택 텍스트뷰
    ListView lvStudyRoom;//리스트뷰
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
        lvStudyRoom = findViewById(R.id.lvStudyRoom);

        tvSelectDate.setText(sdf.format(calendar.getTime()));

        for(int i=0;i<dateItems.length;i++){
            dateItems[i] = sdf.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_YEAR,1);
        }
    }


    public void onSelectDateButtonClick(View v) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setSingleChoiceItems(dateItems, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}