package com.example.examen_final_b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.examen_final_b.Clases.Pelicula;
import com.example.examen_final_b.Services.PeliculaService;
import com.google.gson.Gson;

import java.util.prefs.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroPelicula extends AppCompatActivity {

    EditText EtNombrePeli;
    EditText EtVistasPeli;
    EditText EtTiendaUno;
    EditText EtTiendaDos;
    EditText EtTiendaTres;
    ImageView ImgPeli;

    Button btnRegistrarPeli;
    Button btnAbrirCamara;
    Button btnAbrirGaleria;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pelicula);

     //  sharedPreferences = getSharedPreferences(Preferences.SHARED_PREFERENCES_KEY, MODE_PRIVATE);


        EtNombrePeli = findViewById(R.id.etNombrePelicula);
        EtVistasPeli= findViewById(R.id.etVistasPelicula);
        EtTiendaUno = findViewById(R.id.etTiendaUno);
        EtTiendaDos= findViewById(R.id.etTiendaDos);
        EtTiendaTres = findViewById(R.id.etTiendaTres);
        ImgPeli = findViewById(R.id.imgPelicula);

        btnRegistrarPeli= findViewById(R.id.btnRegistrarPelicula);
        btnAbrirCamara = findViewById(R.id.btnImagenCamara);
        btnAbrirGaleria = findViewById(R.id.btnImagenGaleria);




        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/peliculas/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PeliculaService service =retrofit.create(PeliculaService.class);


        btnRegistrarPeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Pelicula pelicula = new Pelicula();

            pelicula.setNombre(EtNombrePeli.getText().toString());
            pelicula.setVistas(EtVistasPeli.getInputType());
            pelicula.setTienda_1(EtTiendaUno.getText().toString());
            pelicula.setTienda_2(EtTiendaDos.getText().toString());
            pelicula.setTienda_3(EtTiendaTres.getText().toString());


            service.createPelicula(pelicula).enqueue(new Callback<Pelicula>() {
                @Override
                public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                    Log.i("MAIN_APP",  new Gson().toJson( response.code()));
                }

                @Override
                public void onFailure(Call<Pelicula> call, Throwable t) {
                    Log.i("MAIN_APP",  "No se pudo estabecer conexion");
                }
            });
            }
        });



    }
}