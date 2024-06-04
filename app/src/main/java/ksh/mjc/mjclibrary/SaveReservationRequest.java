package ksh.mjc.mjclibrary;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SaveReservationRequest extends StringRequest {
    final static private String URL = "http://27.96.131.54:8080/2020081064/SaveReservation.jsp";
    private Map<String,String> parameters;
    public SaveReservationRequest(int studentNumber, String studyRoomName, String reservationDate, String reservationStartTime, String reservationEndTime, String reservationUse, ArrayList<Student> alAccompanyingUser) {
        super(Request.Method.POST, URL, null, null);
        parameters = new HashMap<>();
        parameters.put("studentNumber", String.valueOf(studentNumber));
        parameters.put("studyRoomName", studyRoomName);
        parameters.put("reservationDate", reservationDate);
        parameters.put("reservationStartTime", reservationStartTime);
        parameters.put("reservationEndTime", reservationEndTime);
        parameters.put("reservationUse", reservationUse);

        for(int i=0; i<alAccompanyingUser.size();i++) {
            parameters.put("auStudentName"+i,alAccompanyingUser.get(i).getName().toString());
            parameters.put("auStudentNumber"+i, String.valueOf(alAccompanyingUser.get(i).getStudentNumber()));
        }
        parameters.put("count",String.valueOf(alAccompanyingUser.size()));
    }
    public Map<String,String> getParams() {
        return parameters;
    }
}
