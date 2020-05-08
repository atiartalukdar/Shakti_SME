package com.sfdw.shaktisme.memberList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sfdw.shaktisme.R;

public class SavingsDetailsFragment extends Fragment {

    public SavingsDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_savings_details, container, false);

       // member = ((KYCActivity) getActivity()).getMember();

        return view;
    }

}
