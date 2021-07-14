package com.example.chatting;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatting.R;

import java.net.Socket;
import java.net.URL;

import io.socket.client.IO;

public class server_chatting extends AppCompatActivity {
    private static final String SERVER_ADDRESS = "192.168.0.9";
    Socket socket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_chatting);

        //server로 연결해서 채팅이 이루어질 페이지
    }
    private void Init(){

    }
    private void server(){
        if(socket != null) return;
        try{
            String host = SERVER_ADDRESS;
            int port = 5555;
            URL url = new URL("http", host, port, "/");
//            socket = IO.socket(url.toURI());
//            socket.connect();
        }
        catch (Exception e){

        }
    }

}