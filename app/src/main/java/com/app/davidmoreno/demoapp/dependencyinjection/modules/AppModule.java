package com.app.davidmoreno.demoapp.dependencyinjection.modules;

import android.app.Application;
import android.content.Context;

import com.app.davidmoreno.demoapp.appmodules.app.DemoApp;
import com.app.davidmoreno.demoapp.appmodules.main.view.MainActivity;
import com.app.davidmoreno.demoapp.dependencyinjection.PerActivity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = { AndroidSupportInjectionModule.class, ProvidesAppModule.class})
public abstract class AppModule {

    @Binds
    @Singleton
    abstract Application application(DemoApp app);

    @Binds
    @Singleton
    abstract Context appContext(DemoApp app);

    @PerActivity
    @ContributesAndroidInjector(modules = { MainActivityModule.class, ViewModelModule.class })
    abstract MainActivity mainActivityInjector();

}