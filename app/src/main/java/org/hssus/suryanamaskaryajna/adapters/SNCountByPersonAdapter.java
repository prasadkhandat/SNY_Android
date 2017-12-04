package org.hssus.suryanamaskaryajna.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hssus.suryanamaskaryajna.BaseActivity;
import org.hssus.suryanamaskaryajna.R;
import org.hssus.suryanamaskaryajna.ReportSNCounts;
import org.hssus.suryanamaskaryajna.SNCountsPerPerson;

/**
 * Created by prasadkhandat on 10/11/17.
 */

public class SNCountByPersonAdapter  extends RecyclerView.Adapter<SNCountByPersonAdapter.ViewHolder> {
    private String[] mDataset;
    private Context context;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView p_name;

        public ViewHolder(View v) {
            super(v);
            p_name = (TextView) v.findViewById(R.id.txt_menu);
            p_name.setGravity(Gravity.LEFT);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public SNCountByPersonAdapter(String[] myDataset,Context context) {
        mDataset = myDataset;
        this.context=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SNCountByPersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_menu_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        SNCountByPersonAdapter.ViewHolder vh = new SNCountByPersonAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(SNCountByPersonAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.p_name.setText(mDataset[position]);

        if(position%2!=0)
            holder.p_name.setBackgroundColor(Color.rgb(211,211,211));
        else
            holder.p_name.setBackgroundColor(Color.rgb(255,255,255));

        holder.p_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent3=new Intent(context, ReportSNCounts.class);
                ((BaseActivity)context).startActivity(intent3, ActivityOptionsCompat.makeSceneTransitionAnimation((BaseActivity)context).toBundle());


            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}