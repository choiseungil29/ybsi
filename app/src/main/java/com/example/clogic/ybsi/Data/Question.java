package com.example.clogic.ybsi.Data;

/**
 * Created by we13245 on 2015-03-21.
 * 질문에 관한 데이터의 한 조각
 */
public class Question
{
    ///////////////////////////////////////////////////////////////////////////////////
    public enum Category
    {
        None,   //아무때나 뜨는것(아래것들 뜰때 말고 수시로 그냥 뜨는 그런거)
        Eat,    //밥먹을 시간 쯤에 뜨는것
        Sleep,  //자기 전에 뜨는것
        Wake    //일어날 때 뜨는것
    };

    ///////////////////////////////////////////////////////////////////////////////////
    public Category category;   //카테고리
    public String string;       //질문

    ///////////////////////////////////////////////////////////////////////////////////
    Question(Category category, String string)
    {
        this.category = category;
        this.string = string;
    }

    ///////////////////////////////////////////////////////////////////////////////////
}
