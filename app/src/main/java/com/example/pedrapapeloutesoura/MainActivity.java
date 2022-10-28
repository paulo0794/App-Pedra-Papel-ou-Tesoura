package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        //Random random = new Random();
        //random.nextInt();

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                  (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                  (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                  (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ){//App ganhador
            textResultado.setText("Você perdeu :(");
        }else if(
                 (opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                 (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                 (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")
        ){//Usuario ganhador
            textResultado.setText("Você ganhou :)");
        }else{//Empate
            textResultado.setText("Empatamos ;)");
        }

    }
}