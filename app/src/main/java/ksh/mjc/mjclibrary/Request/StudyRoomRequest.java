package ksh.mjc.mjclibrary.Request;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class StudyRoomRequest extends StringRequest {
    final static private String URL = "http://27.96.131.54:8080/2020081064/StudyRoom.jsp";
    public StudyRoomRequest(Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
    }
}
