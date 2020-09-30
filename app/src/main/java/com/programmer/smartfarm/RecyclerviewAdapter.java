package com.programmer.smartfarm;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

//this recyclerview extends recyclerview.adapter and then the adapter type is speciffied as"viewhplder we just created
public class RecyclerviewAdapter extends  RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>{

    private ActivitiesFragment mContext;
    private  ArrayList<FarmActivities> mList;
    public  RecyclerviewAdapter(ActivitiesFragment context, ArrayList<FarmActivities> list){
        //mContext=context;
        this.mList=list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this is the method responsible for inflating the view and it is called to create each of the items in the recyclerview
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_items,parent,false);
        //create a viewholder object and pass view
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //this view changes depending on what your layouts are and how you want them to
        // look like and when called it places the views on the view component
        Log.d(TAG, "onBindViewHolder: called.");

        FarmActivities cardviewItems=mList.get(position);

        ImageView imageview=holder.imageView;
        TextView title,description;

        title=holder.title;
        description=holder.description;

        imageview.setImageResource(cardviewItems.getImage());
        title.setText(cardviewItems.getTitle());
        description.setText(cardviewItems.getDescription());

    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    //create a viewholderclass that extends recyclerviewholder

    public class  ViewHolder extends RecyclerView.ViewHolder {
        // this viewholder holds each of the items individually in memory
        ImageView imageView;
        TextView title,description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //initializing the variables
            imageView=itemView.findViewById(R.id.imageview);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);

        }
    }

}
