package com.dev_mahmoud_ashraf.baseapp.presentation.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dev_mahmoud_ashraf.baseapp.R
import com.dev_mahmoud_ashraf.baseapp.core.utils.Event
import com.dev_mahmoud_ashraf.baseapp.core.viewmodel.BaseAndroidViewModel
import com.dev_mahmoud_ashraf.baseapp.data.network.NetworkState
import com.dev_mahmoud_ashraf.baseapp.data.repositories.PostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

/**
 * Created by dev.mahmoud_ashraf on 12/16/2019.
 */
class HomeViewModel @Inject constructor(application: Application, private val jobsRepository: PostsRepository)
    : BaseAndroidViewModel(application) {
    private var isCached = false
    private val validatePostsState: MutableLiveData<Event<NetworkState>> = MutableLiveData()
    private val validatePostsResponseData: MutableLiveData<Any> = MutableLiveData()

    fun validatePostsStateLiveData(): LiveData<Event<NetworkState>> = validatePostsState
    fun validatePostsLiveData(): LiveData<Any> = validatePostsResponseData


    fun getPosts(){
        if (!isCached) {

            validatePostsState.postValue(Event(NetworkState.LOADING))
            viewModelScope.launch(Dispatchers.IO) {

                runCatching {
                    jobsRepository.getPosts()
                }.onSuccess { data ->
                    data.let {
                        validatePostsState.postValue(Event(NetworkState.LOADED))
                        validatePostsResponseData.postValue(it)
                    }
                }.onFailure { throwable ->
                    if (throwable is IOException) {
                        validatePostsState.postValue(
                            Event(
                                NetworkState.error(
                                    application.getString(
                                        R.string.need_internet
                                    )
                                )
                            )
                        )
                    } else
                        validatePostsState.postValue(
                            Event(
                                NetworkState.error(
                                    throwable.message
                                        ?: application.getString(R.string.something_wrong)
                                )
                            )
                        )
                }
            }

            isCached= true
        }
    }


    override fun onCleared() {
        super.onCleared()
        Timber.e("cleared! :(")
    }
}