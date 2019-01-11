package com.example.lenovo.ratemysignings;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        ListItem listItem=listItems.get(i);
        viewHolder.textViewUser.setText(listItem.getUser());
        viewHolder.textViewName.setText(listItem.getName());
        viewHolder.textViewAge.setText(listItem.getAge());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewUser,textViewName,textViewAge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewUser=(TextView)itemView.findViewById(R.id.textViewUser);
            textViewName=(TextView)itemView.findViewById(R.id.textViewName);
            textViewAge=(TextView)itemView.findViewById(R.id.textViewAge);


        }
    }
}
