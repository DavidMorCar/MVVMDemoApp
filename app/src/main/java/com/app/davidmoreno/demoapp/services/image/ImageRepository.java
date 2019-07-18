package com.app.davidmoreno.demoapp.services.image;

import com.app.davidmoreno.demoapp.domain.model.Image;
import com.app.davidmoreno.demoapp.services.image.source.ImageDataSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ImageRepository implements ImageSource {

    private final ImageDataSource imageDataSource;

    @Inject
    public ImageRepository(ImageDataSource imageDataSource) {
        this.imageDataSource = imageDataSource;
    }

    @Override
    public Observable<List<Image>> loadImages(){
        return imageDataSource.loadImages();
    }

}