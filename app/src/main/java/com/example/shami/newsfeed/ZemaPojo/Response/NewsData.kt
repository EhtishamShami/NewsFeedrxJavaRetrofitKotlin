package com.example.shami.newsfeed.ZemaPojo.Response

/**
 * Created by Ehitshamshami on 3/8/2018.
 */



data class NewsData(
        val status:String,
        val userTier:String,
        val total:Int,
        val startIndex:Int,
        val pageSize:Int,
        val currentPage:Int,
        val pages:Int,
        val orderBy:String,
        val results:List<results>
)





