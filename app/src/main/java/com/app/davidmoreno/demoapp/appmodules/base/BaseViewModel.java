package com.app.davidmoreno.demoapp.appmodules.base;

import android.arch.lifecycle.ViewModel;
import android.content.SharedPreferences;

public class BaseViewModel extends ViewModel {
    protected final SharedPreferences mSharedPreferences;

    public BaseViewModel(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }
}
