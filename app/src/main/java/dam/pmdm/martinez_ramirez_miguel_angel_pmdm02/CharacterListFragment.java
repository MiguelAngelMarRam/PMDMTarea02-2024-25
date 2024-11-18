package dam.pmdm.martinez_ramirez_miguel_angel_pmdm02;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import dam.pmdm.martinez_ramirez_miguel_angel_pmdm02.databinding.CharacterListFragmentBinding;

import java.util.ArrayList;

public class CharacterListFragment extends Fragment {

    private CharacterListFragmentBinding binding; // Binding para el layout
    private ArrayList<CharacterData> characters; // Lista de personajes
    private CharacterRecyclerViewAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = CharacterListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        loadCharacters(); // Cargar los personajes (puedes implementar esta función para obtener datos)

        // Configurar el RecyclerView
        adapter = new CharacterRecyclerViewAdapter(characters, getActivity());
        binding.charactersRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.charactersRecyclerview.setAdapter(adapter);

        // Mostrar el Snackbar de bienvenida
        Snackbar.make(view, R.string.bienvenida, Snackbar.LENGTH_SHORT).show();

    }

    // Método para cargar personajes
    private void loadCharacters() {
        characters = new ArrayList<CharacterData>();

        characters.add(new CharacterData(
                R.drawable.mario,
                R.string.mario_name,
                R.string.mario_description,
                R.string.mario_skills
        ));

        characters.add(new CharacterData(
                R.drawable.luigi,
                R.string.luigi_name,
                R.string.luigi_description,
                R.string.luigi_skills
        ));

        characters.add(new CharacterData(
                R.drawable.peach,
                R.string.peach_name,
                R.string.peach_description,
                R.string.peach_skills
        ));

        characters.add(new CharacterData(
                R.drawable.toad,
                R.string.toad_name,
                R.string.toad_description,
                R.string.toad_skills
        ));

        characters.add(new CharacterData(
                R.drawable.bowser,
                R.string.bowser_name,
                R.string.bowser_description,
                R.string.bowser_skills
        ));

        characters.add(new CharacterData(
                R.drawable.yoshi,
                R.string.yoshi_name,
                R.string.yoshi_description,
                R.string.yoshi_skills
        ));

        characters.add(new CharacterData(
                R.drawable.daisy,
                R.string.daisy_name,
                R.string.daisy_description,
                R.string.daisy_skills
        ));

        characters.add(new CharacterData(
                R.drawable.wario,
                R.string.wario_name,
                R.string.wario_description,
                R.string.wario_skills
        ));

        characters.add(new CharacterData(
                R.drawable.waluigi,
                R.string.waluigi_name,
                R.string.waluigi_description,
                R.string.waluigi_skills
        ));

        characters.add(new CharacterData(
                R.drawable.rosalina,
                R.string.rosalina_name,
                R.string.rosalina_description,
                R.string.rosalina_skills
        ));

        characters.add(new CharacterData(
                R.drawable.bowser_jr,
                R.string.bowser_jr_name,
                R.string.bowser_jr_description,
                R.string.bowser_jr_skills
        ));

        characters.add(new CharacterData(
                R.drawable.boo,
                R.string.boo_name,
                R.string.boo_description,
                R.string.boo_skills
        ));

        characters.add(new CharacterData(
                R.drawable.donkey_kong,
                R.string.donkey_kong_name,
                R.string.donkey_kong_description,
                R.string.donkey_kong_skills
        ));

        characters.add(new CharacterData(
                R.drawable.diddy_kong,
                R.string.diddy_kong_name,
                R.string.diddy_kong_description,
                R.string.diddy_kong_skills
        ));
    }



    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.character_list);
        }
    }
}