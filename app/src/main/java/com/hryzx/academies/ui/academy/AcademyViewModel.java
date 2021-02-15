package com.hryzx.academies.ui.academy;

import androidx.lifecycle.ViewModel;

import com.hryzx.academies.data.CourseEntity;
import com.hryzx.academies.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {
    public List<CourseEntity> getCourses() {
        return DataDummy.generateDummyCourses();
    }
}
