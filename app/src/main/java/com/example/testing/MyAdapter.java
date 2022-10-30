//package com.example.testing;
//
//        import android.annotation.SuppressLint;
//        import android.content.Context;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.TextView;
//
//        import androidx.annotation.NonNull;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import java.text.BreakIterator;
//        import java.util.ArrayList;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//    private Context context;
//    private ArrayList Exercise, reps;
//    DBHelper DB;
//
//    public MyAdapter(Context context, ArrayList Exercise, ArrayList reps) {
//        this.context = context;
//        this.Exercise = Exercise;
//        this.reps = reps;
//
//    }
//
//    @NonNull
//    @Override
//    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
//        return new MyViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        holder.Exercise.setText(String.valueOf(Exercise.get(position)));
//        holder.reps.setText(String.valueOf(reps.get(position)));
//       // String Exercises = String.valueOf(Exercise.get(position));
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return Exercise.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView Exercise, reps;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            Exercise = itemView.findViewById(R.id.addex);
//            reps = itemView.findViewById(R.id.addreps);
//        }
//    }
//}



package com.example.testing;

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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private ArrayList Exercise, reps;
    DBHelper DB;


    public MyAdapter(Context context, ArrayList Exercise, ArrayList reps) {
        this.context = context;
        this.Exercise = Exercise;
        this.reps = reps;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View otherView = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(otherView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.Exercise.setText(String.valueOf(Exercise.get(position)));
        holder.reps.setText(String.valueOf(reps.get(position)));


        String Ex = String.valueOf(Exercise.get(position));

        //delete button
        holder.delete.setOnClickListener(new View.OnClickListener() {
            DBHelper db = new DBHelper(context);
            @Override
            public void onClick(View view) {
                Boolean deleteAct = db.deleteExercise(Ex);
                if (deleteAct == true) {
                    Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                    Exercise.remove(position);
                    notifyDataSetChanged ();
                }
                else
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
            }
        });

   }

    @Override
    public int getItemCount() {
        return Exercise.size();
    }

        public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Exercise, reps;
        Button delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Exercise = itemView.findViewById(R.id.textname);
            reps = itemView.findViewById(R.id.textreps);
            delete = (Button) itemView.findViewById(R.id.deleteBtn);
        }
    }
}
