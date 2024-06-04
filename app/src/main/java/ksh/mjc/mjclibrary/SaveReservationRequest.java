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
        JSONArray jsonArray = new JSONArray();
        for(int i=0; i<alAccompanyingUser.size();i++) {
            Student student = alAccompanyingUser.get(i);
            JSONObject studentJson = new JSONObject();
            try {
                studentJson.put("auStudentName", student.getName().toString());
                studentJson.put("auStudentNumber", String.valueOf(student.getStudentNumber()));
                Log.d("SaveReservationRequest", "Added student: " + student.getName() + ", " + student.getStudentNumber());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(studentJson);
        }
        Log.d("SaveReservationRequest", "JSON Array: " + jsonArray.toString());
        parameters.put("alAccompanyingUser", jsonArray.toString());
    }
    public Map<String,String> getParams() {
        return parameters;
    }
}
