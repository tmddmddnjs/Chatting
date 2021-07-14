package com.example.chatting.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chatting.MainActivity;
import com.example.chatting.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class login extends AppCompatActivity {
    private boolean saveLoginData;
    private String id;
    private String pwd;

    private EditText idText;
    private EditText pwdText;
    private CheckBox checkBox;
    private Button loginBtn;
    private Button signupBtn;

    Button testbutton;
    TextView testtext;

    private SharedPreferences appData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);// 설정값 불러오기
        appData = getSharedPreferences("appData", MODE_PRIVATE);
        load();

        idText = (EditText) findViewById(R.id.idText);
        pwdText = (EditText) findViewById(R.id.pwdText);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        signupBtn = (Button)findViewById(R.id.signupBtn);
        //##
        testbutton = (Button)findViewById(R.id.testbutton);
        testtext = (TextView)findViewById(R.id.testtext);

        // 이전에 로그인 정보를 저장시킨 기록이 있다면
        if (saveLoginData) {
            idText.setText(id);
            pwdText.setText(pwd);
            checkBox.setChecked(saveLoginData);
        }

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그인 성공시 저장 처리, 예제는 무조건 저장
                save();
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, sign.class);
                startActivity(intent);
            }
        });
        testbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = null;
                try {
                    // Open the connection
                    URL url = new URL("http://180.83.98.139:3000/login");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    InputStream is = conn.getInputStream();
                    // Get the stream
                    StringBuilder builder = new StringBuilder();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line+"\n");
                    } // Set the result
                    result = builder.toString();
                } catch (Exception e) {
                    // Error calling the rest api
                    Log.e("REST_API", "GET method failed: " + e.getMessage());
                    e.printStackTrace();
                }
                Log.d("TAG", "좆기훈하트제성덕" + result);
            }
        });
    }

    // 설정값을 저장하는 함수
    private void save() {
        // SharedPreferences 객체만으론 저장 불가능 Editor 사용
        SharedPreferences.Editor editor = appData.edit();

        // 에디터객체.put타입( 저장시킬 이름, 저장시킬 값 )
        // 저장시킬 이름이 이미 존재하면 덮어씌움
        editor.putBoolean("SAVE_LOGIN_DATA", checkBox.isChecked());
        editor.putString("ID", idText.getText().toString().trim());
        editor.putString("PWD", pwdText.getText().toString().trim());

        // apply, commit 을 안하면 변경된 내용이 저장되지 않음
        editor.apply();
    }

    // 설정값을 불러오는 함수
    private void load() {
        // SharedPreferences 객체.get타입( 저장된 이름, 기본값 )
        // 저장된 이름이 존재하지 않을 시 기본값
        saveLoginData = appData.getBoolean("SAVE_LOGIN_DATA", false);
        id = appData.getString("ID", "");
        pwd = appData.getString("PWD", "");
    }
}
