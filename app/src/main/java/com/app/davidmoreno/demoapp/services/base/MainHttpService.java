package com.app.davidmoreno.demoapp.services.base;

import com.app.davidmoreno.demoapp.domain.model.Image;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;


public interface MainHttpService {

    @GET("/photos")
    Observable<Response<List<Image>>> getImages();

}
