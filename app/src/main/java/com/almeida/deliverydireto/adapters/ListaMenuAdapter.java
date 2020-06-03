package com.almeida.deliverydireto.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.almeida.deliverydireto.R;
import com.almeida.deliverydireto.models.MenuModel;

import java.util.ArrayList;

public class ListaMenuAdapter extends RecyclerView.Adapter<ListaMenuAdapter.ViewHolder> {

    private ArrayList<MenuModel> dataset;
    private Context context;

    public ListaMenuAdapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MenuModel m = dataset.get(position);
        holder.nameTextView.setText(m.name);

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<MenuModel> listaMenu) {
        dataset.addAll(listaMenu);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView descriptionTextView;
        private TextView priceTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            descriptionTextView = (TextView) itemView.findViewById(R.id.descriptionTextView);
            priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);
        }
    }
}
