package com.example.kamal.myapplication.viewModel;

import com.example.kamal.myapplication.model.pojo.Rss;
import com.example.kamal.myapplication.repository.RssRepository;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class RssListViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Rss> data;
    private RssRepository movieModel;

    public RssListViewModel() {
        movieModel = new RssRepository();
    }

    public void init() {
        if (this.data != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        data = movieModel.getRss();
    }

    public MutableLiveData<Rss> getMovies() {
        return this.data;
    }
}
