package com.john.androidfontsizer;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
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
    private Activity ctx;
    private int startPoint;
    private int endPoint;

    public ListViewAdapter(Activity ctx, ArrayList<String> items, int startPt, int endPt) {
        //super(context, items);
        this.inflater = LayoutInflater.from(ctx);
        this.ctx = ctx;
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
        //Log.i("TEST", "Size=" + listOfChars.size());
        return listOfChars.size();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // initialize view

        convertView = inflater.inflate(R.layout.top_bottom, null);
        holder = new ViewHolder();
        holder.tvLargeReg = (TextView) convertView.findViewById(R.id.textViewLargeReg);
        holder.tvLargeLight = (TextView) convertView.findViewById(R.id.textViewLargeLight);
        holder.tvLargeCondensed = (TextView) convertView.findViewById(R.id.textViewLargeCondensed);
        holder.tvSmall = (TextView) convertView.findViewById(R.id.textViewSmall);

        // set text
        String title = listOfChars.get(position);
        holder.tvLargeReg.setText("Roboto Regular: " + listOfChars.get(position));
        holder.tvLargeReg.setTextSize(position + 8);
        holder.tvLargeLight.setText("Roboto Light: " + listOfChars.get(position));
        holder.tvLargeLight.setTextSize(position + 8);
        holder.tvLargeCondensed.setText("Roboto Condensed: " + listOfChars.get(position));
        holder.tvLargeCondensed.setTextSize(position + 8);
        holder.tvSmall.setText((position + 8) + " sp");
        holder.tvSmall.setTextSize(12);

        return convertView;
    }

    private static class ViewHolder {
        TextView tvLargeReg;
        TextView tvLargeLight;
        TextView tvLargeCondensed;
        TextView tvSmall;
    }

}
