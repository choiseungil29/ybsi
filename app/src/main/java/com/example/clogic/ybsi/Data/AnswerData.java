package com.example.clogic.ybsi.Data;

import com.orm.query.Select;

import java.util.ArrayList;
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
        return Select.from(Answer.class).list();
    }
    public List<Answer> getAnswerListByQuestionString(String question_string)   //질문에 따라 대답을 불러온다.
    {
        List<Answer> answer_list = getAnswerList();
        List<Answer> return_list = new ArrayList<Answer>();

        for(int i=0;i<answer_list.size();++i)
        {
            if(answer_list.get(i).question.equals(question_string) == true)
                return_list.add(answer_list.get(i));
        }

        return return_list;
    }
    public List<Answer> getAnswerListByQuestion(Question question)  //질문에 따라 대답을 불러온다
    {
        return getAnswerListByQuestionString(question.string);
    }
    public void saveAnswer(Answer answer)   //대답을 저장한다.
    {
        answer.save();
    }
}
