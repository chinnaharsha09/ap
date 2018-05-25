package chinna.com.retrofitexample.Adaptors;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chinna.com.retrofitexample.ProfilesVO;
import chinna.com.retrofitexample.R;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MovieViewHolder> {

    private List<ProfilesVO> profiles;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView age;
        TextView id;
        TextView address;


        public MovieViewHolder(View v) {
            super(v);
            name = v.findViewById(R.id.name_tv);
            age = v.findViewById(R.id.age_tv);
            id = v.findViewById(R.id.id_tv);
            address = v.findViewById(R.id.address_tv);
        }
    }

    public ProfileAdapter(List<ProfilesVO> profiles, Context context) {
        this.profiles = profiles;
        this.context = context;
    }

    @Override
    public ProfileAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.name.setText(profiles.get(position).getName());
       holder.age.setText(profiles.get(position).getAge());
       holder.id.setText(profiles.get(position).getId());
       holder.address.setText(profiles.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }
}