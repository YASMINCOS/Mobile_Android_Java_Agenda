package com.example.agenda.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agenda.DAO.AlunoDAO;
import com.example.agenda.R;
import com.example.agenda.model.Aluno;

public class Formulario_aluno_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);


        AlunoDAO dao = new AlunoDAO();
       final EditText campoNome = findViewById(R.id.activity_form_nome);
       final EditText campoTelefone = findViewById(R.id.activity_form_email);
       final EditText campoEmail= findViewById(R.id.activity_form_email);

        Button btSalvar = findViewById(R.id.activity_form_bt_salvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

               Aluno alunoCriado = new Aluno(nome, telefone,email);
               dao.salva(alunoCriado);

               finish();
            }
        });
    }
}