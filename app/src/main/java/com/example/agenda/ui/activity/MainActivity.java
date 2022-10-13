package com.example.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.agenda.DAO.AlunoDAO;
import com.example.agenda.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List <String> alunos = new
        //           ArrayList<>(Arrays.asList("Yasmin","Maria","Jose"));
        // TextView primeiroAluno = findViewById(R.id.textView);
        // TextView segundoAluno = findViewById(R.id.textView2);
        // TextView terceiroAluno = findViewById(R.id.textView3);

        // primeiroAluno.setText(alunos.get(0));
        //  segundoAluno.setText(alunos.get(1));
        //  terceiroAluno.setText(alunos.get(2));


        setTitle("Agenda de alunos");
        FloatingActionButton botaoNovo = findViewById(R.id.floatingActionButton4);
        botaoNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this, Formulario_aluno_activity.class));
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();

        AlunoDAO  dao = new AlunoDAO();
        ListView listaAlunos = findViewById(R.id.activity_main_lista_alunos);
        listaAlunos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                dao.todos()));
    }
}