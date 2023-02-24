package com.example.coreui.viewmodel

class TestViewModel() :
    BaseViewModel<TestContract.Event, TestContract.State, TestContract.Effect>() {
    override fun createInitialState(): TestContract.State {
        TODO("Not yet implemented")
    }

    override fun handleEvent(event: TestContract.Event) {
        TODO("Not yet implemented")
    }
}

object TestContract {
    interface Effect : EffectUi

    interface Event : EventUi

    interface State : StateUi
}
