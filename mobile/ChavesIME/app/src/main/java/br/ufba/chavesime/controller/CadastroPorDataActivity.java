package br.ufba.chavesime.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufba.chavesime.R;
import br.ufba.chavesime.model.Sala;

public class CadastroPorDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_por_data);

        Toolbar toolbar = (Toolbar) findViewById(R.id.cadastroPorDataToolbar);
        setSupportActionBar(toolbar);
        setTitle("Cadastro por Data");

        mostrarSalas();

    }

    private ArrayList<Sala> getSalas() {

        ArrayList<Sala> salaArrayList = new ArrayList<>();

        //TODO: Pegar todas as salas via web
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());
        salaArrayList.add(new Sala());

        return salaArrayList;

    }

    private void mostrarSalas() {

        ArrayList<Sala> salaArrayList = getSalas();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.cadastroPorDataRecyclerView);

        if (recyclerView != null) {

            SalaAdapter salaAdapter = new SalaAdapter(salaArrayList);

            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(salaAdapter);

        }


    }

    private class SalaAdapter extends RecyclerView.Adapter<SalaAdapter.SalaViewHolder> {

        private ArrayList<Sala> salaArrayList;

        public SalaAdapter(ArrayList<Sala> salaArrayList) {

            this.salaArrayList = salaArrayList;

        }

        @Override
        public SalaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);

            return new SalaViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(SalaViewHolder holder, int position) {

            // TODO: Popular card

        }

        @Override
        public int getItemCount() {
            return salaArrayList.size();
        }

        protected class SalaViewHolder extends RecyclerView.ViewHolder {

            private TextView numeroTextView;
            private TextView tipoTextView;
            private TextView capacidadeTextView;

            public SalaViewHolder(View itemView) {
                super(itemView);

                numeroTextView = (TextView) itemView.findViewById(R.id.cardSalaTextView);
                tipoTextView = (TextView) itemView.findViewById(R.id.cardTipoSalaTextView);
                capacidadeTextView = (TextView) itemView.findViewById(R.id.cardCapacidadeTextView);

            }
        }

    }

}
