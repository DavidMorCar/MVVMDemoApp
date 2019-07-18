package com.app.davidmoreno.demoapp.services.image.source;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.app.davidmoreno.demoapp.domain.model.Image;
import com.app.davidmoreno.demoapp.services.base.MainHttpService;
import com.app.davidmoreno.demoapp.services.base.source.BaseDataSource;
import com.app.davidmoreno.demoapp.services.image.ImageSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ImageDataSource extends BaseDataSource implements ImageSource {

    Context context;
    MainHttpService mainHttpService;

    @Inject
    public ImageDataSource(Context context, SharedPreferences sharedPreferences, MainHttpService mainHttpService) {
        super(context, sharedPreferences, mainHttpService);
        this.context = context;
        this.mainHttpService = mainHttpService;
    }

    @Override
    public Observable<List<Image>> loadImages(){
        if (!haveAnInternetConnection())
            return null;

        return mainHttpService.getImages().map(response ->{
            Log.e("/////",response.message());
            if(response.isSuccessful())
                return response.body();
            else return null;
        });
    }

}
