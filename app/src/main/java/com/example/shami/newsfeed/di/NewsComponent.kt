package com.example.shami.newsfeed.di

import com.example.shami.newsfeed.NewsApplication
import com.example.shami.newsfeed.mainactivity.MainActivity
import com.example.shami.newsfeed.mainactivity.MainActivityComponent
import com.example.shami.newsfeed.mainactivity.MainActivityModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ehtisham shami on 3/22/2018.
 */

@Singleton
@Component(modules = arrayOf(ApiModule::class,AppModule::class))
public interface NewsComponent
{
    fun inject(app: NewsApplication)
    fun inject(mainActivity: MainActivity)
    fun plus(mainActivityModule: MainActivityModule):MainActivityComponent


}