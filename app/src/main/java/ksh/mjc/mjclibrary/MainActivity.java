package ksh.mjc.mjclibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnBooksearch, btnStudyRoom;
    private Login loginDTO;

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    ImageButton person;
    TextView userInFor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigationView);

        drawerLayout = findViewById(R.id.drawer_layout);

        person = findViewById(R.id.personIcon);

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
                userInFor = findViewById(R.id.userInFor);
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            String studentName = jsonResponse.getString("studentName");
                            String department = jsonResponse.getString("department");
                            userInFor.setText("사용자 : "+loginDTO.getStudentNumber()+"\n학번 : "+studentName+"\n학과 : "+department);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                UserInformationRequest userInformationRequest = new UserInformationRequest(String.valueOf(loginDTO.getStudentNumber()),responseListener);
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                queue.add(userInformationRequest);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int itemId = menuItem.getItemId();
                if (itemId == R.id.reservation) {
                  Intent intent = new Intent(getApplicationContext(), Reservation_status_Main.class);
                    intent.putExtra("loginDTO",loginDTO);
                    startActivity(intent);

                    return true;
                } else if (itemId == R.id.log_out) {
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawers();
                    return true;
                }

                return false;
            }
        });

        btnBooksearch = findViewById(R.id.btnBookResearch);
        btnStudyRoom = findViewById(R.id.btnStudyRoom);

        loginDTO = (Login)getIntent().getSerializableExtra("loginDTO");

        //도서 검색 버튼을 클릭하면
        btnBooksearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, booksearch.class);
                startActivity(intent);
            }
        });

        //스터디룸 예약 버튼을 클릭하면
        btnStudyRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //인텐트를 사용하여 스터디룸 예약 화면으로 이동
                Intent intent = new Intent(MainActivity.this, StudyRoomReservationActivity.class);
                intent.putExtra("loginDTO",loginDTO);
                startActivity(intent);
            }
        });
    }
}
