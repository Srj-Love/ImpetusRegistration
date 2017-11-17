package com.srjlove.impetusregistration;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Suraj on 11/17/2017.
 */

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Model> mList;


    public CustomListAdapter(Context mContext, ArrayList<Model> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list, parent, false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Model model = mList.get(position);
        holder.fn.setText(String.format("First Name : %s", model.getFname()));
        holder.ln.setText(String.format("Last Name : %s", model.getLname()));
        holder.email.setText(String.format("EMAIL  : %s", model.getEmail()));
        holder.pass.setText(String.format(" PASSWORD : %s", String.valueOf(model.getPass())));
        holder.mob.setText(String.format(" MOBILE NUMBER : %s", String.valueOf(model.getMob())));

        holder.imageView.setImageBitmap(BitmapFactory.decodeByteArray(model.getImage(), 0, model.getImage().length));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


//    CustomListAdapter(@NonNull Context mContext, int resource, ArrayList<Model> mList) {
//        super(mContext, resource);
//        this.mContext = mContext;
//        this.mList = mList;
//        mInflater = LayoutInflater.from(mContext);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//         mView = convertView;
//        if (mView == null) {
//            mView = mInflater.inflate(R.layout.data_list, parent, false);
//        }
//        Model model = getItem(position);
//
//        fn = mView.findViewById(R.id.tv_fname);
//        ln = mView.findViewById(R.id.tv_lname);
//        email = mView.findViewById(R.id.tv_email);
//        mob = mView.findViewById(R.id.tv_mob);
//        pass = mView.findViewById(R.id.tv_pass);
//
//        if (model != null) {
//
//            fn.setText(String.format("First Name : %s", model.getFname()));
//            ln.setText(String.format("Last Name : %s", model.getLname()));
//            email.setText(String.format("EMAIL  : %s", model.getEmail()));
//            pass.setText(String.format(" PASSWORD : %s", String.valueOf(model.getPass())));
//            mob.setText(String.format(" MOBILE NUMBER : %s", String.valueOf(model.getMob())));
//        }
//
//        return mView;
//    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fn, ln, email, mob, pass;
        ImageView imageView;

        public MyViewHolder(View mView) {
            super(mView);
            fn = mView.findViewById(R.id.tv_fname);
            ln = mView.findViewById(R.id.tv_lname);
            email = mView.findViewById(R.id.tv_email);
            mob = mView.findViewById(R.id.tv_mob);
            pass = mView.findViewById(R.id.tv_pass);
            imageView = mView.findViewById(R.id.image);
//

        }
    }

}
