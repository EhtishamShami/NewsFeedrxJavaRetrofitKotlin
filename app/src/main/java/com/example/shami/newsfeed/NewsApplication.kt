package com.example.shami.newsfeed

import android.app.Application
import com.example.shami.newsfeed.di.ApiModule
import com.example.shami.newsfeed.di.AppModule
import com.example.shami.newsfeed.di.DaggerNewsComponent
import com.example.shami.newsfeed.di.NewsComponent
import com.example.shami.newsfeed.mainactivity.MainActivityComponent
import com.example.shami.newsfeed.mainactivity.MainActivityModule

/**
 * Created by Ehitshamshami on 3/19/2018.
 */

open class NewsApplication:Application()
{

//
//    val appComponent: AppComponent by lazy {
//        Dagger
//                .builder()
//                .appModule(AppModule(this))
//                .build()
//    }



    val appComponent: NewsComponent by lazy{
       createComponent()
    }

    val mainActivityComponent: MainActivityComponent by lazy {
        createMainActivityComponent()
    }



   open fun createComponent():NewsComponent
    {
        return  DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule(this))
                .build()
    }

    fun createMainActivityComponent():MainActivityComponent
    {

        return appComponent.plus(MainActivityModule())


    }

    fun releaseMainActivityComponent()
    {

    }



    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }







    public fun getComponent():NewsComponent
    {
        return appComponent
    }

}