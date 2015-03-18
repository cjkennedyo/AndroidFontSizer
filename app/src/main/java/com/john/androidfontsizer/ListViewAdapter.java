package com.john.androidfontsizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by john on 3/18/15.
 */
public class ListViewAdapter extends BaseAdapter {

    private ArrayList<String> listOfChars;
    private LayoutInflater inflater;
    private Context ctx;
    private int startPoint;
    private int endPoint;

    public ListViewAdapter(Context context, ArrayList<String> items, int startPt, int endPt) {
        //super(context, items);
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = context;
        this.listOfChars = items;
        this.startPoint = startPt;
        this.endPoint = endPt;
    }

    public ArrayList<String> getDataSource() {
        return listOfChars;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listOfChars.get(position);
    }

    @Override
    public int getCount() {
        return listOfChars.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // initialize view
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.top_bottom, null);
            holder = new ViewHolder();
            holder.tvLarge = (TextView) convertView.findViewById(R.id.textViewLarge);
            holder.tvSmall = (TextView) convertView.findViewById(R.id.textViewSmall);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // set text
        String title = listOfChars.get(position);
        holder.tvLarge.setText(title);

        // set point
        //holder.tvLarge.setTextSize(startPoint % 2);
        //(startPoint % 2);

        return convertView;
    }

    private static class ViewHolder {
        TextView tvLarge;
        TextView tvSmall;
    }

}
