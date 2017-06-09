package com.example.dell.base_adaptertt2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.base_adaptertt2.R;

import java.util.List;

/**
 * Created by dell on 2017-06-08.
 */

public class Custombaseadapter extends BaseAdapter {
    Context context;
    int layout;
    List<Album> albumss;

    public Custombaseadapter(Context context, int layout, List<Album> album) {
        this.context = context;
        this.layout = layout;
        this.albumss = album;

    }

    public static class ViewHolder {
        ImageView hinhalbum;
        TextView tenalbum, ngayphathanh;

    }

    @Override
    public int getCount() {
        return albumss.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View viewRow = convertView;
        if(viewRow == null){
            viewRow = inflater.inflate(layout,parent,false);

            ViewHolder holder = new ViewHolder();
            holder.hinhalbum = (ImageView) viewRow.findViewById(R.id.imgHinhAnh);
            holder.tenalbum = (TextView)viewRow.findViewById(R.id.tvTenAlbum);
            holder.ngayphathanh = (TextView)viewRow.findViewById(R.id.tvNgayphathanh);

            viewRow.setTag(holder);
        }

        ViewHolder viewHolder = (ViewHolder) viewRow.getTag();
        viewHolder.hinhalbum.setImageResource(albumss.get(position).getHinhAlbum());
        viewHolder.tenalbum.setText(albumss.get(position).getTenAlbum().toString());
        viewHolder.ngayphathanh.setText(albumss.get(position).getNgayPhatHanh().toString());


        return viewRow;




    }
}













