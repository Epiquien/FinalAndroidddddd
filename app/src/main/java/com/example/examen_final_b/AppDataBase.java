package com.example.examen_final_b;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.examen_final_b.Clases.Pelicula;
import com.example.examen_final_b.Daos.PeliculaDao;

@Database(entities = {Pelicula.class}, version = 1)
public abstract  class AppDataBase extends RoomDatabase {
    public abstract PeliculaDao peliculaDao();
}
