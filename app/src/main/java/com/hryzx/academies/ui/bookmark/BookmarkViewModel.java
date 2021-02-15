package com.hryzx.academies.ui.bookmark;

import androidx.lifecycle.ViewModel;

import com.hryzx.academies.data.CourseEntity;
import com.hryzx.academies.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {
    public List<CourseEntity> getBookmarks() {
        return DataDummy.generateDummyCourses();
    }
}
