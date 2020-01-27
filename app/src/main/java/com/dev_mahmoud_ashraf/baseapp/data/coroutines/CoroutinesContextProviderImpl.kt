package com.dev_mahmoud_ashraf.baseapp.data.coroutines

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */

class CoroutinesContextProviderImpl : CoroutinesContextProvider {

    override val main: CoroutineContext
        get() = Dispatchers.Main

    override val io: CoroutineContext
        get() = Dispatchers.IO
}