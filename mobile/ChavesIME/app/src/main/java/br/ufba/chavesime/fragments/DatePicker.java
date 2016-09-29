package br.ufba.chavesime.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Calendar;

import br.ufba.chavesime.CronogramaActivity;
import br.ufba.chavesime.R;
import br.ufba.chavesime.ReservarSalaActivity;

/**
 * Created by Mauricio on 01/09/2016.
 */

public class DatePicker extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker

        String classFrom  = getArguments().getString("Class");
        int day, month, year;
        EditText dataText;

        if (classFrom.equals("Cronograma"))
            dataText = (EditText) getActivity().findViewById(R.id.cronogramaETData);
        else
            dataText = (EditText) getActivity().findViewById(R.id.reservaETData);
        String stDataText = dataText.getText().toString();

        if (!stDataText.equals(getString(R.string.selecioneData))) {
            String[] parts = stDataText.split("/");
            day = Integer.parseInt(parts[0]);
            month = Integer.parseInt(parts[1]) - 1;
            year = Integer.parseInt(parts[2]);
        }
        else {
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog pickerDialog;
        if(classFrom.equals("Cronograma"))
            pickerDialog = new DatePickerDialog(getActivity(), (CronogramaActivity)getActivity(), year, month, day);
        else
            pickerDialog = new DatePickerDialog(getActivity(), (ReservarSalaActivity)getActivity(), year, month, day);

        pickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        return pickerDialog;
    }
}