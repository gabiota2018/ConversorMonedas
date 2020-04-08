package com.example.conversormonedas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;



public class MainViewModel  extends ViewModel {
    private MutableLiveData<String> resultado;
    private MutableLiveData<Boolean> dolarEuro;
    private MutableLiveData<Boolean> euroDolar;

    public LiveData<String> getResultado(){
        if(resultado==null) {
            resultado= new MutableLiveData<String>();
        }
        return resultado;
    }
    public LiveData<Boolean> getDolarEuro(){
        if(resultado==null) {
            dolarEuro= new MutableLiveData<Boolean>();
        }
        return dolarEuro;
    }
    public LiveData<Boolean> getEuroDolar() {
        if (resultado == null) {
            euroDolar = new MutableLiveData<Boolean>();
        }
        return euroDolar;
    }

    public void hacerCalculo(String dolar,String euro){
        double total=0;
        double monto=0;

        if(!dolar.toString().equals(""))
        {
            monto=Double.parseDouble(dolar.toString());
            total=monto*0.92;
            resultado.setValue(total+"");
        }
        else if(!euro.toString().equals(""))
        { monto=Double.parseDouble(euro.toString());
            total=monto*1.09;
            resultado.setValue(total+"");
        }

    }

}
