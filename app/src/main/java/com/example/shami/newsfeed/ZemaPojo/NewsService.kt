package com.example.shami.newsfeed.zemapojo

import com.example.shami.newsfeed.zemapojo.response.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ehtisham Shami on 3/8/2018.
 */

interface NewsService
{

    @GET(EndPoints.newsFeedURL)
    fun getNews(@Query("tag") tag:String,@Query("from-date") from_date:String,@Query("api-key") api_key:String):Observable<Response>

}