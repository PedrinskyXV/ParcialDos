package com.example.parcialdos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoFactura {
    @Query("select * from factura")
    List<Factura> getAll();

    @Query("SELECT SUM(monto) as Puntos FROM factura")
    Factura cargarPuntos();

    @Insert
    Long insertFact(Factura fac);
    @Update
    void updateFact(Factura fac);
    @Delete
    int deleteFact(Factura fac);
}
