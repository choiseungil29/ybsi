package com.example.clogic.ybsi.Fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cengalabs.flatui.views.FlatEditText;
import com.example.clogic.ybsi.Data.Answer;
import com.example.clogic.ybsi.Data.AnswerData;
import com.example.clogic.ybsi.R;

import java.util.Date;

public class ContentAddFragment extends Fragment {

    private SharedPreferences pref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_content_add, container, false);

        FlatEditText et_content = (FlatEditText) v.findViewById(R.id.et_content);
        Answer answer = new Answer(new Date(System.currentTimeMillis()), "", "", et_content.getText().toString());
        AnswerData.getInstance().saveAnswer(answer);

        et_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                pref.edit().putString("content", charSequence.toString()).commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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
