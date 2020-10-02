package co.joebirch.watertracker.di.component

import co.joebirch.watertracker.WaterTrackerActivity
import co.joebirch.watertracker.di.WaterTrackingModule
import co.joebirch.watertracker.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(
    modules = [WaterTrackingModule::class],
    dependencies = [ApplicationComponent::class]
)
interface WaterTrackerActivityComponent {

    @Component.Builder
    interface Builder {
        fun build(): WaterTrackerActivityComponent
        fun applicationComponent(module: ApplicationComponent): Builder
    }

    fun inject(activity: WaterTrackerActivity)

}