package com.example.chatting.friends;

import android.graphics.drawable.Drawable;

public class Friends {
    private Drawable icon;
    private String name;
    private String number;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return number;
    }

    public void setTel(String number) {
        this.number = number;
    }
}
