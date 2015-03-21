package com.example.clogic.ybsi.Fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cengalabs.flatui.views.FlatTextView;
import com.example.clogic.ybsi.Data.Answer;
import com.example.clogic.ybsi.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CLogic on 15. 3. 22..
 */
public class ContentViewFragment extends Fragment {

    private SharedPreferences pref;
    private Answer a;

    public ContentViewFragment() {

    }

    public ContentViewFragment(Answer a) {
        this.a = a;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_custom_view, container, false);

        DateFormat sdFormat = new SimpleDateFormat("yyyy년MM월dd일");
        Date nowDate = a.date;
        String tempDate = sdFormat.format(nowDate);

        FlatTextView tv_content = (FlatTextView) v.findViewById(R.id.tv_content);
        tv_content.setText(tempDate + "\n" + a.question + "\n" + a.answer);

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        pref = activity.getSharedPreferences("Stella", activity.MODE_PRIVATE);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
