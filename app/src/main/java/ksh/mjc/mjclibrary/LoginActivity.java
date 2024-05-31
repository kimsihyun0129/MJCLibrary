package ksh.mjc.mjclibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private int studentNumber, password;//학번과 비밀번호를 저장할 변수
    EditText etStudentNumber,etPassword; //학번/비밀번호 입력란
    TextView tvIdHint,tvPasswordHint;//힌트나 오류메시지를 띄워줄 텍스트뷰
    Button btnLogin;//로그인 버튼
    private Login loginDTO;//로그인 정보를 저장할 DTO
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etStudentNumber = findViewById(R.id.etStudentNumber);
        etPassword = findViewById(R.id.etPassword);
        tvIdHint = findViewById(R.id.tvIdHint);
        tvPasswordHint = findViewById(R.id.tvPasswordHint);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentNumberStr = etStudentNumber.getText().toString();//입력한 학번을 저장하는 문자열 변수
                String passwordStr = etPassword.getText().toString();//입력한 비밀번호를 저장하는 문자열 변수

                boolean isValid = true;//학번과 비밀번호가 맞게 입력됐는지 확인하는 변수

                //예외처리
                try {
                    // 학번 입력 확인
                    if (TextUtils.isEmpty(studentNumberStr)) {
                        throw new IllegalArgumentException("학번을 입력해주세요.");
                    }

                    // 학번이 숫자인지 확인
                    if (!studentNumberStr.matches("\\d+")) {
                        throw new NumberFormatException("학번을 숫자로 입력해주세요.");
                    }

                    // 학번의 길이 확인
                    if (studentNumberStr.length() != 10) {
                        throw new IllegalArgumentException("학번은 10자리입니다.");
                    }

                    // 비밀번호 입력 확인
                    if (TextUtils.isEmpty(passwordStr)) {
                        throw new IllegalArgumentException("비밀번호를 입력해주세요.");
                    }

                    // 비밀번호가 숫자인지 확인
                    if (!passwordStr.matches("\\d+")) {
                        throw new NumberFormatException("비밀번호를 숫자로 입력해주세요.");
                    }

                    // 비밀번호의 길이 확인
                    if (passwordStr.length() != 8) {
                        throw new IllegalArgumentException("비밀번호는 생년월일 8자리입니다.");
                    }
                } catch (NumberFormatException e) {
                    isValid = false;//학번이나 비밀번호가 형식에 맞지 않음
                    // 학번 입력이 숫자가 아닌 경우와 비밀번호 입력이 숫자가 아닌 경우를 개별적으로 처리
                    if (e.getMessage().equals("학번을 숫자로 입력해주세요.")) {
                        tvIdHint.setText(e.getMessage());
                        tvPasswordHint.setText("비밀번호는 생년월일 8자리입니다.");
                        tvPasswordHint.setTextColor(getResources().getColor(R.color.black));
                    } else if (e.getMessage().equals("비밀번호를 숫자로 입력해주세요.")) {
                        tvIdHint.setText("");
                        tvPasswordHint.setText(e.getMessage());
                        tvPasswordHint.setTextColor(getResources().getColor(R.color.error_message));
                    }
                } catch (IllegalArgumentException e) {
                    isValid = false;//학번이나 비밀번호가 형식에 맞지 않음
                    // 학번과 비밀번호를 입력하지 않았거나 잘못입력되었을 경우를 개별적으로 처리
                    if (e.getMessage().equals("학번을 입력해주세요.")) {
                        tvIdHint.setText(e.getMessage());
                        tvPasswordHint.setText("비밀번호는 생년월일 8자리입니다.");
                        tvPasswordHint.setTextColor(getResources().getColor(R.color.black));
                    } else if (e.getMessage().equals("학번은 10자리입니다.")) {
                        tvIdHint.setText(e.getMessage());
                        tvPasswordHint.setText("비밀번호는 생년월일 8자리입니다.");
                        tvPasswordHint.setTextColor(getResources().getColor(R.color.black));
                    } else if (e.getMessage().equals("비밀번호를 입력해주세요.")) {
                        tvIdHint.setText("");
                        tvPasswordHint.setText(e.getMessage());
                        tvPasswordHint.setTextColor(getResources().getColor(R.color.error_message));
                    } else if (e.getMessage().equals("비밀번호는 생년월일 8자리입니다.")) {
                        tvIdHint.setText("");
                        tvPasswordHint.setText(e.getMessage());
                        tvPasswordHint.setTextColor(getResources().getColor(R.color.error_message));
                    }
                }

                if(isValid) {
                    // 오류메시지 삭제
                    tvIdHint.setText("");
                    tvPasswordHint.setText("");

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if(success) { //학번과 비밀번호 인증이 성공이면
                                    //학번과 이름 저장
                                    studentNumber = Integer.parseInt(studentNumberStr);
                                    password = Integer.parseInt(passwordStr);
                                    loginDTO = new Login(studentNumber, password);

                                    //메인화면으로 이동
                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                    intent.putExtra("loginDTO", loginDTO);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, "아이디와 비밀번호가 유효하지 않습니다.\n다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                                    tvPasswordHint.setText("비밀번호는 생년월일 8자리입니다.");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    LoginRequest loginRequest = new LoginRequest(studentNumberStr, passwordStr, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                    queue.add(loginRequest);
                }

            }
        });
    }
}
