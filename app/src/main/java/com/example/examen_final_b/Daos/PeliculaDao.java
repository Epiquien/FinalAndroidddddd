package com.example.examen_final_b.Daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.examen_final_b.Clases.Pelicula;

import java.util.List;

@Dao
public interface PeliculaDao {


    @Query("SELECT * FROM tablaPelicula")
    List<Pelicula> getAll();

    @Insert
    void create(Pelicula pelicula);
}
