package com.example.shami.newsfeed.mainactivity

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.*
import com.example.shami.newsfeed.NewsAdapter
import com.example.shami.newsfeed.NewsApplication
import com.example.shami.newsfeed.R
import com.example.shami.newsfeed.zemapojo.NewsService
import com.example.shami.newsfeed.zemapojo.applySchedulersKotlin
import com.example.shami.newsfeed.zemapojo.response.Results
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    lateinit var listView: ListView
    lateinit var progressBar: ProgressBar
    lateinit var notfound: TextView

    lateinit var newsAdapter: NewsAdapter

    lateinit var disposable: Disposable


    @Inject
    lateinit var mNewsService: NewsService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as NewsApplication).createMainActivityComponent().inject(this)


        listView = findViewById(R.id.list) as ListView
        progressBar = findViewById(R.id.loading_spinner) as ProgressBar
        notfound = findViewById(R.id.empty_view) as TextView
        newsAdapter = NewsAdapter(this, ArrayList())
        listView.adapter = newsAdapter
        listView.emptyView = notfound
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, l ->
            val newsfeed = newsAdapter!!.getItem(position)
            val earthquakeUri = Uri.parse(newsfeed!!.webUrl)
            val websiteIntent = Intent(Intent.ACTION_VIEW, earthquakeUri)
            startActivity(websiteIntent)
        }

        progressBar = findViewById(R.id.loading_spinner) as ProgressBar
        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting

        if (isConnected) {
            progressBar.visibility = View.VISIBLE

//            disposable=ApiClient.newApiClientInstance.getServerAPI().getNews("politics/politics","2014-01-01","test")
//                    .compose(applySchedulersKotlin())
//                    .subscribe(
//                            { result ->
//                                 setList(result.Response.Results)
//                            },
//                            { error ->
//                                Toast.makeText(this,error.message,Toast.LENGTH_SHORT).show()
//                                Log.d("Error",error.message)
//                                progressBar.visibility = View.GONE
//                            }
//                    )


            disposable=mNewsService.getNews("politics/politics","2014-01-01","test")
                    .compose(applySchedulersKotlin())
                    .subscribe(
                            { result ->
                                setList(result.response.results)
                            },
                            { error ->
                                Toast.makeText(this,error.message,Toast.LENGTH_SHORT).show()
                                Log.d("Error",error.message)
                                progressBar.visibility = View.GONE
                            }
                    )




        } else {
            progressBar.visibility = View.GONE
            notfound.text = "No Internet Connection"
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()

    }


    internal fun setList(newsfeeds: List<Results>?) {
        progressBar.visibility = View.GONE
        notfound.setText(R.string.no_news)
        newsAdapter.clear()
        if (newsfeeds != null && !newsfeeds.isEmpty()) {
            newsAdapter.addAll(newsfeeds)
        }
    }


    //    List<Newsfeed> getListFromBackground() throws IOException
    //    {
    //        URL url=QueryUtils.createurl(USGS_REQUEST_URL);
    //        if(url == null)
    //        {
    //            return null;
    //        }
    //        String jsonResponse="";
    //        List<Newsfeed> newsfeeds=null;
    //
    //        jsonResponse=QueryUtils.makeHttpRequest(url);
    //        newsfeeds = QueryUtils.extractEarthquakes(jsonResponse);
    //
    //        return newsfeeds;
    //    }


}
