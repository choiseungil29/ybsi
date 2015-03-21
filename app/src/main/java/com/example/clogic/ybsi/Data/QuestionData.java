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
        question = new Question[32];

        question[0] = new Question(Question.Category.Family, "오늘 가족과 무엇을 먹었나요?");
        question[1] = new Question(Question.Category.Love, "오늘 사랑하는 사람과 한 일이 있나요?");
        question[2] = new Question(Question.Category.Family, "오늘 가족간에 불화가 있었나요?");
        question[3] = new Question(Question.Category.None, "뭐하고 있나요?");
        question[4] = new Question(Question.Category.LeisureLife, "오늘은 쉬는 시간에 무었을 했나요?");
        question[5] = new Question(Question.Category.Family, "오늘 가족중 누구와 가장 오래 있었나요?");
        question[6] = new Question(Question.Category.HolyDay, "오늘 잘 놀았나요?");
        question[7] = new Question(Question.Category.LeisureLife, "가고싶은 여행지가 있나요?");
        question[8] = new Question(Question.Category.Love, "오늘은 사랑하는 사람과 만났나요?");
        question[9] = new Question(Question.Category.Friends, "오늘은 어떤 친구와 만났나요?");
        question[10] = new Question(Question.Category.HolyDay, "오늘은 뭔가 선물받은게 있나요?");
        question[11] = new Question(Question.Category.HolyDay, "오늘은 뭔가 선물한게 있나요?");
        question[12] = new Question(Question.Category.Friends, "오늘 친구들과 싸우지는 않았나요?");
        question[13] = new Question(Question.Category.Friends, "친구들과 먹은 음식이 있나요?");
        question[14] = new Question(Question.Category.LeisureLife, "오늘 재미있게 한 게임이 있나요?");
        question[15] = new Question(Question.Category.Family, "지금 가족을 떠올리면 누가 가장먼저 생각나나요?");
        question[16] = new Question(Question.Category.Love, "사랑하는 사람과의 추억중 생각나는게 있나요?");
        question[17] = new Question(Question.Category.LeisureLife, "지금 외국에 여행갈 수 있다면 가고싶은 곳이 있나요?");
        question[18] = new Question(Question.Category.Friends, "지금 생각나는 친구가 있나요?");
        question[19] = new Question(Question.Category.Family, "오늘 가족때매 속상한일이 있었나요?");
        question[20] = new Question(Question.Category.Family, "오늘 가족덕에 즐거운 일이 있었나요?");
        question[21] = new Question(Question.Category.Friends, "오늘 친구때매 속상한 일이 있었나요?");
        question[22] = new Question(Question.Category.LeisureLife, "오늘 재미있게 본 애니메이션이 있나요?");
        question[23] = new Question(Question.Category.LeisureLife, "오늘 재미있게 본 만화가 있나요?");
        question[24] = new Question(Question.Category.LeisureLife, "오늘 재미있게 본 영화가 있나요?");
        question[25] = new Question(Question.Category.Friends, "오늘 친구덕에 즐거운 일이 있었나요?");
        question[26] = new Question(Question.Category.Love, "오늘 사랑하는 사람과 불화가 있었나요?");
        question[27] = new Question(Question.Category.Friends, "오늘 생일인 친구가 있나요?");
        question[28] = new Question(Question.Category.Love, "오늘 사랑하는 사람덕에 즐거운 일이 있었나요?");
        question[29] = new Question(Question.Category.LeisureLife, "오늘 즐거웠나요?");
        question[30] = new Question(Question.Category.LeisureLife, "오늘 하고싶었는데 못한 일이 있나요?");
        question[31] = new Question(Question.Category.LeisureLife, "평소 하고싶다 오늘 해서 기쁜 일은 없나요?");
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
