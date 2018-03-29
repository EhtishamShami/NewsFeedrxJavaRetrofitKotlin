package com.example.shami.newsfeed

import com.example.shami.newsfeed.di.NewsComponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ehitshamshami on 3/22/2018.
 */

@Singleton
@Component(modules = arrayOf(MockModule::class))
public interface TestingComponent:NewsComponent
{

    fun inject(inject:MainActivityTest)

}