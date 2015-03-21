package com.example.clogic.ybsi.Data;

import android.text.style.TtsSpan;

import com.orm.SugarRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by we13245 on 2015-03-21.
 * 대답에 관한 데이터의 한 조각
 */
public class Answer extends SugarRecord<Answer>
{
    ///////////////////////////////////////////////////////////////////////////////////
    public Date date;
    public String question;

    public String picture_path;
    public String answer;

    ///////////////////////////////////////////////////////////////////////////////////
    public Answer() {

    }

    public Answer(Date date, String question, String picture_path, String answer)
    {
        this.date = date;
        this.question = question;
        this.picture_path = picture_path;
        this.answer = answer;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public Question getQuestion()
    {
        Question[] q = QuestionData.getInstance().getQuestionArray();

        for(int i=0;i<q.length;++i)
        {
            if(question.equals(q[i].string) == true)
                return q[i];
        }

        return null;
    }
}
