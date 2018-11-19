package com.example.admin.menu_demo;

import android.content.Context;
import android.widget.Toast;

public class MessageHelper {

    static void showMessage(Context context,String smg){
        Toast.makeText(context, smg, Toast.LENGTH_SHORT).show();
    }
}
