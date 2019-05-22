package com.jdsv650.recyclerviewtest;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclerFragment extends Fragment implements RecyclerViewAdapter.ItemClickListener {

    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;

    private IRecyclerItem recyclerItem;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment RecyclerFragment.
     */
    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        recyclerItem = (IRecyclerItem) activity;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

        // get a reference to recyclerView
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewId);

        // set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // RecyclerView data
        ArrayList<String> colorNames = new ArrayList<>();

        colorNames.add("Black");
        colorNames.add("Red");
        colorNames.add("Green");
        colorNames.add("Blue");
        colorNames.add("Grey");

        adapter = new RecyclerViewAdapter(getContext(), colorNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        return rootView;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onItemClick(View view, int position) {

        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        updateDisplay(adapter.getItem(position));
    }

    private void updateDisplay(String color) {
        if (recyclerItem != null) {
            recyclerItem.OnRecyclerItemClicked(color);
        }
    }

    @Override
    public void onDestroy() {
        recyclerItem = null;
        super.onDestroy();
    }
}



interface IRecyclerItem
{
    void OnRecyclerItemClicked(String colorName);
}