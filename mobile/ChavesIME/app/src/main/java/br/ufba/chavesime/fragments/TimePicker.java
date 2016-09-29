package br.ufba.chavesime.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Calendar;

import br.ufba.chavesime.controller.CronogramaActivity;
import br.ufba.chavesime.R;
import br.ufba.chavesime.controller.ReservarSalaActivity;

/**
 * Created by Mauricio on 16/09/2016.
 */
public class TimePicker extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        int hour;
        int minute;
        String classFrom  = getArguments().getString("Class");
        EditText text;

        if (classFrom.equals("Cronograma")) {
            text = (EditText) getActivity().findViewById(R.id.cronogramaETHorario);
        }
        else {
            String etFrom = getArguments().getString("EditText");
            if (etFrom.equals("Entrada"))
                text = (EditText) getActivity().findViewById(R.id.reservaETHorarioEntrada);
            else
                text = (EditText) getActivity().findViewById(R.id.reservaETHorarioSaida);
        }

        String teste = text.getText().toString();

        if (!teste.equals(getString(R.string.selecioneHora))) {
            String[] parts = teste.split(":");
            hour = Integer.parseInt(parts[0]);
            minute = Integer.parseInt(parts[1]);
        }
        else {
            final Calendar c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            minute = c.get(Calendar.MINUTE);
        }


        // Create a new instance of TimePickerDialog and return it
        TimePickerDialog pickerDialog;
        if(classFrom.equals("Cronograma"))
            pickerDialog = new TimePickerDialog(getActivity(), (CronogramaActivity)getActivity(), hour, minute,true);
        else
            pickerDialog = new TimePickerDialog(getActivity(), (ReservarSalaActivity)getActivity(), hour, minute, true);

        return pickerDialog;
    }

}
