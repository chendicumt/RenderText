package com.chendi.rendertext.rendertext;

import android.app.Activity;
import android.graphics.Color;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.chendi.rendertext.popwindow.PopWindow;
import com.chendi.rendertext.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2017/11/8.
 */

public class RenderText {

    private static Spannable spannable;
    private static PopWindow popWindow;
    private static TextView textView;
    private static String word;

    private static int s=0,e=0;


    /**
     * 获取每一个单词
     * @param textView
     */
    public static void getEachWord(TextView textView,Activity activity)
    {
        spannable=(Spannable)textView.getText();
        Integer[] index=getIndex(textView.getText().toString().trim()+" ",' ');
        int start=0;
        int end=0;
        for (int i=0;i<index.length;i++) {
            end=(i<index.length?index[i]:spannable.length());
            ClickableSpan clickableSpan=getClickSpan(start,end,activity);
            spannable.setSpan(clickableSpan,start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            start=end+1;
        }

    }

    /**
     * 为单词添加事件
     * @return clickableSpan
     */
    public static ClickableSpan getClickSpan(final int start, final int end,final Activity activity)
    {

        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                textView=(TextView)widget;
                word=textView.getText().subSequence(textView.getSelectionStart(),textView.getSelectionEnd()).toString();
                Logger.d("----",word);
                spannable.setSpan(new BackgroundColorSpan(Color.GREEN),start,end,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                if(popWindow!=null) {
                    popWindow.shutPop();
                    if (s != start && e != end) {
                        spannable.setSpan(new BackgroundColorSpan(Color.WHITE), s, e, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
                s=start;
                e=end;
                popWindow=new PopWindow(activity,spannable,s,e);
                popWindow.setPopWindow(widget,word);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(Color.BLACK);
                ds.setUnderlineText(false);
            }
        };
        return clickableSpan;
    }

    /**
     * 获取空格位置集合
     * @param text
     * @param c
     * @return Integer数组
     */
    public static Integer[] getIndex(String text,char c)
    {
        int position=text.indexOf(c,0);
        List<Integer> list=new ArrayList<>();
        while(position!=-1)
        {
            list.add(position);
            position=text.indexOf(c,position+1);
        }
        return list.toArray(new Integer[0]);
    }
}
