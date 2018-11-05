package com.example.kamal.myapplication.viewModel;

import com.example.kamal.myapplication.model.pojo.Rss;
import com.example.kamal.myapplication.repository.MovieRepository;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class RssListViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<Rss> data;
    private MovieRepository movieModel;

    public RssListViewModel() {
        movieModel = new MovieRepository();
    }

    public void init() {
        if (this.data != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        data = movieModel.getMovies();
    }

    public MutableLiveData<Rss> getMovies() {
        return this.data;
    }
}
