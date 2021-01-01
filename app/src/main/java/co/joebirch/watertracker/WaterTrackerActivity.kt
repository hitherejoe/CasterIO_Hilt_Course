package co.joebirch.watertracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_water_tracker.*
import javax.inject.Inject

@AndroidEntryPoint
class WaterTrackerActivity : AppCompatActivity(), WaterIntakePreferenceListener {

    @Inject lateinit var preferencesHelper: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_tracker)

        waterCountText.text = preferencesHelper.getWaterIntake().toString()

        trackWaterButton.setOnClickListener {
            preferencesHelper.incrementWaterIntake()
        }

        preferencesHelper.subscribeToWaterIntakeChanges(this)
    }

    override fun onDestroy() {
        preferencesHelper.unsubscribeFromWaterIntakeChanges()
        super.onDestroy()
    }

    override fun onWaterIntakeChanged(waterIntake: Int) {
        waterCountText.text = waterIntake.toString()
    }
}