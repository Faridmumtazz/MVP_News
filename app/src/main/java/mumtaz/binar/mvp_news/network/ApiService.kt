package mumtaz.binar.mvp_news.network

import mumtaz.binar.mvp_news.model.GetAllNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    fun getAllNews() : Call<List<GetAllNewsResponseItem>>
}