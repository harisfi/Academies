package com.hryzx.academies.ui.academy;

import androidx.lifecycle.ViewModel;

import com.hryzx.academies.data.CourseEntity;
import com.hryzx.academies.data.source.AcademyRepository;
import com.hryzx.academies.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {
    private AcademyRepository academyRepository;
    public AcademyViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public List<CourseEntity> getCourses() {
        return academyRepository.getAllCourses();
    }
}
