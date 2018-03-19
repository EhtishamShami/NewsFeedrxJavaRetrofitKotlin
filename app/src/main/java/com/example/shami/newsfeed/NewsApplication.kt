package com.example.shami.newsfeed

import android.app.Application
import com.example.shami.newsfeed.di.ApiModule
import com.example.shami.newsfeed.di.AppComponent
import com.example.shami.newsfeed.di.AppModule
import com.example.shami.newsfeed.di.DaggerAppComponent

/**
 * Created by Ehitshamshami on 3/19/2018.
 */

class NewsApplication:Application()
{

//
//    val appComponent: AppComponent by lazy {
//        Dagger
//                .builder()
//                .appModule(AppModule(this))
//                .build()
//    }


    val appComponent: AppComponent by lazy{
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule(this))
                .build()
    }



    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    public fun getComponent():AppComponent
    {
        return appComponent
    }

}