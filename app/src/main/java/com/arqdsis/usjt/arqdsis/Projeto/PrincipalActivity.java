package com.arqdsis.usjt.arqdsis.Projeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.arqdsis.usjt.arqdsis.R;

public class PrincipalActivity extends Activity {

    public static final String NOME_USUARIO = "com.arqdsis.usjt.arqdsis.Projeto.NOME_USUARIO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void buscarUsuario(View view) {

        String usuario = ((EditText)findViewById(R.id.edtBuscarUsuario)).getText().toString();

        Intent intent = new Intent(this,UsuariosActivity.class);
        intent.putExtra(NOME_USUARIO,usuario);

        startActivity(intent);

    }
}
