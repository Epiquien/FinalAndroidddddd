package com.example.examen_final_b.Clases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tablaPelicula")
public class Pelicula {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "nombre")
        public  String nombre;

    @ColumnInfo(name = "vistas")
        public int vistas;

    @ColumnInfo(name = "fecha_de_estreno")
        public String fecha_de_estreno;

    @ColumnInfo(name = "tienda_1")
        public String tienda_1;

    @ColumnInfo(name = "tienda_2")
        public String tienda_2;

    @ColumnInfo(name = "tienda_3")
        public String tienda_3;

    @ColumnInfo(name = "imagen")
        public String imagen;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVistas() {
        return vistas;
    }

    public void setVistas(int vistas) {
        this.vistas = vistas;
    }

    public String getFecha_de_estreno() {
        return fecha_de_estreno;
    }

    public void setFecha_de_estreno(String fecha_de_estreno) {
        this.fecha_de_estreno = fecha_de_estreno;
    }

    public String getTienda_1() {
        return tienda_1;
    }

    public void setTienda_1(String tienda_1) {
        this.tienda_1 = tienda_1;
    }

    public String getTienda_2() {
        return tienda_2;
    }

    public void setTienda_2(String tienda_2) {
        this.tienda_2 = tienda_2;
    }

    public String getTienda_3() {
        return tienda_3;
    }

    public void setTienda_3(String tienda_3) {
        this.tienda_3 = tienda_3;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
