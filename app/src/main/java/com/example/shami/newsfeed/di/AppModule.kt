package com.example.shami.newsfeed.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.shami.newsfeed.zemapojo.NewsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Ehitshamshami on 3/19/2018.
 */
@Module
class AppModule(var application: Application)
{

    @Provides
    @Singleton
    fun provideContext(): Context
    {
        return application
    }

    @Provides
    fun provideSharedPerferneces(context: Context): SharedPreferences
    {
        return PreferenceManager.getDefaultSharedPreferences(context)

    }

    @Provides
    @Singleton
    fun getServerApi(retrofit: Retrofit): NewsService
    {
        return retrofit.create(NewsService::class.java)
    }



}