package com.app.davidmoreno.demoapp.dependencyinjection.modules;

import android.support.v7.app.AppCompatActivity;

import com.app.davidmoreno.demoapp.appmodules.main.view.MainActivity;
import com.app.davidmoreno.demoapp.dependencyinjection.PerActivity;

import dagger.Binds;
import dagger.Module;


@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {
    @Binds
    @PerActivity
    abstract AppCompatActivity activity(MainActivity mainActivity);
}