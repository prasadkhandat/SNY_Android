package org.hssus.suryanamaskaryajna.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.hssus.suryanamaskaryajna.BaseActivity;
import org.hssus.suryanamaskaryajna.LoginActivity;
import org.hssus.suryanamaskaryajna.MainActivity;
import org.hssus.suryanamaskaryajna.R;
import org.hssus.suryanamaskaryajna.Registration;
import org.hssus.suryanamaskaryajna.SNCountsPerPerson;
import org.hssus.suryanamaskaryajna.SNMantras;
import org.hssus.suryanamaskaryajna.SNYAudioPlay;
import org.hssus.suryanamaskaryajna.SuryaNamaskarHelp;

/**
 * Created by prasadkhandat on 10/9/17.
 */

public class MainMenusAdapter  extends RecyclerView.Adapter<MainMenusAdapter.ViewHolder> {
    private String[] mDataset;

    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.txt_menu);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MainMenusAdapter(String[] myDataset,Context context) {
        mDataset = myDataset;

        this.context=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainMenusAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_menu_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset[position]);
        if(position%2==0)
            holder.mTextView.setBackgroundColor(Color.rgb(211,211,211));
        else
            holder.mTextView.setBackgroundColor(Color.rgb(255,255,255));

        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performClickOperation(((TextView)view).getText().toString());
            }
        });

        //Log.d("Adapter", "onBindViewHolder: "+mDataset[position]);

    }

    private void performClickOperation(String menu) {

        switch (menu.toString().toLowerCase()) {
            case "do surya namaskars":
                Intent intent=new Intent(context, SuryaNamaskarHelp.class);
                ((BaseActivity)context).startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation((BaseActivity)context).toBundle());
                break;
            case "surya namaskar mantra meaning":
                Intent intent1=new Intent(context, SNMantras.class);
                ((BaseActivity)context).startActivity(intent1, ActivityOptionsCompat.makeSceneTransitionAnimation((BaseActivity)context).toBundle());
                break;
            case "surya namaskar audio":
                Intent intent2=new Intent(context, SNYAudioPlay.class);
                ((BaseActivity)context).startActivity(intent2, ActivityOptionsCompat.makeSceneTransitionAnimation((BaseActivity)context).toBundle());
                break;
            case "more information":
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hssus.org/SNY"));
                ((BaseActivity)context).startActivity(browserIntent);
                break;
            case "reports and tools":
                Intent browserIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.snyapp.com/sny"));
                ((BaseActivity)context).startActivity(browserIntent1);
                break;
            case "need help?":
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://hssapps.wordpress.com/"));
                ((BaseActivity)context).startActivity(browserIntent2);
                break;
            case "add family member":
                Intent i =new Intent(context,Registration.class);
                Bundle b = new Bundle();
                b.putString("starting_location", "add family member"); //Your id
                i.putExtras(b); //Put your id to your next Intent
                ((BaseActivity)context).startActivity(i, ActivityOptionsCompat.makeSceneTransitionAnimation((BaseActivity)context).toBundle());
                break;
            case "add surya namaskar counts":
                Intent intent3=new Intent(context, SNCountsPerPerson.class);
                ((BaseActivity)context).startActivity(intent3, ActivityOptionsCompat.makeSceneTransitionAnimation((BaseActivity)context).toBundle());
                break;

            default:
                ((BaseActivity)context).displayToastMessage(menu+" not implemented yet");
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}