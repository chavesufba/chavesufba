package br.ufba.chavesime;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

import br.ufba.chavesime.controller.HomeActivity;

public class ReservarSalaActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_sala);
        setTitle(getResources().getText(R.string.titleReservarSala));

        initDropDownHorarios();
        initDateText();

        Toolbar toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            //TODO: Seta de voltar estar escura, corrigir!
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Inicializa e Seta as strings do dropDown de Horários
     */
    public void initDropDownHorarios() {
        // Preenchimento do DropDown de Horários
        Spinner spinner = (Spinner) findViewById(R.id.ddownHorario);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.horarios_array,R.layout.spinner);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


    /**
     * Inicializa o campo texto de data com a data do dia
     */
    public void initDateText() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);


        String today;
        today =  (day < 10)     ? "0" + day + "/"             : "" + day + "/";
        today += (month < 10)   ? "0" + month + "/" + year    : "" + month + "/" + year ;

        EditText textDate = (EditText) findViewById(R.id.editTextData);
        textDate.setText(today);
    }


    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putString("Class", "ReservarSala");
        newFragment.setArguments(args);
        newFragment.show(getFragmentManager(), "datePicker");
    }


    /**
     * Função de retorno do Date Picker usado na seleção de data, retorna os valores
     * que são setados no campo de texto não editável
     * @param view
     * @param year
     * @param month
     * @param day
     */
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user

        month++;

        /* Acrescenta o 0 em dia ou mês, caso eles sejam menores que 10
                para que haja um padrão na exibição da data.
         */

        String today;
        today =  (day < 10)     ? "0" + day + "/"             : "" + day + "/";
        today += (month < 10)   ? "0" + month + "/" + year    : "" + month + "/" + year ;

        EditText textDate = (EditText) findViewById(R.id.editTextData);
        textDate.setText(today);
    }

    public void botaoConfirmarReserva(View botao) {

        if (true) {

            //TODO: Pegar os dados necessários, e chamar a função de confirmar reserva da API

            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("user", "Teste");
            startActivity(intent);
        }
        else {

        }

    }
}