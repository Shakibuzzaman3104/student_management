package com.techtrixbd.studentattendence.retrofit;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    static ApiInterface apiInterface;

    static {
        System.loadLibrary("native-lib");
    }

    public static native String getNativeKey();

    static String key2 = new String(Base64.decode(getNativeKey(), Base64.DEFAULT));

    private static final String BASE_URL = key2;


    public static synchronized ApiInterface getInstance()
    {
        if(retrofit==null)
        {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();


            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(2, TimeUnit.MINUTES)
                    .writeTimeout(2, TimeUnit.MINUTES).addInterceptor(chain -> {
                        Request original = chain.request();
                        Request.Builder requestBuilder = requestBuilder = original.newBuilder()
                                .method(original.method(), original.body());
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }).build();


            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            apiInterface = retrofit.create(ApiInterface.class);

        }

        return apiInterface;
    }


}
