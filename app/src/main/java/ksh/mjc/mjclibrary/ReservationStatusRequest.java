package ksh.mjc.mjclibrary;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ReservationStatusRequest extends StringRequest {
    final static private String URL = "http://27.96.131.54:8080/2020081064/ReservationStatus.jsp";
    private Map<String,String> parameters;

    public ReservationStatusRequest(String selectedDate, String studyRoomName, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("selectedDate", selectedDate);
        parameters.put("studyRoomName", studyRoomName);
    }

    public Map<String,String> getParams() {
        return parameters;
    }
}
