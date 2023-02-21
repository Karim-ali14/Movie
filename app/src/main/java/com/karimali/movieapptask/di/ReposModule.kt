package com.karimali.movieapptask.di

import com.karimali.movieapptask.data.api.ApiService
import com.karimali.movieapptask.data.repository.moveRepo.MoveRepository
import com.karimali.movieapptask.data.repository.moveRepo.MoveRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.annotation.Nullable

@Module
@InstallIn(ViewModelComponent::class)
object ReposModule {

    @Provides
    fun provideMoveRepository(@Nullable service: ApiService) : MoveRepository {
        return MoveRepositoryImp(service)
    }
}