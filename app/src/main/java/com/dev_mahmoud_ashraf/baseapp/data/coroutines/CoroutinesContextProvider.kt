package com.dev_mahmoud_ashraf.baseapp.data.coroutines

import kotlin.coroutines.CoroutineContext

/**
 * Created by dev.mahmoud_ashraf on 12/10/2019.
 */

interface CoroutinesContextProvider {

    val main: CoroutineContext

    val io: CoroutineContext
}