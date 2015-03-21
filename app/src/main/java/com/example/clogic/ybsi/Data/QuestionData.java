package com.example.clogic.ybsi.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by we13245 on 2015-03-21.
 * 질문에 관한 데이터가 들어있는 싱글톤 클래스
 */
public class QuestionData
{
    ///////////////////////////////////////////////////////////////////////////////////
    private Question[] question;

    ///////////////////////////////////////////////////////////////////////////////////
    private static QuestionData instance;
    public static QuestionData getInstance()
    {
        if (instance == null)
            instance = new QuestionData();

        return instance;
    }
    private QuestionData()
    {
        //질문 데이터 초기화
        question = new Question[4];

        question[0] = new Question(Question.Category.Eat, "오늘은 무엇을 드셨나요?");
        question[1] = new Question(Question.Category.Sleep, "오늘 하루, 특별한 일 있었나요?");
        question[2] = new Question(Question.Category.Wake, "무슨 꿈 꾸셨나요?");
        question[3] = new Question(Question.Category.None, "뭐하고 있나요?");
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public String getRandomQuestion(Question.Category c)    //카테고리에 따라 임의의 질문을 리턴한다.
    {
        List<Integer> index_list = new ArrayList<Integer>();

        for(int i=0;i<question.length;++i)
        {
            if(question[i].category == c)
                index_list.add(i);
        }

        Random random = new Random();
        int index = index_list.get(random.nextInt(index_list.size()));

        return question[index].string;
    }
    public Question[] getQuestionArray()
    {
        return question;
    }

    ///////////////////////////////////////////////////////////////////////////////////
}
