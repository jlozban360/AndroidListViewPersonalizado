package es.iesoretania.listviewpersonalizado;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import es.iesoretania.listviewpersonalizado.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ListView listViewSimple;
    private List<Personas> personasList = new ArrayList<>(); // Cambiado a List<Personas>
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewSimple = binding.listViewPersonas;

        personasList.add(new Personas("Juan", "Pérez", "Masculino", "DAM"));
        personasList.add(new Personas("Ana", "García", "Femenino", "DAW"));
        personasList.add(new Personas("Jose", "Lozano", "Masculino", "ASIR"));

        ArrayAdapter<Personas> adapter = new ArrayAdapter<Personas>(this, 0, personasList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.item_persona, parent, false);
                }

                ImageView imageViewAvatar = convertView.findViewById(R.id.imageView);
                TextView textViewNombre = convertView.findViewById(R.id.textViewNombre);
                TextView textViewApellidos = convertView.findViewById(R.id.textViewApellidos);
                TextView textViewCiclo = convertView.findViewById(R.id.textViewModulo); // Asegúrate de que este ID coincida

                Personas persona = getItem(position);

                if (persona != null) {
                    textViewNombre.setText(persona.getNombre());
                    textViewApellidos.setText(persona.getApellidos());
                    textViewCiclo.setText(persona.getCiclo());

                    if(persona.getSexo().equals("Masculino"))
                        imageViewAvatar.setImageResource(R.drawable.avatar_hombre);
                    else
                        imageViewAvatar.setImageResource(R.drawable.avatar_mujer);
                }

                return convertView;
            }
        };

        listViewSimple.setAdapter(adapter);

        listViewSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Personas persona = personasList.get(position);
                Intent intent = new Intent(MainActivity.this, ActivityModulos.class);
                intent.putExtra("nombre", persona.getNombre());
                intent.putExtra("apellidos", persona.getApellidos());
                intent.putExtra("ciclo", persona.getCiclo());
                startActivity(intent);
            }
        });
    }
}
