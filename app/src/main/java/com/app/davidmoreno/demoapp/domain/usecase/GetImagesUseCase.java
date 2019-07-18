package com.app.davidmoreno.demoapp.domain.usecase;

import com.app.davidmoreno.demoapp.appmodules.base.BaseUseCase;
import com.app.davidmoreno.demoapp.services.image.ImageRepository;
import com.app.davidmoreno.demoapp.util.Params;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetImagesUseCase extends BaseUseCase {
    private final ImageRepository imageRepository;

    @Inject
    public GetImagesUseCase(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    protected Observable getObservable(Params params) {
        return imageRepository.loadImages();
    }
}
