package com.example.mac.retrofitdemo.data.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;


/**
 * Created by ${巴黎没有摩天轮Li} on 2017/3/25.
 */

public interface Api{

    /*获取积分*/
    @FormUrlEncoded
    @POST("mobileUser/getNumsCount")
    Call<ResponseBody> getNumsCount(@Field("studyId") String id);



    @FormUrlEncoded
    @POST("mobileSchool/getSchoolListApp")
    Observable<ResponseBody> getCollegeList(@Field("page") String page, @Field("sort") String sort);

    @Streaming //添加这个注解用来下载大文件
    @GET("jianShu-release-2.2.1-JianShu.apk")
    Observable<ResponseBody> downloadFileWithFixedUrl();
}
