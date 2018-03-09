package com.example.shami.newsfeed.ZemaPojo

import com.example.shami.newsfeed.BuildConfig

/**
 * Created by Ehitshamshami on 3/8/2018.
 */
public class ApiClient:Dependencies() {

    /*
    static variable
    */

    companion object {
        private lateinit var serverAPI: NewsService
        val newApiClientInstance=ApiClient()
    }

    /*
        return server api instance
    */

    fun getServerAPI():NewsService{
        serverAPI = provideRestApi(NewsService::class.java, null)
        return serverAPI
    }

    /*
    Base URL Initialization
    */

    override fun getBaseUrl(): String {

        return BuildConfig.baseURL
    }

    /*
    Header Initialization
    */
    override fun getHeaders(): HashMap<String, String> {
        val params = HashMap<String, String>()
        params.put("Content-Type", "application/json")
        return params
    }

}