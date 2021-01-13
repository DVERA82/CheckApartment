package com.example.checkapartment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.checkapartment.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment implements IAdapter {
    private FragmentFirstBinding binding;
    private ApartmentData apartmentData = new ApartmentData();


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        Adapter adapter = new Adapter(apartmentData.apartmentList(),this);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void passApartment(Apartment pass) {
        Bundle bundle = new Bundle();
        bundle.putString("Nombre Edificio",pass.getBuildingName());
        bundle.putString("Departamento",pass.getUnitId());
        bundle.putString("Direccion",pass.getAddress());
        bundle.putString("image",pass.getUrlImageBuilding());
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);


    }
}

