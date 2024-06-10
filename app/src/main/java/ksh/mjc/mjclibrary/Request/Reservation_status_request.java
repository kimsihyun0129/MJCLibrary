package ksh.mjc.mjclibrary.Request;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Reservation_status_request extends StringRequest {
    final static private String URL = "http://27.96.131.54:8080/2020081064/UserReservationStatus.jsp";
    private Map<String,String> parameters;

    public Reservation_status_request( String studentNum, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("studentNumber", studentNum);
    }

    public Map<String,String> getParams() {
        return parameters;
    }
}
