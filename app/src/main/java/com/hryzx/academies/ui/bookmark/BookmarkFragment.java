package com.hryzx.academies.ui.bookmark;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hryzx.academies.R;
import com.hryzx.academies.data.CourseEntity;
import com.hryzx.academies.databinding.FragmentBookmarkBinding;
import com.hryzx.academies.utils.DataDummy;

import java.util.List;

public class BookmarkFragment extends Fragment implements BookmarkFragmentCallback{

    private FragmentBookmarkBinding fragmentBookmarkBinding;

    public BookmarkFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(inflater, container, false);
        return fragmentBookmarkBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null) {
            List<CourseEntity> courses = DataDummy.generateDummyCourses();
            BookmarkAdapter adapter = new BookmarkAdapter(this);
            adapter.setCourses(courses);
            fragmentBookmarkBinding.rvBookmark.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentBookmarkBinding.rvBookmark.setHasFixedSize(true);
            fragmentBookmarkBinding.rvBookmark.setAdapter(adapter);
        }
    }

    @Override
    public void onShareClick(CourseEntity course) {
        if (getActivity() != null) {
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(getActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText(getResources().getString(R.string.share_text, course.getTitle()))
                    .startChooser();
        }
    }
}