package com.example.cookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    String [] recipeNames;
    int [] recipeImages;
    Context context;
    LayoutInflater inflater;

    CustomAdapter(Context context,String[] recipeNames,int [] recipeImages)
    {
        this.context = context;
        this.recipeNames = recipeNames;
        this.recipeImages = recipeImages;
    }
    @Override
    public int getCount() {
        return recipeImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.listview,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.tv_recipeName);
        imageView.setImageResource(recipeImages[position]);
        textView.setText(recipeNames[position]);


        return convertView;
    }
}
