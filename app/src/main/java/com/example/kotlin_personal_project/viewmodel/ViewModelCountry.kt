package com.example.kotlin_personal_project.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

sealed interface CountriesUIState {
    data class Success(val countries: List<Country>) : CountriesUIState
    data object Error : CountriesUIState
    data object Loading : CountriesUIState
}

class ViewModelCountry : ViewModel() {

    var countryUIState: CountriesUIState by mutableStateOf(CountriesUIState.Loading)
        private set

    init {
        getCountriesList()
    }

    private fun getCountriesList() {
        viewModelScope.launch {
            var countriesApi: CountriesApi? = null
            try {
                countriesApi = CountriesApi.getInstance()
                countryUIState = CountriesUIState.Success(countriesApi.getCountries())
            } catch (ex: Exception) {
                Log.d("TODOVIEWMODEL", ex.message.toString())
                countryUIState = CountriesUIState.Error
            }
        }
    }


}