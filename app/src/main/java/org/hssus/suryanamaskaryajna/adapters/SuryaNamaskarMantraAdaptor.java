package org.hssus.suryanamaskaryajna.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hssus.suryanamaskaryajna.BaseActivity;
import org.hssus.suryanamaskaryajna.R;
import org.hssus.suryanamaskaryajna.SuryaNamaskarHelp;

/**
 * Created by prasadkhandat on 10/10/17.
 */

public class SuryaNamaskarMantraAdaptor  extends RecyclerView.Adapter<SuryaNamaskarMantraAdaptor.ViewHolder> {
    private String[] mDataset;
    private Context context;
    private String[] meanings;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imgPose;
        public TextView sn_name,sn_meaning;
        public LinearLayout row_layout;
        public ViewHolder(View v) {
            super(v);
            sn_name = (TextView) v.findViewById(R.id.txt_sn_name);
            sn_meaning = (TextView) v.findViewById(R.id.txt_sn_meaning);
            imgPose = (ImageView) v.findViewById(R.id.sn_post_img);
            row_layout=(LinearLayout)v.findViewById(R.id.row_layout);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SuryaNamaskarMantraAdaptor(String[] myDataset,String[] meanings,Context context) {
        mDataset = myDataset;
        this.meanings=meanings;
        this.context=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SuryaNamaskarMantraAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sn_meaning_row, parent, false);
        // set the view's size, margins, paddings and layout parameters

        SuryaNamaskarMantraAdaptor.ViewHolder vh = new SuryaNamaskarMantraAdaptor.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(SuryaNamaskarMantraAdaptor.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.sn_name.setText(mDataset[position]);
        holder.sn_meaning.setText(meanings[position]);

        switch (position) {
            case 0:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn1, ((BaseActivity) context).getTheme()));
                break;
            case 1:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn2, ((BaseActivity) context).getTheme()));
                break;
            case 2:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn3, ((BaseActivity) context).getTheme()));
                break;
            case 3:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn4, ((BaseActivity) context).getTheme()));
                break;
            case 4:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn5, ((BaseActivity) context).getTheme()));
                break;
            case 5:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn6, ((BaseActivity) context).getTheme()));
                break;
            case 6:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn7, ((BaseActivity) context).getTheme()));
                break;
            case 7:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn8, ((BaseActivity) context).getTheme()));
                break;
            case 8:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn9, ((BaseActivity) context).getTheme()));
                break;
            case 9:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn10, ((BaseActivity) context).getTheme()));
                break;
            case 10:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn11, ((BaseActivity) context).getTheme()));
                break;
            case 11:
                holder.imgPose.setImageDrawable((((BaseActivity) context).getResources()).getDrawable(R.drawable.sn12, ((BaseActivity) context).getTheme()));
                break;


        }

        if(position%2==0)
            holder.row_layout.setBackgroundColor(Color.rgb(211,211,211));
        else
            holder.row_layout.setBackgroundColor(Color.rgb(255,255,255));



        //Log.d("Adapter", "onBindViewHolder: "+mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}