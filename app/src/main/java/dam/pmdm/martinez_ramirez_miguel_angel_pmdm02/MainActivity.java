package dam.pmdm.martinez_ramirez_miguel_angel_pmdm02;

import static dam.pmdm.martinez_ramirez_miguel_angel_pmdm02.R.layout.switch_layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.content.res.Resources;

import com.google.android.material.snackbar.Snackbar;


import java.util.Locale;

import dam.pmdm.martinez_ramirez_miguel_angel_pmdm02.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Cargar el idioma guardado antes de establecer el contenido
        SharedPreferences prefs = getSharedPreferences("AppPreferences", MODE_PRIVATE);
        boolean switchState = prefs.getBoolean("switch_state", false);
        String idioma = switchState ? "es" : "en";
        configurarIdioma(idioma);

        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configurar NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);
    }

    private void configurarIdioma(String idioma) {
        Locale locale = new Locale(idioma);
        Locale.setDefault(locale);
        Configuration configuracion = getResources().getConfiguration();
        configuracion.setLocale(locale);
        getBaseContext().getResources().updateConfiguration(configuracion, getBaseContext().getResources().getDisplayMetrics());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // Método para las acciones al hacer clic en las diferentes opciones al hacer clic en el menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_acerca_de) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.about) // Título del Dialog
                    .setMessage(R.string.about_text) // Mensaje
                    .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                        // Acción al hacer clic en "OK"
                        dialog.dismiss(); // Cierra el diálogo
                    })
                    .show();
            return true;
        }
        if (item.getItemId() == R.id.nav_home) {
            navController.navigate(R.id.characterListFragment);
            return true;
        }
        if (item.getItemId() == R.id.action_language) {
            Intent intent = new Intent(this, SwitchActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Método para manejar el clic en un personaje
    public void characterClicked(CharacterData character, View view) {
        // Crear un Bundle para pasar los datos al PersonajesDetailFragment
        Bundle bundle = new Bundle();

        // Convertir los recursos int a String antes de añadirlos al Bundle
        bundle.putString("name", getResources().getString(character.getName()));
        bundle.putString("skills", getResources().getString(character.getSkills()));
        bundle.putInt("image", character.getImage()); // Pasa la imagen del personaje
        bundle.putString("description", getResources().getString(character.getDescription()));

        Toast.makeText(this,
                getString(R.string.character_selected) + " " + getResources().getString(character.getName()),
                Toast.LENGTH_SHORT
        ).show();
        // Navegar al GameDetailFragment con el Bundle
        Navigation.findNavController(view).navigate(R.id.characterDetailFragment, bundle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}
