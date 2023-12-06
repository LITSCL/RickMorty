package cl.inacap.rickmorty.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.inacap.rickmorty.R;
import cl.inacap.rickmorty.dto.Personaje;

public class PersonajeAdapter extends ArrayAdapter<Personaje> {
    private List<Personaje> personajes;
    private Activity activity;

    public PersonajeAdapter(@NonNull Activity context, int resource, @NonNull List<Personaje> objects) {
        super(context, resource, objects);
        this.personajes = objects;
        this.activity = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.list_personajes, null, true);
        TextView nombreTv = fila.findViewById(R.id.nombreTv);
        ImageView imagenPersonajeIv = fila.findViewById(R.id.imagenPersonajeIv);
        nombreTv.setText(personajes.get(position).getName());
        Picasso.get().load(this.personajes.get(position).getImage()).resize(300, 300).centerCrop().into(imagenPersonajeIv);
        return fila;
    }
}
