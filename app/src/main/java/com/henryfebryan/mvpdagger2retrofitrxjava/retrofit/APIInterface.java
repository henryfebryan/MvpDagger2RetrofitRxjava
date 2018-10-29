package com.henryfebryan.mvpdagger2retrofitrxjava.retrofit;

import com.henryfebryan.mvpdagger2retrofitrxjava.pojo.CryptoData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {
    @GET("ticker/?")
    Observable<List<CryptoData>> getData(@Query("limit") String limit);
}
