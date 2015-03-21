package com.example.clogic.ybsi.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.cengalabs.flatui.views.FlatEditText;
import com.example.clogic.ybsi.Data.Answer;
import com.example.clogic.ybsi.Data.AnswerData;
import com.example.clogic.ybsi.Data.Question;
import com.example.clogic.ybsi.Data.QuestionData;
import com.example.clogic.ybsi.R;

import java.util.Date;

/**
 * Created by CLogic on 15. 3. 22..
 */
public class MessageDialog extends Dialog {

    private TextView tv_question;
    private Button btn_write;
    private FlatEditText et_content;

    private Context c;

    public MessageDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.dialog_message);

        this.c = c;

        tv_question = (TextView) findViewById(R.id.tv_question);
        tv_question.setText(QuestionData.getInstance().getRandomQuestion(Question.Category.Eat));

        et_content = (FlatEditText) findViewById(R.id.et_content);

        btn_write = (Button) findViewById(R.id.btn_write);
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_content.getText().toString().equals("")) {

                } else {
                    Answer answer = new Answer(new Date(System.currentTimeMillis()), tv_question.getText().toString(), "", et_content.getText().toString());
                    AnswerData.getInstance().saveAnswer(answer);
                    MessageDialog.this.dismiss();
                }
            }
        });
    }
}
