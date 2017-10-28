package com.arqdsis.usjt.arqdsis.Projeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.arqdsis.usjt.arqdsis.R;
import com.arqdsis.usjt.arqdsis.util.LoginManager;

public class Loginctivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginctivity);

        ((EditText)findViewById(R.id.edtUsuario)).setText("Admin");
        ((EditText)findViewById(R.id.edtSenha)).setText("Admin@123");

    }

    public void logar(View view) {
        LoginManager loginManager = new LoginManager();

        String usuario = ((EditText)findViewById(R.id.edtUsuario)).getText().toString();
        String senha =   ((EditText)findViewById(R.id.edtSenha)).getText().toString();

        if(loginManager.logar(usuario,senha)){
            Intent intent = new Intent(this,PrincipalActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Senha ou Usuario Invalido",Toast.LENGTH_LONG);
        }

    }
}
