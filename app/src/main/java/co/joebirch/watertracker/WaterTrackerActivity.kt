package co.joebirch.watertracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_water_tracker.*

class WaterTrackerActivity : AppCompatActivity(), WaterIntakePreferenceListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_tracker)
    }

    override fun onWaterIntakeChanged(waterIntake: Int) {
        waterCountText.text = waterIntake.toString()
    }
}