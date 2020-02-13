package com.github.gmetal.haecsample;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MyClickListener implements View.OnClickListener {

    private Context context;

    public MyClickListener(Context ctx) {

        context = ctx;
    }

    @Override
    public void onClick(final View v) {

        Toast.makeText(context, "Hello world from MyClickListener!", Toast.LENGTH_SHORT).show();
    }
}
