package com.programmer.smartfarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivitiesFragment extends Fragment implements View.OnClickListener {

    // here create handlers for the recyclerview
    //i.e variables
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private  View cardviewitems;
    private CardView cardView1,cardView2,cardView3,cardView4,cardView5;

    ArrayList<FarmActivities> activities;

    public ActivitiesFragment() {
        //required empty fragment
    }

    public static  ActivitiesFragment newInstance() {

        Bundle args = new Bundle();

        ActivitiesFragment fragment = new ActivitiesFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.activitiesfragment,container,false);

        //initialize the handler
        cardView1=view.findViewById(R.id.card1);
        cardView2=view.findViewById(R.id.card2);
        cardView3=view.findViewById(R.id.card3);
        cardView4=view.findViewById(R.id.card4);
        cardView5=view.findViewById(R.id.card5);
        //cardView1.findViewById(R.id.card1);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
        cardView5.setOnClickListener(this);



        recyclerView=view.findViewById(R.id.recyclerview);
        activities=new ArrayList<>();
        activities.add(new FarmActivities(R.drawable.planting,"Planting","The Offensive Security Certified Professional (OSCP) is the most well-recognized and respected certification available to info security professionals. Earning this designation indicates that you can conduct a penetration test from start to finish within a target-rich, diverse, and vulnerable network environment," +
                " a skill set that is highly valued and in increasing demand within the industry.\n"));
        activities.add(new FarmActivities(R.drawable.cultivating,"cultivation","The Offensive Security Certified Professional (OSCP) is the most well-recognized and respected certification available to info security professionals. Earning this designation indicates that you can conduct a penetration test from start to finish within a target-rich, diverse, and vulnerable network environment," +
                " a skill set that is highly valued and in increasing demand within the industry.\n"));
        activities.add(new FarmActivities(R.drawable.treatment,"treatment","The Offensive Security Certified Professional (OSCP) is the most well-recognized and respected certification available to info security professionals. Earning this designation indicates that you can conduct a penetration test from start to finish within a target-rich, diverse, and vulnerable network environment," +
                " a skill set that is highly valued and in increasing demand within the industry.\n"));

        activities.add(new FarmActivities(R.drawable.harvesting,"marketing","The Offensive Security Certified Professional (OSCP) is the most well-recognized and respected certification available to info security professionals. Earning this designation indicates that you can conduct a penetration test from start to finish within a target-rich, diverse, and vulnerable network environment," +
                " a skill set that is highly valued and in increasing demand within the industry.\n"));


        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        //intialize the integer and pass the integer array
        adapter=new RecyclerviewAdapter(this,activities);
        recyclerView.setAdapter(adapter);
        //super.onCreateView(inflater, container, savedInstanceState)
        return view;

    }
    //create and onclick listerner on the horizontal scrollview cards
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.card1:
                //Intent intent=new Intent(ActivitiesFragment.this,PlantingActivity.class);
                startActivity(new Intent(getActivity(),PlantingActivity.class));
                //finish();
                break;
            case R.id.card2:
                startActivity(new Intent(getActivity(),CultivationActivity.class));
                //finish();
                break;
            case R.id.card3:
                startActivity(new Intent(getActivity(),TreatmentActivity.class));
                break;
            case R.id.card4:
                startActivity(new Intent(getActivity(),Harvesting.class));
                break;
            case R.id.card5:
                startActivity(new Intent(getActivity(),MarkettingActivity.class));
                break;

        }

    }


    }



