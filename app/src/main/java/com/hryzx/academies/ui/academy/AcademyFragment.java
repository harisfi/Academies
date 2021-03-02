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
//            AcademyViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AcademyViewModel.class);
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            AcademyViewModel viewModel = new ViewModelProvider(this, factory).get(AcademyViewModel.class);
            List<CourseEntity> courses = viewModel.getCourses();

//            List<CourseEntity> courses = DataDummy.generateDummyCourses();
            AcademyAdapter academyAdapter = new AcademyAdapter();
            academyAdapter.setCourses(courses);
            fragmentAcademyBinding.rvAcademy.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentAcademyBinding.rvAcademy.setHasFixedSize(true);
            fragmentAcademyBinding.rvAcademy.setAdapter(academyAdapter);
        }
    }
}