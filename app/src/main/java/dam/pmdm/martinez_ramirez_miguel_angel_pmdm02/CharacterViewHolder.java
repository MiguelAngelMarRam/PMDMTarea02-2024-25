package dam.pmdm.martinez_ramirez_miguel_angel_pmdm02;

import androidx.recyclerview.widget.RecyclerView;

import dam.pmdm.martinez_ramirez_miguel_angel_pmdm02.databinding.CharacterCardviewBinding;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final CharacterCardviewBinding binding;

    public CharacterViewHolder(CharacterCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (CharacterData character){
        binding.image.setImageResource(character.getImage()); // Carga la imagen desde recurso
        binding.name.setText(character.getName()); // Carga el nombre desde recurso
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}
