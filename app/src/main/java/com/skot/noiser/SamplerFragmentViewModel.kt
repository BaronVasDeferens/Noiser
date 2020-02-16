package com.skot.noiser

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow

@ExperimentalCoroutinesApi
@FlowPreview
class SamplerFragmentViewModel: ViewModel() {

    data class SamplerState(val whatever: Unit)

    private val samplerStateChannel = ConflatedBroadcastChannel<SamplerState>()
    val samplerStateFlow = samplerStateChannel.asFlow()

    init {
        println(">>> NEW VIEWMODEL: $this")
        samplerStateChannel.offer(SamplerState(Unit))
    }

}