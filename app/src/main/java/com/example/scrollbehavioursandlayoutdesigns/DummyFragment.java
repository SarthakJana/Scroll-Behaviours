package com.example.scrollbehavioursandlayoutdesigns;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DummyFragment extends Fragment {


    private RecyclerView mRecyclerView;

   // private OnFragmentInteractionListener mListener;

    public DummyFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static DummyFragment newInstance() {
        DummyFragment fragment = new DummyFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dummy, container, false);
        mRecyclerView = view.findViewById(R.id.rv_dummy_text);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(new DummyAdapter(getContext()));

        return view;
    }

}
