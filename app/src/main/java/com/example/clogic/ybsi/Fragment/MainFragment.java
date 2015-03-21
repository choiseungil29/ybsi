package com.example.clogic.ybsi.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.clogic.ybsi.Activity.ParentActivity;
import com.example.clogic.ybsi.Adapter.CustomAdapter;
import com.example.clogic.ybsi.Data.Answer;
import com.example.clogic.ybsi.Data.AnswerData;
import com.example.clogic.ybsi.R;

import java.util.ArrayList;

/**
 * Created by CLogic on 15. 3. 21..
 */
public class MainFragment extends Fragment {

    private ListView lv_contents;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);

        lv_contents = (ListView) v.findViewById(R.id.lv_contents);

        final ArrayList<Answer> answers = new ArrayList<>();
        for (Answer answer : AnswerData.getInstance().getAnswerList()) {
            answers.add(answer);
        }

        final CustomAdapter adapter = new CustomAdapter(getActivity(), R.layout.item, answers);
        lv_contents.setAdapter(adapter);
        lv_contents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ((ParentActivity)getActivity()).changeFragment(new ContentViewFragment(adapter.getItem(position)));
            }
        });

        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
