package br.edu.ifpb.si.pdm.analitico.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.google.gson.GsonBuilder;

import java.io.IOException;

import br.edu.ifpb.si.pdm.analitico.jsonobjects.FaceObject;
import br.edu.ifpb.si.pdm.analitico.retrofit.ApiEndPointFDInterface;
import br.edu.ifpb.si.pdm.analitico.util.FormaterTextHelper;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by thor on 16/07/16.
 */
public class FaceDetectorService extends IntentService {

    public static final String BASE_URL = "https://faceplusplus-faceplusplus.p.mashape.com";
    private OkHttpClient.Builder builder;
    private Interceptor interceptor;
    private OkHttpClient client;
    private Retrofit retrofit;

    public FaceDetectorService(){
        super("FaceDetectorService");

        this.interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .addHeader("X-Mashape-Key", "GkMzsitLUZmshzztRJVduZu1aCvhp1XLTYmjsnY2juYT0H4sCD")
                        .addHeader("Accept", "application/json").build();
                return chain.proceed(newRequest);
            }
        };

        this.builder = new OkHttpClient.Builder();
        this.builder.interceptors().add(interceptor);

        this.client = builder.build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                        .create()))
                .client(client)
                .build();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        //Toast.makeText(this, "service stoping", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
        String atribute = "glass,pose,gender,age,race,smiling";
        String urlimg = intent.getStringExtra("URL");

        ApiEndPointFDInterface apiService = this.retrofit.create(ApiEndPointFDInterface.class);
        Call<FaceObject> call = apiService.getImgInfo(atribute,urlimg);
        call.enqueue(new Callback<FaceObject>() {
            @Override
            public void onResponse(Call<FaceObject> call, Response<FaceObject> response) {
                int statusCode = response.code();
                if(statusCode == 200){

                    FaceObject faceObject = response.body();

                    Long age_value = faceObject.getFace().get(0).getAttribute().getAge().getValue();
                    Long age_range = faceObject.getFace().get(0).getAttribute().getAge().getRange();

                    String gender_value =  faceObject.getFace().get(0).getAttribute().getGender().getValue();
                    Double gender_confidence =  faceObject.getFace().get(0).getAttribute().getGender().getConfidence();

                    String glass_value = faceObject.getFace().get(0).getAttribute().getGlass().getValue();
                    Double glass_confidence = faceObject.getFace().get(0).getAttribute().getGlass().getConfidence();

                    String race_value = faceObject.getFace().get(0).getAttribute().getRace().getValue();
                    Double race_confidence = faceObject.getFace().get(0).getAttribute().getRace().getConfidence();

                    Double smiling_value = faceObject.getFace().get(0).getAttribute().getSmiling().getValue();

                    Intent intent = new Intent("FaceDetectorService");
                    intent.putExtra("age_value",age_value);
                    intent.putExtra("age_range",age_range);
                    intent.putExtra("gender_value",gender_value);
                    intent.putExtra("gender_confidence",gender_confidence);
                    intent.putExtra("glass_value",glass_value);
                    intent.putExtra("glass_confidence",glass_confidence);
                    intent.putExtra("race_value",race_value);
                    intent.putExtra("race_confidence",race_confidence);
                    intent.putExtra("smiling_value",smiling_value);
                    intent.putExtra("photo_url",faceObject.getUrl());
                    intent.putExtra("formated_text", FormaterTextHelper.Formater(age_value, age_range, gender_confidence, gender_value, glass_confidence, glass_value, race_value, race_confidence, smiling_value));
                    intent.putExtra("error",0);
                    LocalBroadcastManager bm = LocalBroadcastManager.getInstance(FaceDetectorService.this);
                    bm.sendBroadcast(intent);
                }else{
                    Intent it = new Intent("FaceDetectorService");
                    it.putExtra("error",2);
                    it.putExtra("message",Integer.toString(statusCode));
                    LocalBroadcastManager bm = LocalBroadcastManager.getInstance(FaceDetectorService.this);
                    bm.sendBroadcast(it);
                }
            }

            @Override
            public void onFailure(Call<FaceObject> call, Throwable t) {
                // Log error here since request failed
                Intent it = new Intent("FaceDetectorService");
                it.putExtra("error",1);
                it.putExtra("message",t.getMessage());
                LocalBroadcastManager bm = LocalBroadcastManager.getInstance(FaceDetectorService.this);
                bm.sendBroadcast(it);
            }
        });
    }
}

