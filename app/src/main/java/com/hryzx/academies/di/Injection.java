package com.hryzx.academies.di;

import android.content.Context;

import com.hryzx.academies.data.source.AcademyRepository;
import com.hryzx.academies.data.source.remote.RemoteDataSource;
import com.hryzx.academies.utils.JsonHelper;

public class Injection {
    public static AcademyRepository provideRepository(Context context) {

        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(new JsonHelper(context));

        return AcademyRepository.getInstance(remoteDataSource);
    }
}