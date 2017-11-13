package com.chendi.rendertext.readtxt;

import android.app.Activity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by PC on 2017/11/8.
 */

public class GetText {

    /**
     * 获取文档内容
     * @return 文档字符串
     */
    public static String getText(Activity activity)
    {
        InputStream inputStream;
        BufferedReader reader;
        StringBuffer sb=null;
        String line=null;
        try {
            inputStream= activity.getAssets().open("text.txt");
            reader=new BufferedReader(new InputStreamReader(inputStream,"gbk"));
            sb=new StringBuffer();

            while((line=reader.readLine())!=null)
            {
                if(line.equals("enter"))
                {
                    sb.append("\r\n");
                }
                else
                {
                    sb.append(line);
                }
            }
            line=sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return line;
    }
}
