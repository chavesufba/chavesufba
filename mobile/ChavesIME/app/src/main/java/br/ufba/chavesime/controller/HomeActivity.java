package br.ufba.chavesime.controller;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufba.chavesime.R;
import br.ufba.chavesime.ReservarSalaActivity;
import br.ufba.chavesime.model.MainActivity;
import br.ufba.chavesime.model.Sala;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addMenu();
        mostrarSalas();

    }

    /**
     * Adiciona um menu no canto esquerdo da tela, assim como um botão que abre o menu
     */
    private void addMenu() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

            drawerLayout = (DrawerLayout) findViewById(R.id.menuDrawerLayout);

        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.menuRecyclerView);

        if (recyclerView != null) {

            String[] menuItemsList = getResources().getStringArray(R.array.menuItemsArray);
            List<Drawable> menuDrawablesList = new ArrayList<>();

            for (String string: getResources().getStringArray(R.array.menuDrawablesArray)) {

                menuDrawablesList.add(ContextCompat.getDrawable(getApplicationContext(), (getResources().getIdentifier(string, "drawable", getPackageName()))));

            }

            MenuAdapter menuAdapter = new MenuAdapter(menuItemsList, menuDrawablesList);

            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(menuAdapter);
        }


    }

    private void mostrarSalas() {

        ArrayList<Sala> salaArrayList = getSalas();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.homeRecyclerView);

        if (recyclerView != null) {

            SalaAdapter salaAdapter = new SalaAdapter(salaArrayList);

            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(salaAdapter);

        }


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        drawerLayout.openDrawer(GravityCompat.START);

        return super.onOptionsItemSelected(item);
    }

    /**
     * Classe do adaptador do menu
     */
    private class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuItemViewHolder> {

        String[] menuItemsList;
        List<Drawable> menuDrawablesList;

        private MenuAdapter(String[] menuItemsList, List<Drawable> menuDrawablesList) {

            this.menuItemsList = menuItemsList;
            this.menuDrawablesList = menuDrawablesList;

        }

        @Override
        public MenuItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);

            return new MenuItemViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(MenuItemViewHolder holder, int position) {

            holder.menuItemImageView.setImageDrawable(menuDrawablesList.get(position));

            int color = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
            holder.menuItemImageView.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);

            holder.menuItemTextView.setText(menuItemsList[position]);

        }

        @Override
        public int getItemCount() {
            return menuItemsList.length;
        }

        class MenuItemViewHolder extends RecyclerView.ViewHolder {

            private ImageView menuItemImageView;
            private TextView menuItemTextView;

            private MenuItemViewHolder(View itemView) {
                super(itemView);

                menuItemImageView = (ImageView) itemView.findViewById(R.id.menuItemImageView);
                menuItemTextView = (TextView) itemView.findViewById(R.id.menuItemTextView);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String item = menuItemsList[getAdapterPosition()];
                        Intent intent;

                        switch (item) {
                            case "Home":

                                drawerLayout.closeDrawer(GravityCompat.START);

                                break;
                            case "Reservar":

                                drawerLayout.closeDrawer(GravityCompat.START);
                                intent = new Intent(getApplicationContext(), ReservarPorDataActivity.class);
                                startActivity(intent);

                                break;
                            case "Cronograma":

                                drawerLayout.closeDrawer(GravityCompat.START);
                                intent = new Intent(getApplicationContext(), CronogramaActivity.class);
                                startActivity(intent);
                                break;

                            case "Passar Chave":

                                drawerLayout.closeDrawer(GravityCompat.START);
                                intent = new Intent(getApplicationContext(), PassarChaveActivity.class);
                                startActivity(intent);
                                break;

                            case "Exemplo de Requisição":

                                intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            case "Sair":

                                drawerLayout.closeDrawer(GravityCompat.START);
                                logoutUser();

                                break;
                        }
                    }
                });

            }
        }

    }

    /**
     * Efetua logout
     */
    private void logoutUser() {

        // TODO: Efetuar logout
        finish();

    }


    private class SalaAdapter extends RecyclerView.Adapter<SalaAdapter.SalaViewHolder> {

        private ArrayList<Sala> salaArrayList;

        SalaAdapter(ArrayList<Sala> salaArrayList) {

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
            holder.tipoImageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), position % 2 == 0 ? R.drawable.lab_icon : R.drawable.sala_de_aula_icon));
            holder.statusImageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), position % 2 == 0 ? R.drawable.circulo_verde : R.drawable.circulo_vermelho));
            holder.statusTextView.setText(position % 2 == 0 ? R.string.disponivel : R.string.ocupada);

        }

        @Override
        public int getItemCount() {
            return salaArrayList.size();
        }

        class SalaViewHolder extends RecyclerView.ViewHolder {

            private TextView numeroTextView;
            private ImageView tipoImageView;
            private TextView capacidadeTextView;
            private ImageView statusImageView;
            private TextView statusTextView;

            SalaViewHolder(View itemView) {
                super(itemView);

                numeroTextView = (TextView) itemView.findViewById(R.id.cardSalaTextView);
                tipoImageView = (ImageView) itemView.findViewById(R.id.cardTipoSalaImageView);
                capacidadeTextView = (TextView) itemView.findViewById(R.id.cardCapacidadeTextView);
                statusTextView = (TextView) itemView.findViewById(R.id.card_statusTextView);
                statusImageView = (ImageView) itemView.findViewById(R.id.card_statusImageView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(), ReservarSalaActivity.class);
                        startActivity(intent);

                    }
                });
            }
        }

    }


}


