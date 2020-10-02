package co.joebirch.watertracker

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.joebirch.watertracker.di.WaterTrackingModule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@UninstallModules(WaterTrackingModule::class)
@RunWith(AndroidJUnit4::class)
class WaterTrackertest {

    @get:Rule val hiltRule = HiltAndroidRule(this)

    @BindValue
    @JvmField val preferencesHelper = mock<PreferencesHelper>()

    @Before fun init() = hiltRule.inject()

    @Test
    fun waterCountDisplays() {
        val waterIntake = 5

        whenever(preferencesHelper.getWaterIntake())
            .doReturn(waterIntake)

        ActivityScenario.launch(WaterTrackerActivity::class.java)

        onView(withId(R.id.waterCountText))
            .check(matches(withText(waterIntake.toString())))
    }

}