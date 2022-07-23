package com.arithomazini.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arithomazini.agenda.DAO.ContatosDAO;
import com.arithomazini.agenda.model.Contatos;

public class CadastroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        EditText nome = findViewById(R.id.editTextNome);
        EditText email = findViewById(R.id.editTextEmail);
        EditText sobrenome = findViewById(R.id.editTextSobrenome);
        EditText telefone = findViewById(R.id.editTextTelefone);
        Button cadastrarContato = findViewById(R.id.buttonCadastrar);
        cadastrarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contatos contact = new Contatos();
                contact.setNome(nome.getText().toString());
                contact.setSobreNome(sobrenome.getText().toString());
                contact.setEmail(email.getText().toString());
                contact.setTelefone(telefone.getText().toString());

                if(contact.isNomeNullOrEmpty()){
                    Toast.makeText(CadastroActivity.this, "O nome deve ser preenchido!", Toast.LENGTH_SHORT).show();
                } else {
                    ContatosDAO dao = new ContatosDAO(CadastroActivity.this, "agenda", null, 1);
                    dao.save(contact);

                    Intent i = new Intent(CadastroActivity.this, MainActivity.class);
                    startActivity(i);
                    Toast.makeText(CadastroActivity.this, "Contato adicionado!", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}