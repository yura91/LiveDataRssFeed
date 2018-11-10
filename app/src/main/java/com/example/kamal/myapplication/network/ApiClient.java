package com.example.kamal.myapplication.network;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;



public class ApiClient {

    public static final String URL_BASE= "https://habrahabr.ru/rss/";

    private static Retrofit retrofit;

    public static Retrofit getData() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(URL_BASE);
            httpClient.addInterceptor(logging);
            builder.client(httpClient.build());
            retrofit = builder
                    .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                    .client(httpClient.build())
                    .build();

        return retrofit;
    }
}
