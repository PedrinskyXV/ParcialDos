package com.example.parcialdos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoPunto {
   @Query("SELECT * FROM Punto")
    List<Punto> getAll();

   @Insert
    Long insertPu(Punto pu);

   @Update
    void updatePu(Punto pu);

   @Delete
    int deletePu(Punto pu);

   @Query("UPDATE Punto set punto = (:punto + punto) WHERE idPunto = 1")
    void sumarPuntos(int punto);

    @Query("UPDATE Punto set punto = (punto - :puntoAn) WHERE idPunto = 1")
    void restarPuntos(int puntoAn);
}
