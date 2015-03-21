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
    public enum Category
    {
        None,
        Eat,
        Sleep
    };
    public class Question
    {
        Question()
        {
            category = Category.None;
            string = "Question";
        }
        Question(Category c, String s)
        {
            category = c;
            string = s;
        }

        Category category;
        String string;
    };

    ///////////////////////////////////////////////////////////////////////////////////
    private Question[] question;

    ///////////////////////////////////////////////////////////////////////////////////
    private static QuestionData instance;
    public QuestionData GetInstance()
    {
        if (instance == null)
            instance = new QuestionData();

        return instance;
    }
    private QuestionData()
    {
        //질문 데이터 초기화
        question = new Question[1];

        question[0] = new Question(Category.Eat, "오늘은 무엇을 드셨나요?");
        question[1] = new Question(Category.Sleep, "오늘은 무엇을 드셨나요?");
        question[2] = new Question(Category.Eat, "오늘은 무엇을 드셨나요?");
        question[3] = new Question(Category.Eat, "오늘은 무엇을 드셨나요?");
    }

    ///////////////////////////////////////////////////////////////////////////////////
    public String GetRandomQuestion(Category c)
    {
        List<Integer> index_list = new ArrayList<Integer>();

        for(int i=0;i<question.length;++i)
        {
            if(question[i].category == c)
                index_list.add(i);
        }

        Random random = new Random();
        int index = random.nextInt(index_list.size());

        return question[index].string;
    }
}
