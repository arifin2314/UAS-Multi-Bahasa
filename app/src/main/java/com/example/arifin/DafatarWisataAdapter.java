package com.example.arifin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arifin.model.wisata;

import java.util.List;

public class DafatarWisataAdapter extends ArrayAdapter<wisata> {
    Context context;

    public DafatarWisataAdapter(Context context, List<wisata> wisatas) {
        super(context, R.layout.row_daftra_wisata, wisatas);
        this.context = context;
    }

    private static class ViewHolder  {
        TextView textJenis;
        TextView textAsal;
        ImageView gambar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        wisata wisata = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_daftra_wisata, parent, false);
            viewHolder.textJenis =  convertView.findViewById(R.id.row_text_jenis);
            viewHolder.textAsal = (TextView) convertView.findViewById(R.id.row_text_asal);
            viewHolder.gambar = convertView.findViewById(R.id.row_image_wisata);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textJenis.setText(wisata.getNama_wisata());
        viewHolder.textAsal.setText(wisata.getLokasi());
        viewHolder.gambar.setImageDrawable(context.getDrawable(wisata.getPoto()));
        return convertView;
    }

}
