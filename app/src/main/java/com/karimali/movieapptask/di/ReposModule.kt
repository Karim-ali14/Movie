package com.karimali.movieapptask.di

import com.karimali.movieapptask.data.api.ApiService
import com.karimali.movieapptask.data.repository.MainRepository
import com.karimali.movieapptask.data.repository.MainRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.annotation.Nullable

@Module
@InstallIn(ViewModelComponent::class)
object ReposModule {

    @Provides
    fun provideMainRepository(@Nullable service: ApiService) : MainRepository {
        return MainRepositoryImp(service)
    }
}