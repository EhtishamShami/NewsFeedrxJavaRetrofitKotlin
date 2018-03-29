package com.example.shami.newsfeed.mainactivity

import dagger.Subcomponent

/**
 * Created by Ehitshamshami on 3/29/2018.
 */

@MainActivityScope
@Subcomponent(modules = arrayOf(MainActivityModule::class))
public interface MainActivityComponent
{

    fun inject(mainActivity: MainActivity)

}