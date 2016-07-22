package br.edu.ifpb.si.pdm.analitico.retrofit;

import br.edu.ifpb.si.pdm.analitico.jsonobjects.FaceObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by thor on 09/07/16.
 */
public interface ApiEndPointFDInterface {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("/detection/detect")
    Call<FaceObject> getImgInfo(@Query("attribute") String atribute, @Query("url") String url);

}