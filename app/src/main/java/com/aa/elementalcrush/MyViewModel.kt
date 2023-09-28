package com.aa.elementalcrush

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//manage interactions between fragments and model
class MyViewModel : ViewModel() {
    //this property can be accessed by the fragments to set values to the Model
    val myLiveModel = MutableLiveData<MyModel>()
    //associating myLiveModel with the data in MyModel
    init {
        myLiveModel.value= MyModel()
    }
}