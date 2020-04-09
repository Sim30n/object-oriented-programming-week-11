package com.example.week_11;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


public class SettingsFragment extends Fragment {

    private SharedViewModel viewModel;
    private EditText editText;
    private EditText editGravity;
    Spinner varit;
    Spinner tKoko;
    Spinner tausta;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        editText = v.findViewById(R.id.edit_text);
        editGravity = (EditText) v.findViewById(R.id.gravity);

        // Teksitin väri spinneri
        String[] variLista = new String[] {
                "Sininen", "Punainen", "Vihreä", "Keltainen"
        };
        varit = (Spinner) v.findViewById(R.id.spinner1);
        ArrayAdapter<String> variAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, variLista);
        variAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        varit.setAdapter(variAdapter);

        // Teksitin koko Spinneri
        String[] kokoLista = new String[] {
                "20", "60", "100", "140"
        };
        tKoko = (Spinner) v.findViewById(R.id.spinner2);
        ArrayAdapter<String> kokoAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, kokoLista);
        kokoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tKoko.setAdapter(kokoAdapter);

        // Taustan väri spinneri
        String[] taustaLista = new String[] {
                "Harmaa", "Valkoinen", "Musta", "Cyan"
        };
        tausta = (Spinner) v.findViewById(R.id.spinner3);
        ArrayAdapter<String> taustaAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, taustaLista);
        taustaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tausta.setAdapter(taustaAdapter);

        //OK nappi
        Button button = v.findViewById(R.id.button_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setText(editText.getText());
                viewModel.settVari(varit.getSelectedItem().toString());
                String kokoString = tKoko.getSelectedItem().toString();
                int koko = Integer.parseInt(kokoString);
                viewModel.settKoko(koko);
                String strGravity = editGravity.getText().toString();
                int gravityInt = Integer.parseInt(strGravity);
                viewModel.setGravity(gravityInt);
                viewModel.setTausta(tausta.getSelectedItem().toString());
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                editText.setText(charSequence);
            }
        });
    }
}