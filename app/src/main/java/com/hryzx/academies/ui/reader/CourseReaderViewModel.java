package com.hryzx.academies.ui.reader;

import androidx.lifecycle.ViewModel;

import com.hryzx.academies.data.ContentEntity;
import com.hryzx.academies.data.ModuleEntity;
import com.hryzx.academies.data.source.AcademyRepository;
import com.hryzx.academies.utils.DataDummy;

import java.util.ArrayList;
import java.util.List;

public class CourseReaderViewModel extends ViewModel {
    private String courseId;
    private String moduleId;
    private AcademyRepository academyRepository;

    public CourseReaderViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public void setSelectedCourse(String courseId) {
        this.courseId = courseId;
    }

    public void setSelectedModule(String moduleId) {
        this.moduleId = moduleId;
    }

    public List<ModuleEntity> getModules() {
        return academyRepository.getAllModulesByCourse(courseId);
    }

    public ModuleEntity getSelectedModule() {
        return academyRepository.getContent(courseId, moduleId);
    }
}
