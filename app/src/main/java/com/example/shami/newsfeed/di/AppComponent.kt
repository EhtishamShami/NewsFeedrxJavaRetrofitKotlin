package com.example.shami.newsfeed.di

import com.example.shami.newsfeed.MainActivity
import com.example.shami.newsfeed.NewsApplication
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ehitshamshami on 3/19/2018.
 */

@Singleton
@Component(modules = arrayOf(ApiModule::class,AppModule::class))
public interface AppComponent
{

    fun inject(app:NewsApplication)
    fun inject(mainActivity: MainActivity)


}