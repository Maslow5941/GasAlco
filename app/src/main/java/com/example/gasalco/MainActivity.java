package com.example.gasalco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText editGasPreco,editAlcoolPreco;

    private TextView tVResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcoolPreco = findViewById(R.id.editAlcoolPreco);
        editGasPreco = findViewById(R.id.editGasPreco);
        tVResult = findViewById(R.id.tVResult);


        }
    public void calcularPreco(View view) {
        //recuperando os dados do campo
        String precoGas =  editGasPreco.getText().toString();
        String precoAlcool = editAlcoolPreco.getText().toString();

        //validando os campos
        Boolean resultado = validarCampos(precoGas, precoAlcool);

        if (resultado){//convertendo string pra numero
            Double valorGas = Double.parseDouble(precoGas);
            Double valorAlcool = Double.parseDouble(precoAlcool);

            //calcular qual é mais vantagem
            Double result = valorAlcool / valorGas;
            if(result >=0.7){
                tVResult.setText("Melhor opção Gasolina");
            }else{
                tVResult.setText("Melhor opção Alcool");
            }
            
        }else{
            tVResult.setText("Digite os valores.");
        }

    }

    public Boolean validarCampos ( String validarGas, String validarAlcool) {
    Boolean camposValidos = true;

    if (validarGas == null || editGasPreco.equals("")){
        camposValidos = false;
    } else if (validarAlcool == null || editAlcoolPreco.equals("")) {
        camposValidos = false;

    }
    return camposValidos;

    }


    }//activit


