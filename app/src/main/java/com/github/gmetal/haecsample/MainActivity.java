package com.github.gmetal.haecsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button anonymousClassListenerButton = findViewById(R.id.anonymous_class_listener_button);
        // Set an OnClickListener to react to button presses
        // in this level the keyword this refers to the MainActivity
        anonymousClassListenerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {

                // Here we are inside an anonymous class, therefore this refers to an anonymous class, and
                // not to the MainActivity. However, because this is an anonymous class, we can use the
                // MainActivity.this, to refer to the corresponding MainActivity object
                Toast.makeText(MainActivity.this, "Hello world from anonymous class!", Toast.LENGTH_SHORT).show();
            }
        });

        // The code above with the anonymous class is equivalent to the code below
        // In essence this is similar to what the compiler does when compiling the code above ^^
        // Here we create a named class MyClickListener, that implements the View.OnClickListener interface
        // We create a new instance of the class, pass it a Context (the MainActivity is a Context) and we register
        // it to receive the click events of the button
        Button myClickListenerButton = findViewById(R.id.my_click_listener_button);
        myClickListenerButton.setOnClickListener(new MyClickListener(this));

        // Another way to use the click listener is by implementing the View.OnClickListener interface in the Activity and using
        // it as follows:
        Button mainActivityClickListenerButton = findViewById(R.id.main_activity_listener_button);
        mainActivityClickListenerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {

        if (v.getId() == R.id.main_activity_listener_button) {
            Toast.makeText(this, "Hello from MainActivity click listener!", Toast.LENGTH_SHORT).show();
        }
    }
}
