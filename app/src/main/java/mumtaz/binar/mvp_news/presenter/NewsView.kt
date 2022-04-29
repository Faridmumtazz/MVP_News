package mumtaz.binar.mvp_news.presenter

import mumtaz.binar.mvp_news.model.GetAllNewsResponseItem

interface NewsView {

    fun onSuccess(pesan: String , news: List<GetAllNewsResponseItem>){

    }

    fun onError(pesan : String)
}