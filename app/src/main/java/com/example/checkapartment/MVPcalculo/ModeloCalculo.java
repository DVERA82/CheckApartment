package com.example.checkapartment.MVPcalculo;

public class ModeloCalculo {
    private int luces =0;
    private int dormitorio =0;
    private int cocina =0;
    private int banio =0;
    private int terminaciones;
    private int resultadoCalculo;

    public ModeloCalculo() {

    }

    public void calculoRevision(int luces, int dormitorio, int cocina, int banio, int terminaciones){
        int resultado = luces+dormitorio+cocina+banio;
        this.resultadoCalculo = resultado*terminaciones;
    }

    public ModeloCalculo(int luces, int dormitorio, int cocina, int banio, int terminaciones) {
        this.luces = luces;
        this.dormitorio= dormitorio;
        this.cocina = cocina;
        this.banio = banio;
        this.terminaciones = terminaciones;
    }

    public int getLuces() {
        return luces;
    }

    public int getDormitorio() {
        return dormitorio;
    }

    public int getCocina() {
        return cocina;
    }

    public int getBanio() {
        return banio;
    }

    public int getTerminaciones() {
        return terminaciones;
    }

    public void setLuces(int luces) {
        this.luces = luces;
    }

    public void setDormitorio(int dormitorio) {
        dormitorio = dormitorio;
    }

    public void setCocina(int cocina) {
        this.cocina = cocina;
    }

    public void setBanio(int banio) {
        this.banio = banio;
    }

    public void setTerminaciones(int terminaciones) {
        this.terminaciones = terminaciones;
    }
    public int getResultadoCalculo() {
        return this.resultadoCalculo;
    }

}
