package co.joebirch.watertracker

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import co.joebirch.watertracker.di.component.DaggerWaterTrackerViewComponent
import javax.inject.Inject

class WaterCountTextView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attributeSet, defStyleAttr) {

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    override fun onFinishInflate() {
        super.onFinishInflate()
        DaggerWaterTrackerViewComponent
            .builder()
            .applicationComponent(
                (context.applicationContext as WaterTrackerApplication).appComponent
            )
            .build()
            .inject(this)
        text = preferencesHelper.getWaterIntake().toString()
    }
}