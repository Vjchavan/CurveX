package com.example.curvex;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class w_list_Adapter extends ArrayAdapter {

    private Activity mContext;
    List<w_class> hlist;

    public w_list_Adapter(Activity mContext, List<w_class> hlist){
        super(mContext,R.layout.list_item,hlist);
        this.mContext= mContext;
        this.hlist = hlist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item,null,true);
        TextView iname = listItemView.findViewById(R.id.in);
        TextView c1name = listItemView.findViewById(R.id.c1);
        TextView c2name = listItemView.findViewById(R.id.c2);
        TextView rname = listItemView.findViewById(R.id.res);

        w_class cinfo = hlist.get(position);

        iname.setText(cinfo.getInput());
        c1name.setText(cinfo.getConvert());
        c2name.setText(cinfo.getTo());
        rname.setText(cinfo.getResult());

        return listItemView;

    }
}
