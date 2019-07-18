package com.app.davidmoreno.demoapp.dependencyinjection.modules;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.davidmoreno.demoapp.services.base.MainHttpService;
import com.app.davidmoreno.demoapp.util.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ProvidesAppModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context application){
        return application.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    MainHttpService provideCloudFunctionService() {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MainHttpService.class);
    }
}
