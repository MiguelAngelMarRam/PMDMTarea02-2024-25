package dam.pmdm.martinez_ramirez_miguel_angel_pmdm02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import dam.pmdm.martinez_ramirez_miguel_angel_pmdm02.databinding.CharacterCardviewBinding;
import android.view.View;

public class CharacterRecyclerViewAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private final ArrayList<CharacterData> characters;
    private final Context context;

    public CharacterRecyclerViewAdapter (ArrayList<CharacterData> characters, Context context){
        this.characters = characters;
        this.context = context;
    }

    // Método que crea el ViewHolder
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterCardviewBinding binding = CharacterCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );
        return new CharacterViewHolder(binding);
    }

    //    Método para enlazar datos con ek ViewHolder
    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterData currentCharacter = this.characters.get(position);
        holder.bind(currentCharacter);

//        Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(currentCharacter, view));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    private void itemClicked(CharacterData currentCharacter, View view) {
        // Llama a la función gameClicked de MainActivity, pasando la vista
        ((MainActivity) context).characterClicked(currentCharacter, view);
    }
}
