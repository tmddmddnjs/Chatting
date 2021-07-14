package com.example.chatting.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chatting.MainActivity;
import com.example.chatting.R;
import com.example.chatting.server_chatting;

public class chatting_Fragment extends Fragment {
    private String name;
    chatting_Adapter adapter;
    ListView listView;
    MainActivity mainActivity;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.chatting_fragment, container, false); //container <-부모 사이즈를 주고 , false=아직 붙이지 않는다.
        listView = (ListView) rootView.findViewById(R.id.listView);

        this.Rev_Bundle();
        this.setDialog();
        this.Cilck_ListView();
        return rootView;
    }

    public void Cilck_ListView() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), server_chatting.class);
                startActivity(intent);
            }
        });
    }

    public void Rev_Bundle() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            name = bundle.getString("name");
        }
    }

    public void setDialog() {
        adapter = new chatting_Adapter();
        //텍스트 가져오기기
        adapter.addItem(name + "");
        listView.setAdapter(adapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }
}
