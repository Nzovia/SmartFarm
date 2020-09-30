package com.programmer.smartfarm;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PlantingActivity extends AppCompatActivity {
    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planting);

       toolbar=(Toolbar) findViewById(R.id.plantbar);
       setSupportActionBar(toolbar);
       //remove title in toolbar appcompat
       getSupportActionBar().setTitle("planting practices");

       //toolbar.setBackgroundColor();
       toolbar.setNavigationIcon(R.drawable.ic_back);
       toolbar.setNavigationOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(PlantingActivity.this,Home.class);
               startActivity(intent);

           }
       });
    }

}
