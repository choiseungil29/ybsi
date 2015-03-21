package com.example.clogic.ybsi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clogic.ybsi.Data.Answer;
import com.example.clogic.ybsi.R;
import com.example.clogic.ybsi.Util.Birth;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by CLogic on 15. 3. 22..
 */
public class CustomAdapter extends ArrayAdapter<Answer> {

    private ArrayList<Answer> items;

    private LayoutInflater li;

    public CustomAdapter(Context context, int resource, List<Answer> item) {
        super(context, resource, item);

        li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        items = new ArrayList<>(item);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = li.inflate(R.layout.item, parent, false);
        }

        Answer p = getItem(position);

        TextView tv_day = (TextView) view.findViewById(R.id.day);
        TextView tv_description = (TextView) view.findViewById(R.id.description);

        ImageView iv_stella = (ImageView) view.findViewById(R.id.iv_stella);
        iv_stella.setImageDrawable(new Birth(getContext()).getDrawableAtDay(p.date));

        DateFormat sdFormat = new SimpleDateFormat("yyyy년MM월dd일");
        Date nowDate = p.date;
        String tempDate = sdFormat.format(nowDate);

        tv_day.setText(tempDate);
        tv_description.setText(p.answer);

        return view;
    }
}
