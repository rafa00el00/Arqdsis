package com.arqdsis.usjt.arqdsis.Projeto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.arqdsis.usjt.arqdsis.Dao.UsuarioDao;
import com.arqdsis.usjt.arqdsis.Models.Usuario;
import com.arqdsis.usjt.arqdsis.R;

import java.util.Date;

import static com.arqdsis.usjt.arqdsis.R.id.nome;

public class CreateUsuarioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_usuario);
    }

    public void inserir(View view){
        UsuarioDao dao = new UsuarioDao();

        String nomeUsuario = ((EditText)findViewById(R.id.edtUsuarioCreate)).getText().toString();
        String nome = ((EditText)findViewById(R.id.edtNomeCreate)).getText().toString();
        String cpf = ((EditText)findViewById(R.id.edtCPFCreate)).getText().toString();
        String senha = ((EditText)findViewById(R.id.edtSenhaCreate)).getText().toString();
        dao.insertUsuario(new Usuario(nomeUsuario,senha,nome,cpf,new Date()));
        this.finish();
    }

    public void fechar(View view) {
        this.finish();
    }
}
