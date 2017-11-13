package com.chendi.rendertext.popwindow;

import android.app.Activity;
import android.graphics.Color;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.chendi.rendertext.R;

/**
 * Created by ChenDi on 2017/11/11.
 */

public class PopWindow {

    private LayoutInflater inflater;
    private View view;
    private PopupWindow mPopWindow;
    private TextView wordText;
    private TextView phoneticText;
    private TextView explanText;
    private ImageView popBtn;
    public PopWindow(Activity activity, final Spannable spannable,final int s,final int e)
    {
        inflater=LayoutInflater.from(activity);
        view=inflater.inflate(R.layout.pup_window,null);
        wordText=view.findViewById(R.id.words);
        phoneticText=view.findViewById(R.id.phonetic);
        explanText=view.findViewById(R.id.explanation);
        popBtn=view.findViewById(R.id.popBtn);
        popBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopWindow.dismiss();
                spannable.setSpan(new BackgroundColorSpan(Color.WHITE),s,e,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        });


    }

    /**
     * 设置PopWindow,这里可以添加更多的参数
     * @param
     */
    public void setPopWindow(View mView,String word)
    {
        mPopWindow=new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
        mPopWindow.setFocusable(false);
        mPopWindow.setOutsideTouchable(false);
//        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopWindow.showAtLocation(mView, Gravity.BOTTOM,0,0);
        wordText.setText(word);

    }


    /**W
     * 关闭popWindow
     */
    public void shutPop()
    {
        mPopWindow.dismiss();
    }

}
