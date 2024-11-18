package dam.pmdm.martinez_ramirez_miguel_angel_pmdm02;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class SwitchActivity extends AppCompatActivity {

    private Switch languageSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_layout); // Asocia el XML del Switch

        // Referencia al Switch del layout
        languageSwitch = findViewById(R.id.languageSwitch);

        // Recuperar el estado del Switch desde SharedPreferences
        SharedPreferences prefs = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        boolean switchState = prefs.getBoolean("switch_state", false); // false es el valor por defecto

        // Establecer el estado del Switch
        languageSwitch.setChecked(switchState);

        // Lógica de cambiar el idioma al activar el Switch
        languageSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Guardar el nuevo estado
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("switch_state", isChecked);
            editor.apply();

            // Cambiar idioma
            if (isChecked) {
                actualizarIdioma("es");
                Toast.makeText(SwitchActivity.this, R.string.change_idioma, Toast.LENGTH_SHORT).show();
            } else {
                actualizarIdioma("en");
                Toast.makeText(SwitchActivity.this, R.string.change_idioma, Toast.LENGTH_SHORT).show();
            }

            // Regresar a MainActivity
            Intent intent = new Intent(SwitchActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finaliza la actividad actual para evitar volver atrás
        });

        // Botón de cancelar
        Button cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(v -> {
            // Regresar a MainActivity sin cambios
            Intent intent = new Intent(SwitchActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void actualizarIdioma(String idioma) {
        // Configurar el idioma de la aplicación
        Locale locale = new Locale(idioma);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);

        // Para compatibilidad con API modernas
        getBaseContext().createConfigurationContext(config);

        // Opción de refuerzo
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}
