package co.joebirch.watertracker

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@InstallIn(ActivityComponent::class)
@Module
class WaterTrackingModule {

    @ActivityScoped
    @Provides
    fun providesPreferencesHelper(
        @ApplicationContext context: Context
    ) = PreferencesHelper(context)

}