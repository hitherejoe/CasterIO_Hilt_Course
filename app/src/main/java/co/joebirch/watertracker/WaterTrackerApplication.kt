package co.joebirch.watertracker

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class WaterTrackerApplication: Application() {

    @Inject lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()
        logger.configure()
    }
}