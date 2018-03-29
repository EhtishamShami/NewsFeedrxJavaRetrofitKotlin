package com.example.shami.newsfeed.zemapojo

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ehitshamshami on 3/8/2018.
 */

//
//public static <T> ObservableTransformer<T, T> applySchedulers() {
//    return new ObservableTransformer < T, T>() {
//        override fun apply(upstream: Observable<T>): ObservableSource<T> {
//            return upstream.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//
//        }
//
//


inline fun <T>applySchedulersKotlin():ObservableTransformer<T,T>
{
    return object:ObservableTransformer<T,T>{
        override fun apply(upstream: Observable<T>): ObservableSource<T> {

            return upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

        }
    }


}


//// custom transformer
//fun <T> Observable<T>.applySchedulers(transformer: ThreadTransformer): Observable<T> {
//    return compose(transformer.applySchedulers<T>())
//}

//public ObservableTransformer<T, T> applySchedulers() {
//    return new ObservableTransformer < T, T>() {
//        override fun apply(upstream: Observable<T>): ObservableSource<T> {
//            return upstream.subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//
//        }
//
//
