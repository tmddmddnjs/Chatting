package com.example.chatting.friends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chatting.R;

import java.util.ArrayList;

public class friends_Adapter extends BaseAdapter {
    private ArrayList<Friends> list = new ArrayList<>();


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.friend_list, parent, false);
        }
        //ImageView img = (ImageView) convertView.findViewById(R.id.img);
        TextView t1 = (TextView) convertView.findViewById(R.id.name_text);
        TextView t2 = (TextView) convertView.findViewById(R.id.number_text);

        t1.setText(list.get(position).getName());
        t2.setText(list.get(position).getTel());

        return convertView;
    }
    public void addItem(String name, String number){
        Friends item = new Friends();
        //item.setIcon(img);
        item.setName(name);
        item.setTel(number);
        list.add(item);
    }
}
