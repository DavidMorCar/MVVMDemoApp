package com.app.davidmoreno.demoapp.services.image;

import com.app.davidmoreno.demoapp.domain.model.Image;

import java.util.List;

import io.reactivex.Observable;

public interface ImageSource {

    Observable<List<Image>> loadImages();

}
