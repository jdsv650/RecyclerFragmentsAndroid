package com.jdsv650.recyclerviewtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColoredFragment extends Fragment {

    private static final String ARG_COLOR = "color";


    public ColoredFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment RecyclerFragment.
     */
    public static ColoredFragment newInstance(String color) {
        ColoredFragment fragment = new ColoredFragment();
        Bundle args = new Bundle();
        args.putString(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_colored, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            String color = getArguments().getString(ARG_COLOR);

            switch (color) {
                case "Black":
                    view.findViewById(R.id.coloredTVId).setBackgroundColor(Color.BLACK);
                    break;
                case "Red":
                    view.findViewById(R.id.coloredTVId).setBackgroundColor(Color.RED);
                    break;
                case "Green":
                    view.findViewById(R.id.coloredTVId).setBackgroundColor(Color.GREEN);
                    break;
                case "Blue":
                    view.findViewById(R.id.coloredTVId).setBackgroundColor(Color.BLUE);
                    break;
                case "Grey":
                    view.findViewById(R.id.coloredTVId).setBackgroundColor(Color.GRAY);
                    break;
                    default:
                        view.findViewById(R.id.coloredTVId).setBackgroundColor(Color.WHITE);

            }
        }

    }
}
