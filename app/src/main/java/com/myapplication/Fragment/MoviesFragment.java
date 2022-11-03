package com.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.Adapter.MyImageAdapter;
import com.myapplication.Model.ImageData;
import com.myapplication.R;

import java.util.ArrayList;

public class MoviesFragment extends Fragment {

    private  int[] images = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};
    private  String[] name = {"Avengers Endgame","Munna Michael","Genius","RED","Baaghi 3","Captain America"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        RecyclerView recycleData = view.findViewById(R.id.recycle_data);

        ArrayList<ImageData> imageDataArrayList = new ArrayList<>();

        for (int i = 0;i < images.length;i++){
            ImageData imageData = new ImageData(images[i],name[i]);
            imageDataArrayList.add(imageData);
        }

        MyImageAdapter myImageAdapter = new MyImageAdapter(getContext(), imageDataArrayList);
        /*StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.HORIZONTAL);*/
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recycleData.setLayoutManager(layoutManager);
        recycleData.setAdapter(myImageAdapter);


        recycleData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
