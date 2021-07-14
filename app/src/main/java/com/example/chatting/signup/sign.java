package com.example.chatting.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chatting.R;

public class sign extends AppCompatActivity {
    EditText edit_id, edit_pass, edit_repass, edit_name;
    Button button1;
    String id, pass, repass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        this.Init();
        this.ClickSignupButton();
    }

    public void Init() {
        edit_id = (EditText) findViewById(R.id.edit_id);
        edit_pass = (EditText) findViewById(R.id.edit_pass);
        edit_repass = (EditText) findViewById(R.id.edit_repass);
        edit_name = (EditText) findViewById(R.id.edit_name);
        button1 = (Button) findViewById(R.id.button1);
    }

    //칸이 비었을 때
    public void ClickSignupButton() {
        //회원가입 버튼 눌렀을 때
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_id.getText().toString().length() == 0) {
                    Toast.makeText(sign.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (edit_pass.getText().toString().length() == 0) {
                    Toast.makeText(sign.this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (edit_repass.getText().toString().length() == 0) {
                    Toast.makeText(sign.this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (edit_name.getText().toString().length() == 0) {
                    Toast.makeText(sign.this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(sign.this, login.class);
                    startActivity(intent);
                }
            }
        });
    }

    //아이디 중복 확인 - 중복 확인 버튼 따로 만들어서 만들면 될 듯
    public void ConfirmId() {
        id = edit_id.getText().toString();
    }
    //비밀번호 확인 == 비밀번호 맞는지
    public void CorrectPassword(){
        pass = edit_pass.getText().toString();
        repass = edit_repass.getText().toString();
    }
}