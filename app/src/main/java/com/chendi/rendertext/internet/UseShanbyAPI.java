package com.chendi.rendertext.internet;

import com.chendi.rendertext.beans.TokenBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by PC on 2017/11/11.
 */

public interface UseShanbyAPI {

    @GET("authorize/")
    Call getCode(@Query("client_id")String client_id,
             @Query("response_type")String response_type,
             @Query("state") String state);

    @FormUrlEncoded
    @POST("token/")
    Call<TokenBean> getToken(@Field("client_id") String client_id,
                                 @Field("client_secret") String client_secret,
                                 @Field("grant_type") String grant_type,
                                 @Field("code") String code,
                                 @Field("redirect_uri") String redirect_uri);
}
