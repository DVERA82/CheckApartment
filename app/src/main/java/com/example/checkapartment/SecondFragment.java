package com.example.checkapartment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.checkapartment.MVPcalculo.ICalculo;
import com.example.checkapartment.MVPcalculo.PresentadorCalculo;
import com.example.checkapartment.MVPloging.Presentador;
import com.example.checkapartment.databinding.FragmentFirstBinding;
import com.example.checkapartment.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment  implements ICalculo {
    private FragmentSecondBinding binding;
    private String nombreEdificio;
    private String departamento;
    private String direccion;
    private String image;
    private PresentadorCalculo presentadorCalculo;
    private int terminaciones;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater,container,false);
        binding.NombreEdif.setText(nombreEdificio);
        Glide.with(getContext()).load(image).centerCrop().into(binding.imageView2);
        binding.Depto.setText(departamento);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            nombreEdificio = getArguments().getString("Nombre Edificio");
            departamento = getArguments().getString("Departamento");
            direccion = getArguments().getString("Direccion");
            image = getArguments().getString("image");
        }
        presentadorCalculo = new PresentadorCalculo(this);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int radioGroup;
        binding.bAlerta.setEnabled(false);
        binding.rgrup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radiobutton = binding.rgrup.findViewById(checkedId);
                int index = binding.rgrup.indexOfChild(radiobutton);
                String texto = " ";
                int luces;
                int banio;
                int cocina;
                int dormitorio;
                switch (index) {
                    case 0:
                        if (binding.cBLuces.isChecked()) {
                            luces = 10;
                        } else {
                            luces = 0;
                        }

                        if (binding.cBBanio.isChecked()) {
                            banio = 40;
                        } else {
                            banio = 0;
                        }

                        if (binding.cBCocina.isChecked()) {
                            cocina = 30;
                        } else {
                            cocina = 0;
                        }

                        if (binding.cBDormitorio.isChecked()) {
                            dormitorio = 20;
                        } else {
                            dormitorio = 0;
                        }

                        terminaciones = 3;
                        calculoRevision(luces, dormitorio, cocina, banio, terminaciones);
                        texto = getString(R.string.Puntaje, String.valueOf(resultadoCalculo()));
                        binding.tvPuntaje.setText(texto);

                        break;
                    case 1:
                        if (binding.cBLuces.isChecked()) {
                            luces = 10;
                        } else {
                            luces = 0;
                        }

                        if (binding.cBBanio.isChecked()) {
                            banio = 40;
                        } else {
                            banio = 0;
                        }

                        if (binding.cBCocina.isChecked()) {
                            cocina = 30;
                        } else {
                            cocina = 0;
                        }

                        if (binding.cBDormitorio.isChecked()) {
                            dormitorio = 20;
                        } else {
                            dormitorio = 0;
                        }
                        terminaciones = 2;
                        calculoRevision(luces, dormitorio, cocina, banio, terminaciones);
                        texto = getString(R.string.Puntaje, String.valueOf(resultadoCalculo()));
                        binding.tvPuntaje.setText(texto);
                        break;
                    case 2:
                        if (binding.cBLuces.isChecked()) {
                            luces = 10;
                        } else {
                            luces = 0;
                        }

                        if (binding.cBBanio.isChecked()) {
                            banio = 40;
                        } else {
                            banio = 0;
                        }

                        if (binding.cBCocina.isChecked()) {
                            cocina = 30;
                        } else {
                            cocina = 0;
                        }

                        if (binding.cBDormitorio.isChecked()) {
                            dormitorio = 20;
                        } else {
                            dormitorio = 0;
                        }
                        terminaciones = 1;
                        calculoRevision(luces, dormitorio, cocina, banio, terminaciones);
                        texto = getString(R.string.Puntaje, String.valueOf(resultadoCalculo()));
                        binding.tvPuntaje.setText(texto);
                        break;
                    default:
                        terminaciones = 0;
                        break;
                }
                if (resultadoCalculo() < 130) {
                    binding.tvPuntaje.setBackgroundColor(Color.RED);
                    binding.tvPuntaje.setTextColor(Color.WHITE);
                    binding.bAlerta.setEnabled(true);
                } else {
                    binding.tvPuntaje.setBackgroundColor(Color.WHITE);
                    binding.tvPuntaje.setTextColor(Color.BLACK);
                    binding.bAlerta.setEnabled(false);
                }
            }
        });
        binding.bGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "El Resultado es " +
                        String.valueOf(resultadoCalculo()), Toast.LENGTH_LONG).show();
            }
        });
        binding.bAlerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"d.vera29@gmail.com"});
                startActivity(intent);
            }
        });
    }
            @Override
            public void calculoRevision(int luces, int dormitorio, int cocina, int banio,int terminaciones)
            { presentadorCalculo.calculoRevision(luces, dormitorio, cocina, banio, terminaciones);

            }

            @Override
            public int resultadoCalculo() {
                return presentadorCalculo.resultadoCalculo();
            }

        }
