package mumtaz.binar.mvp_news.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_news2.*
import mumtaz.binar.mvp_news.R
import mumtaz.binar.mvp_news.adapter.NewsAdapter
import mumtaz.binar.mvp_news.model.GetAllNewsResponseItem
import mumtaz.binar.mvp_news.presenter.NewsPresenter
import mumtaz.binar.mvp_news.presenter.NewsView

class MainNewsActivity : AppCompatActivity(), NewsView {

    private lateinit var presenternews : NewsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_news2)

        presenternews = NewsPresenter(this)
        presenternews.getDataNews()
    }

    override fun onSuccess(pesan: String, news: List<GetAllNewsResponseItem>) {
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = NewsAdapter(news)
    }
    override fun onError(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_LONG).show()
    }
}