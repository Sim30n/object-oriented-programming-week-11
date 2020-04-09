package com.example.week_11;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class MessageFragment extends Fragment {
    private TextView textView;
    private SharedViewModel viewModel;
    RelativeLayout relativeLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, container, false);
        textView = v.findViewById(R.id.teksti);
        relativeLayout = v.findViewById(R.id.relative);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                textView.setText(charSequence);
            }
        });
        viewModel.getVari().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                if(charSequence.equals(("Sininen"))){
                    textView.setTextColor(Color.BLUE);
                } else if (charSequence.equals(("Punainen"))){
                    textView.setTextColor(Color.RED);
                } else if (charSequence.equals(("Vihreä"))){
                    textView.setTextColor(Color.GREEN);
                } else if (charSequence.equals(("Keltainen"))){
                    textView.setTextColor(Color.YELLOW);
                }
            }
        });
        viewModel.getKoko().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer koko) {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, koko);
            }
        });
        viewModel.getGravity().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer gravity) {
                relativeLayout.setGravity(gravity);
            }
        });
        viewModel.getTausta().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                if(charSequence.equals(("Harmaa"))){
                    relativeLayout.setBackgroundColor(Color.GRAY);
                } else if (charSequence.equals(("Valkoinen"))){
                    relativeLayout.setBackgroundColor(Color.WHITE);
                } else if (charSequence.equals(("Musta"))){
                    relativeLayout.setBackgroundColor(Color.BLACK);
                } else if (charSequence.equals(("Cyan"))){
                    relativeLayout.setBackgroundColor(Color.CYAN);
                }
            }
        });


    }

}
