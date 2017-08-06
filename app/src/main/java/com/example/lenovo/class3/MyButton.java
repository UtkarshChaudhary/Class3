package com.example.lenovo.class3;

/**
 * Created by lenovo on 15-06-2017.
 */


import android.content.Context;
import android.widget.Button;


/**
 * Created by manishakhattar on 15/06/17.
 */

public class MyButton  extends Button {
    int player;

    public MyButton(Context context) {
        super(context);
        player = MainActivity.NO_PLAYER;
    }


    int getPlayer(){
        return  player;
    }

}

