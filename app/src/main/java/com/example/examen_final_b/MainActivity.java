package com.example.examen_final_b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.examen_final_b.Clases.Pelicula;
import com.example.examen_final_b.Services.PeliculaService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button btnRegistrarPeli = findViewById(R.id.btnRegistrarPelicula);
        Button btnSincronizarSqlLite= findViewById(R.id.btnSincronizar);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/peliculas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PeliculaService service =retrofit.create(PeliculaService.class);

        AppDataBase db = Room.databaseBuilder(this,
                AppDataBase.class, "tablaPelicula")
                .allowMainThreadQueries()
                .build();


        btnSincronizarSqlLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                service.allPeliculas().enqueue(new Callback<List<Pelicula>>() {
                @Override
                public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                Pelicula pelicula = new Pelicula();
                db.peliculaDao().create(pelicula);
                    Log.i("Main_APP" , new Gson().toJson(pelicula));
                }

                @Override
                public void onFailure(Call<List<Pelicula>> call, Throwable t) {

                }
            });

            }
        });



        btnRegistrarPeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), RegistroPelicula.class);
                startActivity(intent);
            }
        });


    }
}