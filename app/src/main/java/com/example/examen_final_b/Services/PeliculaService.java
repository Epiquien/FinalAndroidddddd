package com.example.examen_final_b.Services;

import com.example.examen_final_b.Clases.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PeliculaService {

    @POST("N00022599")
    Call<Pelicula>createPelicula(@Body Pelicula pelicula);

    @GET("N00022599")
    Call<List<Pelicula>> allPeliculas();

}
