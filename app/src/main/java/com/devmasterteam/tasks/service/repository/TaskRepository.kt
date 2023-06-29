package com.devmasterteam.tasks.service.repository

import android.content.Context
import android.content.res.Resources
import android.os.Build
import androidx.annotation.RequiresApi
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.service.constants.TaskConstants
import com.devmasterteam.tasks.service.listener.APIListener
import com.devmasterteam.tasks.service.listener.TaskListener
import com.devmasterteam.tasks.service.model.TaskModel
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient
import com.devmasterteam.tasks.service.repository.remote.TaskService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskRepository(context: Context) : BaseRepository(context) {

    private val remote = RetrofitClient.getService(TaskService::class.java)

    @RequiresApi(Build.VERSION_CODES.M)
    fun list(listener: APIListener<List<TaskModel>>) {
        if (!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }
        executeCall(remote.list(), listener)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun listNext(listener: APIListener<List<TaskModel>>) {
        if (!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }
        executeCall(remote.listNext(), listener)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun listOverdue(listener: APIListener<List<TaskModel>>) {
        if (!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }
        executeCall(remote.listOverdue(), listener)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun load(id: Int, listener: APIListener<TaskModel>){
        if (!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }
        executeCall(remote.load(id), listener)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun create(task: TaskModel, listener: APIListener<Boolean>) {
        if (!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }
        executeCall(remote.create(task.priorityId, task.description, task.dueDate, task.complete), listener)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun update(task: TaskModel, listener: APIListener<Boolean>) {
        if (!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }
        executeCall(remote.update(task.id, task.priorityId, task.description, task.dueDate, task.complete), listener)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun delete(id: Int, listener: APIListener<Boolean>) {
        if (!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }
        executeCall(remote.delete(id), listener)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun complete(id: Int, listener: APIListener<Boolean>) {
        if (!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }
        executeCall(remote.complete(id), listener)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun undo(id: Int, listener: APIListener<Boolean>) {
        if (!isConnectionAvailable()){
            listener.onFailure(context.getString(R.string.ERROR_INTERNET_CONNECTION))
            return
        }
        executeCall(remote.undo(id), listener)
    }
}