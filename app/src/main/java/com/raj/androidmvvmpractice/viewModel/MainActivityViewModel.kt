package com.raj.androidmvvmpractice.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raj.androidmvvmpractice.repo.DataRepository
import com.raj.androidmvvmpractice.repo.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

    private val _names: MutableLiveData<ArrayList<String>> = MutableLiveData()
    val names: LiveData<ArrayList<String>> get() = _names

    init {
        _names.value = arrayListOf("Raj", "Tamil", "Uma")
    }

    fun getStockValues() {
        viewModelScope.launch {
            when (val response = dataRepository.getPortfolioData()) {
                is Result.Error -> TODO()
                is Result.Success -> _names.value = ArrayList(response.data.stocks.map { it.name })
            }
        }
    }


}