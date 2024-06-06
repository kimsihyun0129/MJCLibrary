package ksh.mjc.mjclibrary;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class userheadrequest extends StringRequest {
    final static private String URL = "http://27.96.131.54:8080/2020081064/userhead.jsp";
    public userheadrequest(Response.Listener<String> listener) {
        super(Request.Method.POST, URL, listener, null);
    }

}
