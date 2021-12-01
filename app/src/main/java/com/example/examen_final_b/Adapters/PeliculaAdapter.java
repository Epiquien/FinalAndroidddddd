package com.example.examen_final_b.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_final_b.Clases.Pelicula;
import com.example.examen_final_b.R;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PalabraViewHolder>{
    List<Pelicula> peliculas;

    public PeliculaAdapter(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public PalabraViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ver_peliculas, parent, false);
        return new PalabraViewHolder(view);
    }

    @Override
    public void onBindViewHolder( PeliculaAdapter.PalabraViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PalabraViewHolder extends RecyclerView.ViewHolder{

        public PalabraViewHolder( View itemView) {
            super(itemView);
        }
    }
}
