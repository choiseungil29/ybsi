package com.example.clogic.ybsi.Data;

import com.orm.query.Select;

import java.util.List;

/**
 * Created by we13245 on 2015-03-21.
 * 대답에 관한 데이터를 얻어올 수 있는 싱글톤 클래스
 */
public class AnswerData
{
    ///////////////////////////////////////////////////////////////////////////////////
    private static AnswerData instance;
    public static AnswerData getInstance()
    {
        if (instance == null)
            instance = new AnswerData();

        return instance;
    }
    private AnswerData()
    {
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public List<Answer> getAnswerList()     //저장되어 있는 대답을 전부 불러온다.
    {
        return Select.from(Answer.class).orderBy("title").list();
    }
    public void addAnswer(Answer answer)
    {
        answer.save();
    }
}
