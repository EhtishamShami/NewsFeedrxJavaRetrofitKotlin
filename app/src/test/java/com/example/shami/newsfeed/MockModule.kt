package com.example.shami.newsfeed

import android.support.test.espresso.core.deps.dagger.Module
import com.example.shami.newsfeed.zemapojo.NewsService
import dagger.Provides
import org.mockito.Mockito
import javax.inject.Singleton

/**
 * Created by Ehitshamshami on 3/22/2018.
 */

@Module
public class MockModule
{

    @Provides
    @Singleton
    fun getServerApi(): NewsService
    {
        return Mockito.mock(NewsService::class.java)
    }

}