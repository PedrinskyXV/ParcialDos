package com.example.parcialdos;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Factura.class,Punto.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DaoFactura daoFactura();
    public abstract  DaoPunto daoPunto();
}
