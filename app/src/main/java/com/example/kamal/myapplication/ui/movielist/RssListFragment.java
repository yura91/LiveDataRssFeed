package com.example.kamal.myapplication.ui.movielist;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kamal.myapplication.R;
import com.example.kamal.myapplication.model.pojo.Item;
import com.example.kamal.myapplication.model.pojo.Rss;
import com.example.kamal.myapplication.viewModel.RssListViewModel;

import java.util.ArrayList;
import java.util.List;



public class RssListFragment extends Fragment {

    private RssListViewModel mViewModel;
    private List<Item> rssItemsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RssAdapter mAdapter;

    public static RssListFragment newInstance() {
        return new RssListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.rss_list_fragment, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        mAdapter = new RssAdapter(rssItemsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RssListViewModel.class);
        mViewModel.init();
        mViewModel.getMovies().observe(this, new Observer<Rss>() {
            @Override
            public void onChanged(@Nullable Rss rss) {
                rssItemsList.addAll(rss.getChannel().getItems());
                mAdapter.notifyDataSetChanged();
            }
        });
        }

}
