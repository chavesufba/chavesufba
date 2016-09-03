package br.ufba.chavesime;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addMenu();

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

        public MenuAdapter(String[] menuItemsList, List<Drawable> menuDrawablesList) {

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
            holder.menuItemTextView.setText(menuItemsList[position]);

        }

        @Override
        public int getItemCount() {
            return menuItemsList.length;
        }

        protected class MenuItemViewHolder extends RecyclerView.ViewHolder {

            private ImageView menuItemImageView;
            private TextView menuItemTextView;

            public MenuItemViewHolder(View itemView) {
                super(itemView);

                menuItemImageView = (ImageView) itemView.findViewById(R.id.menuItemImageView);
                menuItemTextView = (TextView) itemView.findViewById(R.id.menuItemTextView);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        String item = menuItemsList[getAdapterPosition()];

                        switch (item) {
                            case "Salas":

                                drawerLayout.closeDrawer(GravityCompat.START);

                                break;
                            case "Item 2":

                                // TODO: menu 1

                                break;
                            case "Item 3":

                                // TODO: menu 2

                                break;
                            case "Sair":

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


}


