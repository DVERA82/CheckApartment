package com.example.checkapartment.MVPloging;

public class ModeloLoging {
    private String password = "123Pass";
    private String mensaje;
    private int contador =0;



    public  void validarPassword(String clave){
        if (password != clave){
            mensaje = "Password Incorrecto";
            contador ++;
        }
        else{
            mensaje = "Validado";
            contador = 0;
        }

    }
    public String getMensaje() {
        return mensaje;
    }

    public int getContador() {
        return contador;
    }
}

