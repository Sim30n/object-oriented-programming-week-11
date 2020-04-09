package com.example.week_11;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<CharSequence> text = new MutableLiveData<>();
    private MutableLiveData<CharSequence> tVari = new MutableLiveData<>();
    private MutableLiveData<Integer> gravity = new MutableLiveData<>();
    private MutableLiveData<Integer> tKoko = new MutableLiveData<>();
    private MutableLiveData<CharSequence> tausta = new MutableLiveData<>();

    public void setText(CharSequence input){
        text.setValue(input);
    }

    public void setGravity(Integer input){
        gravity.setValue(input);
    }

    public void settVari(CharSequence input) {
        tVari.setValue(input);
    }

    public void settKoko(Integer input){
        tKoko.setValue(input);
    }

    public void setTausta(CharSequence input){
        tausta.setValue(input);
    }

    public LiveData<CharSequence> getText(){
        return text;
    }

    public LiveData<CharSequence> getVari() { return tVari;}

    public LiveData<Integer> getKoko(){return tKoko;}

    public LiveData<Integer> getGravity(){return gravity;}

    public LiveData<CharSequence> getTausta(){return tausta;}
}
