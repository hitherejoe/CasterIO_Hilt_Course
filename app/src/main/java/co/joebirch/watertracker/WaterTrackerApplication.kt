package co.joebirch.watertracker

import android.app.Application
import co.joebirch.watertracker.di.component.ApplicationComponent
import co.joebirch.watertracker.di.component.DaggerApplicationComponent
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class WaterTrackerApplication: Application() {

    @Inject lateinit var logger: Logger

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()

        logger.configure()
    }
}