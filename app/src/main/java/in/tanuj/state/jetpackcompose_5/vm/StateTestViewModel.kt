package `in`.tanuj.state.jetpackcompose_5.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateTestViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    var name: LiveData<String> = _name

    fun onNameUpdate(onName: String) {
        _name.value = onName
    }

}