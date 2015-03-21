package com.example.clogic.ybsi.Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.clogic.ybsi.Data.Answer;
import com.example.clogic.ybsi.Data.AnswerData;
import com.example.clogic.ybsi.Data.Question;
import com.example.clogic.ybsi.Data.QuestionData;
import com.example.clogic.ybsi.R;

import java.util.Date;
import java.util.List;

public class TestActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //answer Test
        Answer a = new Answer(new Date(), "asdf", "fdas", "qwads");
        //a.setId(1L);
        AnswerData.getInstance().saveAnswer(a);
        List<Answer> answer_list = AnswerData.getInstance().getAnswerListByQuestionString("asdf");

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(answer_list.get(0).answer);

        //Question Test
        String new_string = QuestionData.getInstance().getRandomQuestion(Question.Category.Eat);

        TextView tv_title = (TextView)this.findViewById(R.id.tv_title);
        tv_title.setText(new_string);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
