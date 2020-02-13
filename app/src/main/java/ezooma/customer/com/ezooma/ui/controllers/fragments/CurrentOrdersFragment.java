package ezooma.customer.com.ezooma.ui.controllers.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ezooma.customer.com.ezooma.R;
import ezooma.customer.com.ezooma.interfaces.OnFragmentInteraction;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvCurrentOrdersAdapter;
import ezooma.customer.com.ezooma.ui.controllers.adapters.rvAdapters.RvNotificationsAdapter;

public class CurrentOrdersFragment extends Fragment {

    private OnFragmentInteraction mListener;
    private RecyclerView mRvCurrentOrders;
    private RvCurrentOrdersAdapter mRvCurrentOrdersAdapter;

    public CurrentOrdersFragment() {
        // Required empty public constructor
    }

    public static CurrentOrdersFragment newInstance() {
        CurrentOrdersFragment fragment = new CurrentOrdersFragment();
        Bundle args = new Bundle();
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
        // Inflate the layout for this fragment
        View lView = inflater.inflate(R.layout.fragment_current_orders, container, false);
        mRvCurrentOrders = lView.findViewById(R.id.rvCurrentOrders);
        return lView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRv();
    }

    private void setUpRv() {
        if(getActivity()==null)
            return;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        };
        mRvCurrentOrders.setLayoutManager(layoutManager);
        mRvCurrentOrders.setItemAnimator(new DefaultItemAnimator());
        mRvCurrentOrdersAdapter = new RvCurrentOrdersAdapter(getActivity());
        mRvCurrentOrders.setAdapter(mRvCurrentOrdersAdapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteraction) {
            mListener = (OnFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
