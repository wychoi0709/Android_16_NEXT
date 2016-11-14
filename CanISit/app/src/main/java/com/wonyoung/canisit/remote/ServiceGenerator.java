package com.wonyoung.canisit.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.wonyoung.canisit.BuildConfig;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by WonYoung on 16. 9. 3..
 */
public class ServiceGenerator {

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        RestAdapter.LogLevel logLevel;
        if (BuildConfig.DEBUG) {
            logLevel = RestAdapter.LogLevel.FULL;
        } else {
            logLevel = RestAdapter.LogLevel.NONE;
        }

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setLogLevel(logLevel)
                .setEndpoint(baseUrl)
                .setConverter(new GsonConverter(gson))
                //.setConverter(new LenientGsonConverter(gson))
                .setClient(new OkClient(new OkHttpClient()));

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }

}
