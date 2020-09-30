package com.programmer.smartfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.MediaRouteButton;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Home extends AppCompatActivity {
    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       // var notificationsBadge : View? =null
                //private fun getBadge() :View{

       // }
        addBadgeview();

        //the Hooks press Ctrl +D to duplicate them then change the id's
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigationView);
        toolbar=findViewById(R.id.toolbar1);

        //toolbar code
        setSupportActionBar(toolbar);

        //navigation drawer code then pass this keyword and drawer layout
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //this sets the naviagation items clickable
        //navigationView.setNavigationItemSelectedListener(this);

        //In this create a hook to bottom navigation activity
        BottomNavigationView bottomNavigationView=findViewById(R.id.appnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        // when you open the app it shows zzero gragment until you click on of the item , to solve this dilemma you set
        // the first item clicked to be in default as shown
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
    }

    private void addBadgeview() {
        try{
            BottomNavigationMenuView menuView=(BottomNavigationMenuView) navigationView.getChildAt(0);
            BottomNavigationItemView itemView=(BottomNavigationItemView) menuView.getChildAt(2);
            View notificationBadge = LayoutInflater.from(Home.this).inflate(R.layout.custom_layout, menuView, false);
            itemView.addView(notificationBadge);
            notificationBadge.setVisibility(GONE);//initially badge will be invisible
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //refresh badge
    //private  void refreshBadgeView(){
        //try {
            //boolean badgeIsVisible= notificationsBadge.getVisibility() !=GONE;
            //MediaRouteButton notificationBadge;
            //notificationBadge.setVisibility(badgeIsVisible ? GONE : VISIBLE);//makes badge visible and invisible

        //}catch (Exception e){
            //e.printStackTrace();
       // }
    //}

    // create reactions to clicks on the bottom naviagation items
    private  BottomNavigationView.OnNavigationItemSelectedListener navListener=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment=null;

            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    selectedFragment=new HomeFragment();
                    break;
                case R.id.activities:
                    selectedFragment=new ActivitiesFragment();
                    break;
                case R.id.notification:
                    selectedFragment=new UpdatesFragment();
                    break;


            }
            // we have written fragments we can click on the items but we can not show the fragments, to show the fragments
            //we use the following code
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,selectedFragment).commit();

            //return boolean (true) to show you have returned the selected item ,
            // when we return false the fragment will be shown but item will not be clicked
            return  true;
        }
    };
}
