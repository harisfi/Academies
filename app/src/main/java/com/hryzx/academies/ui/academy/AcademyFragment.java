package com.hryzx.academies.ui.academy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hryzx.academies.R;
import com.hryzx.academies.data.CourseEntity;
import com.hryzx.academies.databinding.FragmentAcademyBinding;
import com.hryzx.academies.utils.DataDummy;
import com.hryzx.academies.viewmodel.ViewModelFactory;

import java.util.List;

public class AcademyFragment extends Fragment {

    private FragmentAcademyBinding fragmentAcademyBinding;

    public AcademyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAcademyBinding = FragmentAcademyBinding.inflate(inflater, container, false);
        return fragmentAcademyBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            AcademyViewModel viewModel = new ViewModelProvider(this, factory).get(AcademyViewModel.class);

            AcademyAdapter academyAdapter = new AcademyAdapter();
            fragmentAcademyBinding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getCourses().observe(getViewLifecycleOwner(), courses -> {
                        fragmentAcademyBinding.progressBar.setVisibility(View.GONE);
                        academyAdapter.setCourses(courses);
                        academyAdapter.notifyDataSetChanged();
                    }
            );

            fragmentAcademyBinding.rvAcademy.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentAcademyBinding.rvAcademy.setHasFixedSize(true);
            fragmentAcademyBinding.rvAcademy.setAdapter(academyAdapter);
        }
    }
}