package br.ufba.chavesime;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.ufba.chavesime.abstrato.DateAndTimeActivities;
import br.ufba.chavesime.fragments.DatePicker;
import br.ufba.chavesime.fragments.TimePicker;
import br.ufba.chavesime.model.Init;

public class CronogramaActivity extends DateAndTimeActivities {

    private EditText etHorario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronograma);
        setTitle(getResources().getText(R.string.titleCronograma));

        Init.dropDownSalas(this, (Spinner) findViewById(R.id.ddownSala));
        Init.dateText((EditText) findViewById(R.id.cronogramaETData));
        Init.timeText((EditText) findViewById(R.id.cronogramaETHorario));

        Toolbar toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }


    /**
     * Classe que chama o fragmento de data;
     * @param v
     */
    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePicker();
        Bundle args = new Bundle();
        args.putString("Class", "Cronograma");
        newFragment.setArguments(args);
        newFragment.show(getFragmentManager(), "datePicker");
    }

    /**
     * Classe que chama o fragmento de hora;
     * @param v
     */
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePicker();
        Bundle args = new Bundle();
        args.putString("Class", "Cronograma");
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

        EditText textDate = (EditText) findViewById(R.id.cronogramaETData);
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
        // Do something with the time chosen by the user


        String hora;
        hora = (hourOfDay < 10) ? "0"  + hourOfDay : "" + hourOfDay;
        hora += (minute < 10)   ? ":0" + minute    : ":" + minute;

        EditText textTime = (EditText) findViewById(R.id.cronogramaETHorario);
        textTime.setText(hora);
        textTime.setTypeface(null, Typeface.BOLD);
        textTime.setTextColor(getResources().getColor(R.color.colorPrimary));
        textTime.setTextSize(22);
    }

    public void botaoBuscarCronograma(View botao) {
        if (true) {
            Boolean invalido = false;

            etHorario = (EditText) findViewById(R.id.cronogramaETHorario);
            if (etHorario.getText().toString().equals(getString(R.string.selecioneHora))) {
                etHorario.setTextColor(Color.RED);
                Toast.makeText(this, "Selecione uma hora", Toast.LENGTH_SHORT).show();
                invalido = true;
            }

            EditText etData = (EditText) findViewById(R.id.cronogramaETData);
            if (etData.getText().toString().equals(getString(R.string.selecioneData))) {
                etData.setTextColor(Color.RED);
                Toast.makeText(this, "Selecione uma data", Toast.LENGTH_SHORT).show();
                invalido = true;
            }

            if (!invalido) {
                //TODO: API Code
            }
        }
        else {

        }
    }
}
