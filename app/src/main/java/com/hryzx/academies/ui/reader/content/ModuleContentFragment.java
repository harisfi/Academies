package com.hryzx.academies.ui.reader.content;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hryzx.academies.R;
import com.hryzx.academies.data.ContentEntity;
import com.hryzx.academies.data.ModuleEntity;
import com.hryzx.academies.databinding.FragmentModuleContentBinding;
import com.hryzx.academies.ui.reader.CourseReaderViewModel;
import com.hryzx.academies.viewmodel.ViewModelFactory;

public class ModuleContentFragment extends Fragment {

    public static final String TAG = ModuleContentFragment.class.getSimpleName();
    private FragmentModuleContentBinding fragmentModuleContentBinding;

    public ModuleContentFragment() {
        // Required empty public constructor
    }

    public static ModuleContentFragment newInstance() {
        return new ModuleContentFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentModuleContentBinding = FragmentModuleContentBinding.inflate(inflater, container, false);
        return fragmentModuleContentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(requireActivity());
            CourseReaderViewModel viewModel = new ViewModelProvider(requireActivity(), factory).get(CourseReaderViewModel.class);

            fragmentModuleContentBinding.progressBar.setVisibility(View.VISIBLE);
            viewModel.getSelectedModule().observe(getViewLifecycleOwner(), module -> {
                fragmentModuleContentBinding.progressBar.setVisibility(View.GONE);
                if (module != null) {
                    populateWebView(module);
                }
            });
        }
    }

    private void populateWebView(ModuleEntity module) {
//        fragmentModuleContentBinding.webView.loadData(content.getContent(), "text/html", "UTF-8");
        fragmentModuleContentBinding.webView.loadData(module.contentEntity.getContent(), "text/html", "UTF-8");
    }
}