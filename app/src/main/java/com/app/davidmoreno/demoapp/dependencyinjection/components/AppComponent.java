package com.app.davidmoreno.demoapp.dependencyinjection.components;

import com.app.davidmoreno.demoapp.appmodules.app.DemoApp;
import com.app.davidmoreno.demoapp.dependencyinjection.modules.AppModule;
import com.app.davidmoreno.demoapp.dependencyinjection.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules =  AppModule.class)
interface AppComponent extends AndroidInjector<DemoApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<DemoApp> {
    }
}
