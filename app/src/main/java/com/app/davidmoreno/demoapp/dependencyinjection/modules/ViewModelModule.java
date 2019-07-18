package com.app.davidmoreno.demoapp.dependencyinjection.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.app.davidmoreno.demoapp.appmodules.base.ViewModelFactory;
import com.app.davidmoreno.demoapp.appmodules.main.viewmodel.MainViewModel;
import com.app.davidmoreno.demoapp.dependencyinjection.PerActivity;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module(includes = { ProvidesSourceModule.class })
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel mainViewModel(MainViewModel mainViewModel);

    @Binds
    @PerActivity
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
