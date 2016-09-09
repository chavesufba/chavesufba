package br.ufba.chavesime;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

/**
 * Created by Mauricio on 08/09/2016.
 */
public class Inicializacoes {

    public static void dropDownHorarios(Context context, Spinner spinner) {
        // Preenchimento do DropDown de Horários
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.horarios_array, R.layout.spinner);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public static void dropDownSalas(Context context, Spinner spinner) {
        // Preenchimento do DropDown de Horários
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.salas_array, R.layout.spinner);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public static void dateText(EditText textDate) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        String today;
        today =  (day < 10)     ? "0" + day + "/"             : "" + day + "/";
        today += (month < 10)   ? "0" + month + "/" + year    : "" + month + "/" + year ;

        textDate.setText(today);
    }
}
