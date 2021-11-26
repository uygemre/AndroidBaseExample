package com.uygemre.core.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uygemre.core.networking.DataFetchResult
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

fun <T> PublishSubject<T>.toLiveData(compositeDisposable: CompositeDisposable): LiveData<T> {
    val data = MutableLiveData<T>()
    compositeDisposable.add(this.subscribe { t: T ->
        data.value = t
    })
    return data
}

fun <T> BehaviorSubject<T>.toLiveData(compositeDisposable:
                                     CompositeDisposable
): LiveData<T> {
    val data = MutableLiveData<T>()
    compositeDisposable.add(this.subscribe
    {
            t: T -> data.value = t
    })
    return data
}

fun <T> PublishSubject<DataFetchResult<T>>.failed(e: Throwable) {
    with(this){
        loading(false)
        onNext(DataFetchResult.failure(e))
    }
}

fun <T> PublishSubject<DataFetchResult<T>>.success(t: T) {
    with(this){
        loading(false)
        onNext(DataFetchResult.success(t))
    }
}


fun <T> PublishSubject<DataFetchResult<T>>.loading(isLoading: Boolean) {
    this.onNext(DataFetchResult.loading(isLoading))
}

fun <T> BehaviorSubject<DataFetchResult<T>>.failed(e: Throwable) {
    with(this){
        loading(false)
        onNext(DataFetchResult.failure(e))
    }
}

fun <T> BehaviorSubject<DataFetchResult<T>>.success(t: T) {
    with(this){
        loading(false)
        onNext(DataFetchResult.success(t))
    }
}


fun <T> BehaviorSubject<DataFetchResult<T>>.loading(isLoading: Boolean) {
    this.onNext(DataFetchResult.loading(isLoading))
}