package com.example.shami.newsfeed.ZemaPojo

import com.example.shami.newsfeed.ZemaPojo.Response.response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ehitshamshami on 3/8/2018.
 */

interface NewsService
{

    @GET(EndPoints.newsFeedURL)
    fun getNews(@Query("tag") tag:String,@Query("from-date") from_date:String,@Query("api-key") api_key:String):Observable<response>

}