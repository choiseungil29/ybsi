package com.example.clogic.ybsi.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.clogic.ybsi.Data.Answer;
import com.example.clogic.ybsi.Data.AnswerData;
import com.example.clogic.ybsi.Data.PDFMaker;
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
        Answer a = new Answer(new Date(), QuestionData.getInstance().getRandomQuestion(), "으앙", "킄");
        Question q = a.getQuestion();
        //a.setId(1L);
        AnswerData.getInstance().saveAnswer(a);
        List<Answer> answer_list = AnswerData.getInstance().getAnswerList();

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(answer_list.get(0).answer);

        //pdf test
        try
        {
            PDFMaker.getInstance().exportAnswer(answer_list);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
