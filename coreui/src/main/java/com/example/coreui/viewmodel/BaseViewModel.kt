package com.example.coreui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<Event : EventUi, State : StateUi, Effect : EffectUi> : ViewModel() {

    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state

    private val _effect = MutableSharedFlow<Effect>()
    val effect: SharedFlow<Effect> = _effect

    abstract fun handleEvent(event: Event)

    protected fun setState(state: State) {
        _state.value = state
    }

    protected suspend fun setEffect(effect: Effect) {
        _effect.emit(effect)
    }
}