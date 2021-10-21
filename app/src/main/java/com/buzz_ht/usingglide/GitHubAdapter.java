package com.buzz_ht.usingglide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.GitHubViewHolder> {

    private Context context;
    private User[] data;

    public GitHubAdapter(Context context, User[] data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GitHubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_layout,parent,false);
        return new GitHubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubViewHolder holder, int position) {
            User user = data[position];
            holder.txtUser.setText(user.getLogin());
            Glide.with(holder.imgUser.getContext()).load(user.getAvatarUrl()).into(holder.imgUser);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GitHubViewHolder extends RecyclerView.ViewHolder{

        ImageView imgUser;
        TextView txtUser;


        public GitHubViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.imgUser);
            txtUser = itemView.findViewById(R.id.txtUser);

        }
    }



}
