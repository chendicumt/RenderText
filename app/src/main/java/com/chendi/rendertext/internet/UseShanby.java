package com.chendi.rendertext.internet;

import com.chendi.rendertext.beans.TokenBean;

import retrofit2.Call;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by PC on 2017/11/11.
 */

public class UseShanby {

    private static UseShanby useShanby;
    public static final String baseUrl="https://api.shanbay.com/oauth2/";
    public static final String appKey="e8caaa87f103a880213f";
    public static final String appSecret="a0fd9d0edc5841b68489ee9b79f8d64456a17aa5";
    public static final String appCode="z9WelxeJlHRAU6f4dchVP4jJlQPIER";
    public static final String callBackUrl="http://www.chendicumt.com/";
    public static final String grantType="authorization_code";
    public Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    UseShanbyAPI use=retrofit.create(UseShanbyAPI.class);

    Call<TokenBean> call=use.getToken(appKey,appSecret,grantType,appCode,callBackUrl);


//    Call callAu=use.getCode(appKey,"code","123");

    public Call getCallAu() {
        return use.getCode(appKey,"code","123");
    }


    public Call<TokenBean> getTokenCall() {
        Call<TokenBean> call1=call.clone();
        return call1;
    }

    public static UseShanby getIntance()
    {
        if(useShanby==null)
        {
            useShanby=new UseShanby();
        }
        return useShanby;
    }
}
