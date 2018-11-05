package com.example.kamal.myapplication.repository;




import com.example.kamal.myapplication.model.pojo.Rss;
import com.example.kamal.myapplication.network.APIInterface;
import com.example.kamal.myapplication.network.ApiClient;


import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class RssRepository {

    private APIInterface apiInterface;


    public RssRepository() {
    }

    public MutableLiveData<Rss> getMovies() {
        final MutableLiveData<Rss> refferAndInvitePojoMutableLiveData = new MutableLiveData<>();
        apiInterface = ApiClient.getClientAuthentication().create(APIInterface.class);
        Call<Rss> call = apiInterface.getdata();
        call.enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                if(response.body()!=null)
                {
                    refferAndInvitePojoMutableLiveData.setValue(response.body());
                }


            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {

            }
        });

        return refferAndInvitePojoMutableLiveData;
    }
}