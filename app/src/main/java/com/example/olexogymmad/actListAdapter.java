package com.example.olexogymmad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class actListAdapter extends RecyclerView.Adapter<actListAdapter.paymentViewHolder> {
    private Context context;
    private ArrayList act_id, day_id, time_id;
    DBHelper db;


    public actListAdapter(Context context, ArrayList act_id, ArrayList day_id, ArrayList time_id) {
        this.context = context;
        this.act_id = act_id;
        this.day_id = day_id;
        this.time_id = time_id;
    }

    @NonNull
    @Override
    public actListAdapter.paymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View otherView = LayoutInflater.from(context).inflate(R.layout.otheractentry,parent,false);
        return new paymentViewHolder(otherView);
    }

    @Override
    public void onBindViewHolder(@NonNull actListAdapter.paymentViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.activity.setText(String.valueOf(act_id.get(position)));
        holder.day.setText(String.valueOf(day_id.get(position)));
        holder.time.setText(String.valueOf(time_id.get(position)));
        String act = String.valueOf(act_id.get(position));
        //delete button
        holder.delete.setOnClickListener(new View.OnClickListener() {
        DBHelper db = new DBHelper(context);
            @Override
            public void onClick(View view) {
                Boolean deleteAct = db.deleteActivityData(act);
                if (deleteAct == true) {
                    Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                    act_id.remove(position);
                    notifyDataSetChanged ();
                }
                else
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return act_id.size();
    }

    public class paymentViewHolder extends RecyclerView.ViewHolder {
        TextView activity, day, time;
        Button delete;
        public paymentViewHolder(@NonNull View itemView) {
            super(itemView);
            activity = itemView.findViewById(R.id.actText);
            day = itemView.findViewById(R.id.dayText);
            time = itemView.findViewById(R.id.timeText);
            delete = (Button)itemView.findViewById(R.id.deleteBtn);
        }
    }
}
