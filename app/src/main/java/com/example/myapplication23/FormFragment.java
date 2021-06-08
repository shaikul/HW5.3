package com.example.myapplication23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FormFragment extends Fragment {

    EditText name,surname;
    Button btn;

    public FormFragment() {
        // Required empty public constructor
    }

    public static FormFragment newInstance(String param1, String param2) {
        FormFragment fragment = new FormFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = view.findViewById(R.id.et_name);
        surname = view.findViewById(R.id.et_surname);
        btn = view.findViewById(R.id.btn_add_to_recycler);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment f = new HomeFragment();
                Bundle b = new Bundle();
                b.putSerializable("user",new User(name.getText().toString(),surname.getText().toString()));
                f.setArguments(b);
                getFragmentManager().beginTransaction().replace(R.id.container,f).commit();
            }
        });
    }
}