package com.example.checkapartment.MVPloging;

public class Presentador {
    private ILoging iLoging;
    private ModeloLoging modeloLoging;
    public Presentador(ILoging iLoging){
        this.iLoging = iLoging;
        this.modeloLoging = new ModeloLoging();
    }
   public void validarPassword(String password){
        modeloLoging.validarPassword(password);
   }

    public String mensajeLoging(){
        return modeloLoging.getMensaje();

    }

    public int contadorLoging(){
        return modeloLoging.getContador();

    }
}
