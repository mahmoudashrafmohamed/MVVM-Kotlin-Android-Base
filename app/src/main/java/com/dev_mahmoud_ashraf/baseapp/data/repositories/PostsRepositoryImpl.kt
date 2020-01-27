package com.dev_mahmoud_ashraf.baseapp.data.repositories

import com.dev_mahmoud_ashraf.baseapp.data.daos.RemoteServiceDao
import com.dev_mahmoud_ashraf.baseapp.data.models.JobsResopnse
import com.dev_mahmoud_ashraf.baseapp.data.models.PostsResponse
import javax.inject.Inject

/**
 * Created by dev.mahmoud_ashraf on 12/11/2019.
 */
class PostsRepositoryImpl @Inject constructor(private val remoteJobsDao: RemoteServiceDao) : PostsRepository {
    override suspend fun getPosts(): List<PostsResponse> {
           return remoteJobsDao.posts()
    }

    override suspend fun getRemoteJobs(): JobsResopnse {
        val jobs = remoteJobsDao.getAllJobs()
       // localJobsDao.insert(jobs.jobs)
        return jobs
    }

    override suspend fun getLocalJobs(): JobsResopnse {
        return JobsResopnse()
    }
}