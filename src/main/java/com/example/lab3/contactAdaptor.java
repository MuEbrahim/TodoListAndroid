package com.example.lab3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class contactAdaptor extends RecyclerView.Adapter<contactAdaptor.ViewHolder> {

    Context context;
    ArrayList<Pair<Boolean,Pair<String,String>>>  contact;
    Intent intent;

    public contactAdaptor(ArrayList<Pair<Boolean,Pair<String,String>>>  contact , Context context){
        this.contact = contact;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View contactLayout = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.contact, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactLayout);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Delete")
                .setCancelable(true)
                .setMessage("are you sure you want to delete this item?")
                .setNegativeButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        contact.remove(position);
                        notifyDataSetChanged();
                    }
        });

        final AlertDialog alertDialog1 = alertDialog.create();
        holder.nameTv.setText(contact.get(position).second.first);
        holder.phoneTv.setText(contact.get(position).second.second);
        holder.CB.setChecked(contact.get(position).first);
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                intent = new Intent(context, contactData.class);
                intent.putExtra("name",contact.get(position).second.first);
                intent.putExtra("phone",contact.get(position).second.second);
                intent.putExtra("checked",contact.get(position).first);
                context.startActivity(intent);

            }
        });

        holder.CB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair pair = contact.get(position).second;

                if(contact.get(position).first == true){

                    contact.remove(position);
                    Pair pair1 = new Pair<>(false,pair);
                    contact.add(position,pair1);
                }
                else{
                    contact.remove(position);
                    Pair pair1 = new Pair<>(true,pair);
                    contact.add(position,pair1);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                alertDialog1.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return contact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv,phoneTv;
        CheckBox CB;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTV);
            phoneTv = itemView.findViewById(R.id.phoneTV);
            CB = itemView.findViewById(R.id.CB);
        }
    }

    public interface  OnClickListener{
        void onClickDeleteItem();
    }
}
