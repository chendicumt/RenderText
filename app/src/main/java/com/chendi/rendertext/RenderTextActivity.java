package com.chendi.rendertext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.widget.TextView;

import com.chendi.rendertext.readtxt.GetText;
import com.chendi.rendertext.rendertext.RenderText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RenderTextActivity extends AppCompatActivity {

    @BindView(R.id.text_content)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_render_text);
        ButterKnife.bind(this);
        textView.setText(GetText.getText(this), TextView.BufferType.SPANNABLE);
        RenderText.getEachWord(textView,this);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }


}
