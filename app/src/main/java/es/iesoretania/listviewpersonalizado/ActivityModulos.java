package es.iesoretania.listviewpersonalizado;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iesoretania.listviewpersonalizado.databinding.ActivityMainBinding;
import es.iesoretania.listviewpersonalizado.databinding.ActivityModulosBinding;

public class ActivityModulos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modulos); // Asegúrate de que este layout tenga los IDs correctos

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializa los elementos de la vista
        ImageView imageView = findViewById(R.id.imageView); // Asegúrate de que este ID coincida con tu layout
        TextView textViewNombre = findViewById(R.id.textViewNombre);
        TextView textViewApellidos = findViewById(R.id.textViewApellidos);
        TextView textViewCiclo = findViewById(R.id.textViewModulo);
        // Obtener datos del Intent
        String nombre = getIntent().getStringExtra("nombre");
        String apellidos = getIntent().getStringExtra("apellidos");
        String ciclo = getIntent().getStringExtra("ciclo");
        String sexo = getIntent().getStringExtra("sexo"); // Asegúrate de enviar el sexo desde MainActivity

        // Mostrar la información en los TextView
        textViewNombre.setText(nombre);
        textViewApellidos.setText(apellidos);
        textViewCiclo.setText(ciclo);

        // Cargar el avatar según el sexo
        if (sexo != null) {
            if (sexo.equals("Masculino")) {
                imageView.setImageResource(R.drawable.avatar_hombre); // Reemplaza con tu imagen
            } else {
                imageView.setImageResource(R.drawable.avatar_mujer); // Reemplaza con tu imagen
            }
        }
    }
}
