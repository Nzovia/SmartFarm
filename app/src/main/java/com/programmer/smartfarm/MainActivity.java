package com.programmer.smartfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //here create a private variable to enhance splashing
    private static int SPLASH_SCREEN = 5000;

    //variables
    //ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to hide status bar the follwoing line of code does it
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        //Hooks for passing the variables to the layout file
        //imageView=findViewById(R.id.splashscreen);
        textView=findViewById(R.id.welcome);

        // creating splash by calling intent using delay method
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this,Home.class);
                //This will facilitate opening the next activity the dashboard
                startActivity(intent);
                /**this closes the itent activity in such a way that when the user clicks back button he cannot go back to the welcome
                 that is removing this activity from the activity list**/
                finish();
            }
        },SPLASH_SCREEN);

    }
}
