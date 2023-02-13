package com.mblhcmute.firstcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mblhcmute.firstcalculatorapp.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.btnAddAB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sA = binding.edtA.getText().toString();
                String sB = binding.edtB.getText().toString();

                try {
                    double A = Double.parseDouble(sA);
                    double B = Double.parseDouble(sB);
                    double result = A + B;
                    DecimalFormat decimalFormat = new DecimalFormat("#.#######");
                    String strResult = decimalFormat.format(result);
                    binding.txtResult.setText(String.valueOf(strResult));
                    Toast.makeText(v.getContext(),"Kết quả: " + strResult, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(v.getContext(),"Sai định dạng dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}