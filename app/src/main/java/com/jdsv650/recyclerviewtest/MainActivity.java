package com.jdsv650.recyclerviewtest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements IRecyclerItem {

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment recyclerFragment = manager.findFragmentById(R.id.recyclerFragmentId);

        if (recyclerFragment == null)
        {
            recyclerFragment = new RecyclerFragment();
            manager.beginTransaction().add(R.id.recycler_layout, recyclerFragment).commit();
        }

        Fragment coloredFragment = manager.findFragmentById(R.id.coloredFragmentId);

        if (coloredFragment == null)
        {
            coloredFragment = new ColoredFragment();
            manager.beginTransaction().add(R.id.colored_layout, coloredFragment).commit();
        }

    }


    @Override
    public void OnRecyclerItemClicked(String colorName) {

        ColoredFragment rightFragment = ColoredFragment.newInstance(colorName);
        getSupportFragmentManager().beginTransaction().replace(R.id.coloredFragmentId,
                rightFragment).commit();

    }
}
