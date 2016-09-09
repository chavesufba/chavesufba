package br.ufba.chavesime;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class CronogramaActivity extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronograma);
        setTitle(getResources().getText(R.string.titleCronograma));

        Inicializacoes.dropDownHorarios(this,(Spinner) findViewById(R.id.ddownHorario));
        Inicializacoes.dropDownSalas(this, (Spinner) findViewById(R.id.ddownSala));
        Inicializacoes.dateText((EditText) findViewById(R.id.editTextData));

        Toolbar toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            //TODO: Seta de voltar estar escura, corrigir!
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putString("Class", "Cronograma");
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

    public void botaoBuscarCronograma(View botao) {
        if (true) {

            //TODO: Pegar os dados necessários, e chamar a função de buscar cronograma da API

            Intent intent = new Intent(this, ReservarSalaActivity.class);
            intent.putExtra("user", "Teste");
            startActivity(intent);
        }
        else {

        }
    }
}
