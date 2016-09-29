package br.ufba.chavesime.controller;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.ufba.chavesime.R;
import br.ufba.chavesime.abstrato.DateAndTimeActivities;
import br.ufba.chavesime.fragments.DatePicker;
import br.ufba.chavesime.fragments.TimePicker;
import br.ufba.chavesime.model.Init;


public class ReservarSalaActivity extends DateAndTimeActivities {

    private EditText etHorEntrada;
    private EditText etHorSaida;
    boolean isEditTextEntrada = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_sala);
        setTitle(getResources().getText(R.string.titleReservarSala));

        Init.dateText((EditText) findViewById(R.id.reservaETData));
        Init.timeText((EditText) findViewById(R.id.reservaETHorarioEntrada));
        Init.timeText((EditText) findViewById(R.id.reservaETHorarioSaida));

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
     * Classe que chama o fragmento de data;
     * @param v
     */
    public void showDatePickerDialog(View v) {
        Bundle args = new Bundle();
        DialogFragment newFragment = new DatePicker();
        args.putString("Class", "ReservarSala");
        newFragment.setArguments(args);
        newFragment.show(getFragmentManager(), "datePicker");
    }


    /**
     * Classe que chama o fragmento de hora;
     * @param v
     */
    public void showTimePickerDialog(View v) {Bundle args = new Bundle();
        String x = "";
        switch (v.getId()) {
            case R.id.reservaETHorarioEntrada:
                args.putString("EditText", "Entrada");
                isEditTextEntrada = true;
                break;
            case R.id.reservaETHorarioSaida:
                args.putString("EditText", "Saida");
                isEditTextEntrada = false;
                break;
        }
        DialogFragment newFragment = new TimePicker();
        args.putString("Class", "ReservarSala");
        newFragment.setArguments(args);
        newFragment.show(getFragmentManager(), "timePicker");
    }

    /**
     * Função de retorno do Date Picker usado na seleção de data, retorna os valores
     * que são setados no campo de texto não editável
     * @param view
     * @param year
     * @param month
     * @param day
     */
    public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user

        month++;

        /* Acrescenta o 0 em dia ou mês, caso eles sejam menores que 10
                para que haja um padrão na exibição da data.
         */

        String today;
        today =  (day < 10)     ? "0" + day + "/"             : "" + day + "/";
        today += (month < 10)   ? "0" + month + "/" + year    : "" + month + "/" + year ;

        EditText textDate = (EditText) findViewById(R.id.reservaETData);
        textDate.setText(today);
        textDate.setTypeface(null, Typeface.BOLD);
        textDate.setTextColor(getResources().getColor(R.color.colorPrimary));
        textDate.setTextSize(22);
    }

    /**
     * Função de retorno do Time Picker usado na seleção de hora, retorna os valores
     * que são setados no campo de texto não editável
     * @param view
     * @param hourOfDay
     * @param minute
     */
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        String hora;
        hora = (hourOfDay < 10) ? "0"  + hourOfDay : "" + hourOfDay;
        hora += (minute < 10)   ? ":0" + minute    : ":" + minute;

        EditText textTime;
        if (isEditTextEntrada)
            textTime= (EditText) findViewById(R.id.reservaETHorarioEntrada);
        else
            textTime= (EditText) findViewById(R.id.reservaETHorarioSaida);

        textTime.setText(hora);
        textTime.setTypeface(null, Typeface.BOLD);
        textTime.setTextColor(getResources().getColor(R.color.colorPrimary));
        textTime.setTextSize(22);
    }


    public void botaoConfirmarReserva(View botao) {

        if (true) {

            //TODO: Pegar os dados necessários, e chamar a função de confirmar reserva da API

            Boolean horaInvalida = false;
            Boolean dataInvalida = false;

            etHorEntrada = (EditText) findViewById(R.id.reservaETHorarioEntrada);
            etHorSaida = (EditText) findViewById(R.id.reservaETHorarioSaida);

            String horaEntrada = etHorEntrada.getText().toString();
            String horaSaida = etHorSaida.getText().toString();
            if (horaEntrada.equals(getString(R.string.selecioneHora)) ) {
                etHorEntrada.setTextColor(Color.RED);
                horaInvalida = true;
            }
            if (horaSaida.equals(getString(R.string.selecioneHora))) {
                etHorSaida.setTextColor(Color.RED);
                horaInvalida = true;
            }


            EditText etData = (EditText) findViewById(R.id.reservaETData);
            if (etData.getText().toString().equals(getString(R.string.selecioneData))) {
                etData.setTextColor(Color.RED);
                dataInvalida = true;
            }

            if (dataInvalida) Toast.makeText(this, "Selecione uma data", Toast.LENGTH_SHORT).show();
            if (horaInvalida) Toast.makeText(this, "Selecione uma hora", Toast.LENGTH_SHORT).show();

            if (!horaInvalida && !dataInvalida) {
                //TODO: API código para reservar sala
            }

        }
        else {

        }

    }
}