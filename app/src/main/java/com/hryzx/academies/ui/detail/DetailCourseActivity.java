package com.hryzx.academies.ui.detail;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.hryzx.academies.R;
import com.hryzx.academies.data.CourseEntity;
import com.hryzx.academies.data.ModuleEntity;
import com.hryzx.academies.databinding.ActivityDetailCourseBinding;
import com.hryzx.academies.databinding.ContentDetailCourseBinding;
import com.hryzx.academies.ui.reader.CourseReaderActivity;
import com.hryzx.academies.utils.DataDummy;
import com.hryzx.academies.viewmodel.ViewModelFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.View;

import java.util.List;

public class DetailCourseActivity extends AppCompatActivity {
    public static final String EXTRA_COURSE = "extra_course";
    private ContentDetailCourseBinding detailContentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailCourseBinding activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(getLayoutInflater());
        detailContentBinding = activityDetailCourseBinding.detailContent;
        setContentView(activityDetailCourseBinding.getRoot());
        setSupportActionBar(activityDetailCourseBinding.toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        DetailCourseAdapter adapter = new DetailCourseAdapter();

//        DetailCourseViewModel viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DetailCourseViewModel.class);
        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailCourseViewModel viewModel = new ViewModelProvider(this, factory).get(DetailCourseViewModel.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String courseId = extras.getString(EXTRA_COURSE);
            if (courseId != null) {
                viewModel.setSelectedCourse(courseId);
//                List<ModuleEntity> modules = DataDummy.generateDummyModules(courseId);
                List<ModuleEntity> modules = viewModel.getModules();
                adapter.setModules(modules);

                populateCourse(viewModel.getCourse());
                /*for (int i = 0; i < DataDummy.generateDummyCourses().size(); i++) {
                    CourseEntity courseEntity = DataDummy.generateDummyCourses().get(i);
                    if (courseEntity.getCourseId().equals(courseId)) {
                        populateCourse(courseEntity);
                    }
                }*/
            }
        }

        detailContentBinding.rvModule.setNestedScrollingEnabled(false);
        detailContentBinding.rvModule.setLayoutManager(new LinearLayoutManager(this));
        detailContentBinding.rvModule.setHasFixedSize(true);
        detailContentBinding.rvModule.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(detailContentBinding.rvModule.getContext(), DividerItemDecoration.VERTICAL);
        detailContentBinding.rvModule.addItemDecoration(dividerItemDecoration);
    }

    private void populateCourse(CourseEntity courseEntity) {
        detailContentBinding.textTitle.setText(courseEntity.getTitle());
        detailContentBinding.textDescription.setText(courseEntity.getDescription());
        detailContentBinding.textDate.setText(getResources().getString(R.string.deadline_date, courseEntity.getDeadline()));

        Glide.with(this)
                .load(courseEntity.getImagePath())
                .transform(new RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster);

        detailContentBinding.btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(DetailCourseActivity.this, CourseReaderActivity.class);
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.getCourseId());
            startActivity(intent);
        });
    }
}