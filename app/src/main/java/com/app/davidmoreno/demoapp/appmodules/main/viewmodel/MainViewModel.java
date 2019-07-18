package com.app.davidmoreno.demoapp.appmodules.main.viewmodel;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.app.davidmoreno.demoapp.domain.model.Image;
import com.app.davidmoreno.demoapp.domain.usecase.GetImagesUseCase;
import com.app.davidmoreno.demoapp.util.Params;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class MainViewModel extends ViewModel implements LifecycleObserver {
    private MutableLiveData<List<Image>> value;
    private GetImagesUseCase getImagesUseCase;

    @Inject
    public MainViewModel(GetImagesUseCase getImagesUseCase) {
        value = new MutableLiveData<>();
        this.getImagesUseCase = getImagesUseCase;
    }

    public MutableLiveData<List<Image>> getImages() {
        return value;
    }

    public void loadImages() {
        Params params = Params.create();
        getImagesUseCase.execute(new LoadImagesObserver(), params);
    }

    private final class LoadImagesObserver extends DisposableObserver<List<Image>> {

        @Override
        public void onNext(List<Image> images) {
            if (images == null) {
                value.postValue(null);
            } else {
                value.postValue(images);
            }
            onComplete();
        }

        @Override
        public void onError(Throwable e) {
            value.postValue(null);
            onComplete();
        }

        @Override
        public void onComplete() {
        }
    }
}