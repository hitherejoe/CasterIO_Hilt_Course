package co.joebirch.watertracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.joebirch.watertracker.di.component.DaggerWaterTrackerActivityComponent
import javax.inject.Inject

class WaterTrackerActivity : AppCompatActivity() {

    @Inject
    lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_tracker)
        DaggerWaterTrackerActivityComponent
            .builder()
            .applicationComponent((applicationContext as WaterTrackerApplication).appComponent)
            .build()
            .inject(this)
    }
}