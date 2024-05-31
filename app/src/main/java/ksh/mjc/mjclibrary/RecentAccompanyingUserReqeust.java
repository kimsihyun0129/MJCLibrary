package ksh.mjc.mjclibrary;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RecentAccompanyingUserReqeust extends StringRequest {
    final static private String URL = "http://27.96.131.54:8080/2020081064/RecentAccompanyingUser.jsp";
    private Map<String,String> parameters;

    public RecentAccompanyingUserReqeust(int studentNumber, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("studentNumber", String.valueOf(studentNumber));
    }

    public Map<String,String> getParams() {
        return parameters;
    }
}

