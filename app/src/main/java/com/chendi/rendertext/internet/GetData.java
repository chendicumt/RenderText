package com.chendi.rendertext.internet;

import com.chendi.rendertext.beans.TokenBean;
import com.chendi.rendertext.utils.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by PC on 2017/11/12.
 */

public class GetData {

    private TokenBean tokenBean;

    public TokenBean getTokenData()
    {

        UseShanby.getIntance().getTokenCall().enqueue(new Callback<TokenBean>() {
            @Override
            public void onResponse(Call<TokenBean> call, Response<TokenBean> response) {
                Logger.d("--->",response.code()+"");
                if(response.isSuccessful())
                {
                    tokenBean =response.body();
                    Logger.d("--->", tokenBean.getAccess_token());
                }
            }

            @Override
            public void onFailure(Call<TokenBean> call, Throwable t) {


            }
        });

        return tokenBean;
    }
}
