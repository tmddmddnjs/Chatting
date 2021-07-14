package com.example.chatting.friends;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.chatting.R;
import com.example.chatting.chatting.chatting_Fragment;

public class friends_Fragment extends Fragment {
    ImageButton plus_friend;
    Dialog dialog;
    EditText name_edit, number_edit;
    private String name, number;
    friends_Adapter adapter;
    ListView listView;
    //데이터 기억하기
    private SharedPreferences appData;
    private String prefFile = "com.example.chatting_program";

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.friends_fragment, container, false); //container <-부모 사이즈를 주고 , false=아직 붙이지 않는다.
        //init
        plus_friend = (ImageButton) rootView.findViewById(R.id.plus_friend);
        listView = (ListView) rootView.findViewById(R.id.listView);

        dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.plus_friend_dialog);
        //설정 값 불러오기
        appData = getContext().getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        name = appData.getString("NAME", "");
        number = appData.getString("NUMBER", "");
        //dialog로 친구 추가
        this.Cilck_ListView();
        this.setDialog();
        return rootView;
    }

    public void Cilck_ListView() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                chatting_Fragment fragment = new chatting_Fragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.frameLayout, fragment);
                fragmentTransaction.commit();
            }
        });
    }

    public void setDialog() {
        plus_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        Button okBtn = dialog.findViewById(R.id.okBtn);
        name_edit = dialog.findViewById(R.id.name_edit);
        number_edit = dialog.findViewById(R.id.number_edit);
        adapter = new friends_Adapter();
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //텍스트 가져오기기
                name = name_edit.getText().toString();
                number = number_edit.getText().toString();
                SharedPreferences.Editor editor = appData.edit();
                editor.putString("NAME", name);
                editor.putString("NUMBER", number);
                editor.apply();
                if (name_edit.equals("") || number_edit.length() == 0) {

                }
                dialog.dismiss();

                adapter.addItem(name + "", number + "");
                listView.setAdapter(adapter);
                //설정하고 나면 다시 초기화
                name_edit.setText("");
                number_edit.setText("");
            }
        });

        Button noBtn = dialog.findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
