package ksh.mjc.mjclibrary.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ksh.mjc.mjclibrary.DTO.Login;
import ksh.mjc.mjclibrary.R;
import ksh.mjc.mjclibrary.DTO.Reservation_status;
import ksh.mjc.mjclibrary.Adapter.Reservation_status_adapter;
import ksh.mjc.mjclibrary.Request.Reservation_status_request;

public class Reservation_status_Main extends AppCompatActivity {
    private Login loginDTO;
    String studentNum;
    ArrayList<Reservation_status> rvstatus;
    Reservation_status_adapter reservationStatusAdapter;
    ListView rvlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_status);


        loginDTO = (Login)getIntent().getSerializableExtra("loginDTO");
        studentNum = String.valueOf(loginDTO.getStudentNumber());
        rvlist = findViewById(R.id.rvreservation_status);
        rvstatus = new ArrayList<Reservation_status>();
        reservationStatusAdapter = new Reservation_status_adapter(getApplicationContext(),rvstatus);
        rvlist.setAdapter(reservationStatusAdapter);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray studyRoomNames = jsonResponse.getJSONArray("studyRoomNames");
                    Log.d("test1", studyRoomNames.getString(0));
                    JSONArray reservationDates  = jsonResponse.getJSONArray("reservationDates");
                    Log.d("test1", reservationDates.getString(0));
                    JSONArray reservationStartTimes = jsonResponse.getJSONArray("reservationStartTimes");
                    Log.d("test1", reservationStartTimes.getString(0));
                    JSONArray reservationEndTimes = jsonResponse.getJSONArray("reservationEndTimes");
                    Log.d("test1", reservationEndTimes.getString(0));
                    JSONArray reservationUses = jsonResponse.getJSONArray("reservationUses");
                    Log.d("test1", reservationUses.getString(0));

                    rvstatus.clear();
                    Log.d("ReservationStatus", "JSON Data Received");

                    for (int i = 0; i < studyRoomNames.length(); i++) {
                        rvstatus.add(new Reservation_status(
                                studyRoomNames.getString(i),
                                reservationDates.getString(i),
                                reservationStartTimes.getString(i),
                                reservationEndTimes.getString(i),
                                reservationUses.getString(i)
                        ));
                        Log.d("ReservationStatus", "Added: " + studyRoomNames.getString(i));
                    }reservationStatusAdapter.notifyDataSetChanged();





                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        Reservation_status_request reservationStatusRequest = new Reservation_status_request( studentNum, responseListener);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(reservationStatusRequest);

    }

        }
