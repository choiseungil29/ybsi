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

        question[0] = new Question(Question.Category.Family, "가족과 먹고싶은 것이 있나요?");
        question[1] = new Question(Question.Category.Love, "연인과 가고싶은곳이 있나요?");
        question[2] = new Question(Question.Category.LeisureLife, "좋아하는 여가활동이 있나요?");
        question[3] = new Question(Question.Category.None, "뭐하고 있나요?");
        question[4] = new Question(Question.Category.LeisureLife, "주로 무슨 여가활동을 하나요?");
        question[5] = new Question(Question.Category.Family, "가족과 있을 때 주로 무었을 하나요?");
        question[6] = new Question(Question.Category.HolyDay, "생일때 뭔가 계획이 있나요?");
        question[7] = new Question(Question.Category.LeisureLife, "가고싶은 여행지가 있나요?");
        question[8] = new Question(Question.Category.Love, "연인과 먹고싶은 것이 있나요?");
        question[9] = new Question(Question.Category.Friends, "친구들과 여행을 간다면 어디를 갈건가요?");
        question[10] = new Question(Question.Category.HolyDay, "특별히 기대되는 명절이 있나요?");
        question[11] = new Question(Question.Category.HolyDay, "주말에 계획이 있나요?");
        question[12] = new Question(Question.Category.Friends, "생각나는 친구가 있나요?");
        question[13] = new Question(Question.Category.Friends, "친구들과 먹고싶은 음식이 있나요?");
        question[14] = new Question(Question.Category.LeisureLife, "좋아하는 게임이 있나요?");
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
    public String getRandomQuestion()    //임의의 질문을 리턴한다.
    {
        Random random = new Random();
        int index = random.nextInt(question.length);

        return question[index].string;
    }
    public Question[] getQuestionArray()
    {
        return question;
    }

    ///////////////////////////////////////////////////////////////////////////////////
}
