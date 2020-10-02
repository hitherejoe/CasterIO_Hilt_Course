package co.joebirch.watertracker.di.component

import co.joebirch.watertracker.WaterCountTextView
import co.joebirch.watertracker.di.WaterTrackingModule
import co.joebirch.watertracker.di.scope.ViewScope
import dagger.Component

@ViewScope
@Component(
    modules = [WaterTrackingModule::class],
    dependencies = [ApplicationComponent::class]
)
interface WaterTrackerViewComponent {

    @Component.Builder
    interface Builder {
        fun build(): WaterTrackerViewComponent
        fun applicationComponent(module: ApplicationComponent): Builder
    }

    fun inject(view: WaterCountTextView)
}