package com.example.parcialdos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
//hacerle select count(*) from punto where idPunto=1 si mayor que cero update xd;
@Entity
public class Punto {
    @PrimaryKey(autoGenerate = true)
    int idPunto;
    int punto;

    public Punto(int punto) {
        this.punto = punto;
    }

    public int getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(int idPunto) {
        this.idPunto = idPunto;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }
}
