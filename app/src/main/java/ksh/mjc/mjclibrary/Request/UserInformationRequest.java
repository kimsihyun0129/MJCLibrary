package ksh.mjc.mjclibrary.Request;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UserInformationRequest extends StringRequest {
    final static private String URL = "http://27.96.131.54:8080/2020081064/UserInformation.jsp";
    private Map<String,String> parameters;

    public UserInformationRequest(String studentNumber, Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("studentNumber", studentNumber);
    }

    public Map<String,String> getParams() {
        return parameters;
    }
}
