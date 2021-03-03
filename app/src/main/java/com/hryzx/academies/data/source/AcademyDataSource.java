package com.hryzx.academies.data.source;

import androidx.lifecycle.LiveData;

import com.hryzx.academies.data.CourseEntity;
import com.hryzx.academies.data.ModuleEntity;

import java.util.List;

public interface AcademyDataSource {

    LiveData<List<CourseEntity>> getAllCourses();

    LiveData<CourseEntity> getCourseWithModules(String courseId);

    LiveData<List<ModuleEntity>> getAllModulesByCourse(String courseId);

    LiveData<List<CourseEntity>> getBookmarkedCourses();

    LiveData<ModuleEntity> getContent(String courseId, String moduleId);
}