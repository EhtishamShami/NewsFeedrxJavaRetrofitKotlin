package com.example.shami.newsfeed.zemapojo.response

/**
 * Created by Ehitshamshami on 3/8/2018.
 */


data class Results(val id:String,
                   val type:String,
                   val sectionId:String,
                   val sectionName:String,
                   val webPublicationDate:String,
                   val webTitle:String,
                   val webUrl:String,
                   val apiUrl:String,
                   val isHosted:Boolean,
                   val pillarId:String,
                   val pillarName:String
)