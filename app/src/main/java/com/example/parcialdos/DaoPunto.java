package com.example.parcialdos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoPunto {
   @Query("Select * from punto")
    List<Punto> getAll();
    /*@Query("select count(*) from punto where idPunto like :idPunto") no furula xd
    Punto findByName(int idPunto);*/
   @Insert
    Long insertPu(Punto pu);
   @Update
    void updatePu(Punto pu);
   @Delete
    int deletePu(Punto pu);
}
