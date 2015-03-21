package com.example.clogic.ybsi.Data;

import com.orm.SugarRecord;

/**
 * Created by we13245 on 2015-03-21.
 * 대답에 관한 데이터의 한 조각
 */
public class Answer extends SugarRecord<Answer>
{
    ///////////////////////////////////////////////////////////////////////////////////
    public String question;

    public String picture_path;
    public String answer;

    ///////////////////////////////////////////////////////////////////////////////////\

    public Answer() {

    }

    public Answer(String question, String picture_path, String answer)
    {
        this.question = question;
        this.picture_path = picture_path;
        this.answer = answer;
    }

    ///////////////////////////////////////////////////////////////////////////////////
}
