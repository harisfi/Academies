package com.hryzx.academies.ui.bookmark;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.hryzx.academies.data.CourseEntity;
import com.hryzx.academies.data.source.AcademyRepository;
import com.hryzx.academies.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {
    private AcademyRepository academyRepository;
    public BookmarkViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public LiveData<List<CourseEntity>> getBookmarks() {
        return academyRepository.getBookmarkedCourses();
    }
}
