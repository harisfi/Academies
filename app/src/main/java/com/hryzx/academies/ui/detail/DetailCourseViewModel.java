package com.hryzx.academies.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hryzx.academies.data.CourseEntity;
import com.hryzx.academies.data.ModuleEntity;
import com.hryzx.academies.data.source.AcademyRepository;
import com.hryzx.academies.utils.DataDummy;

import java.util.ArrayList;
import java.util.List;

public class DetailCourseViewModel extends ViewModel {
    private String courseId;
    private AcademyRepository academyRepository;
    public DetailCourseViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public void setSelectedCourse(String courseId) {
        this.courseId = courseId;
    }

    public LiveData<CourseEntity> getCourse() {
        return academyRepository.getCourseWithModules(courseId);
    }

    public LiveData<List<ModuleEntity>> getModules() {
        return academyRepository.getAllModulesByCourse(courseId);
    }
}
