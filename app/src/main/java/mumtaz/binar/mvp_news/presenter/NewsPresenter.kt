package mumtaz.binar.mvp_news.presenter

import android.widget.Toast
import mumtaz.binar.mvp_news.model.GetAllNewsResponseItem
import mumtaz.binar.mvp_news.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsPresenter (val viewnews : NewsView) {

    fun getDataNews(){
        ApiClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetAllNewsResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllNewsResponseItem>>,
                    response: Response<List<GetAllNewsResponseItem>>
                ) {
                    if(response.isSuccessful){
                        viewnews.onSuccess(response.message(), response.body()!!)
                    }else{
                        viewnews.onError(response.message())
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsResponseItem>>, t: Throwable) {
                    viewnews.onError(t.message!!)
                }

            })
    }
}