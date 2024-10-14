package es.iesoretania.listviewpersonalizado;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import es.iesoretania.listviewpersonalizado.databinding.ActivityModulosBinding;

public class ActivityModulos extends AppCompatActivity {
    private ActivityModulosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityModulosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String ciclo = getIntent().getStringExtra("ciclo");
        int imageRes = getIntent().getIntExtra("imageRes", -1); // Cambiar a -1 para verificar si no se pasa imagen
        int backgroundColor = getIntent().getIntExtra("backgroundColor", -1); // Cambiar a -1 para verificar si no se pasa color

        if (imageRes != -1) {
            binding.imageViewModulo.setImageResource(imageRes);
        }

        if (backgroundColor != -1) {
            binding.mainLayout.setBackgroundColor(getResources().getColor(backgroundColor));
        }

        binding.textViewModulo.setText("Estás en el módulo de " + ciclo);
    }
}
