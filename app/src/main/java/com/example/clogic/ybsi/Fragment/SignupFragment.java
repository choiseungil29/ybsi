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
import android.widget.CompoundButton;

import com.cengalabs.flatui.views.FlatEditText;
import com.cengalabs.flatui.views.FlatToggleButton;
import com.example.clogic.ybsi.R;

/**
 * Created by CLogic on 15. 3. 22..
 */
public class SignupFragment extends Fragment {

    private SharedPreferences pref;

    private FlatEditText et_email;
    private FlatEditText et_pw;
    private FlatEditText et_name;

    private FlatToggleButton tb_sex;

    private FlatEditText et_birth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_signup, container, false);

        et_email = (FlatEditText) v.findViewById(R.id.et_email);
        et_pw = (FlatEditText) v.findViewById(R.id.et_pw);
        et_name = (FlatEditText) v.findViewById(R.id.et_name);

        tb_sex = (FlatToggleButton) v.findViewById(R.id.tb_sex);

        et_birth = (FlatEditText) v.findViewById(R.id.et_birth);

        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                pref.edit().putString("email", charSequence.toString()).commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                pref.edit().putString("pw", charSequence.toString()).commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                pref.edit().putString("name", charSequence.toString()).commit();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        tb_sex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                pref.edit().putBoolean("sex", b).commit();
            }
        });

        et_birth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                pref.edit().putString("birth", charSequence.toString()).commit();
                pref.edit().putBoolean("signup", true).commit();
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
