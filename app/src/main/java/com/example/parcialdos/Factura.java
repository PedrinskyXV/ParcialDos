package com.example.parcialdos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Factura {
    @PrimaryKey(autoGenerate = true)
    int registro;
    String nFactura;
    String fecha;
    String tipoCombustible;
    Float monto;

    public Factura(String nFactura, String fecha, String tipoCombustible, Float monto) {
        this.nFactura = nFactura;
        this.fecha = fecha;
        this.tipoCombustible = tipoCombustible;
        this.monto = monto;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getnFactura() {
        return nFactura;
    }

    public void setnFactura(String nFactura) {
        this.nFactura = nFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }
}
