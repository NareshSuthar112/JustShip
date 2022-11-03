package com.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.futuremind.recyclerviewfastscroll.FastScroller;
import com.myapplication.Adapter.ImageLiveDataAdapter;
import com.myapplication.Instance.ApiClientInstance;
import com.myapplication.Instance.ApiInterface;
import com.myapplication.Model.ImageLiveData;
import com.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuperCoinFragment extends Fragment {

    List<ImageLiveData> imageLiveData;

    RecyclerView recyclerData;

    ImageLiveDataAdapter imageLiveDataAdapter;

    ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayout;

    Call<List<ImageLiveData>> call;
    ApiInterface apiInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_super_coin, container, false);
        progressBar = rootview.findViewById(R.id.progress_bar);
        swipeRefreshLayout = rootview.findViewById(R.id.swipe_refresh);
        recyclerData = rootview.findViewById(R.id.recycler_data);
        recyclerData.computeVerticalScrollOffset();

        progressBar.setVisibility(View.VISIBLE);

        apiInterface = ApiClientInstance.getRetrofit().create(ApiInterface.class);

        // call = apiInterface.getAllPhotos();
        loadData();


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                progressBar.setVisibility(View.VISIBLE);
                loadData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        return rootview;
    }

    public void setData(List<ImageLiveData> imageLiveData) {
        imageLiveDataAdapter = new ImageLiveDataAdapter(getActivity(), imageLiveData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerData.setLayoutManager(layoutManager);
        recyclerData.setAdapter(imageLiveDataAdapter);
    }

    public void loadData() {
        imageLiveData = new ArrayList<>();
        imageLiveData.clear();

        call = apiInterface.getAllPhotos();
        call.enqueue(new Callback<List<ImageLiveData>>() {
            @Override
            public void onResponse(Call<List<ImageLiveData>> call, Response<List<ImageLiveData>> response) {
                //  progressDoalog.dismiss();
                // generateDataList(response.body());
                if (response.code() == 200) {

                    imageLiveData.addAll(response.body());
                    setData(response.body());

                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<ImageLiveData>> call, Throwable t) {
                //    progressDoalog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
