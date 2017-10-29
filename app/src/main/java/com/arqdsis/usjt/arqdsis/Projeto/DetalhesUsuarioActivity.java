package com.arqdsis.usjt.arqdsis.Projeto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.arqdsis.usjt.arqdsis.Models.Usuario;
import com.arqdsis.usjt.arqdsis.R;

public class DetalhesUsuarioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_usuario);

        Intent intent = getIntent();
        Usuario usuario = (Usuario) intent.getSerializableExtra(UsuariosActivity.USUARIO_EXTRA);
        montarTela(usuario);
    }

    public void  montarTela(Usuario usuario){
        ((EditText)findViewById(R.id.edtNomeDetalhes)).setText(usuario.getNome());
        ((EditText)findViewById(R.id.edtCPFDetalhes)).setText(usuario.getCpf());
        ((EditText)findViewById(R.id.edtUsuarioDetalhes)).setText(usuario.getNomeUsuario());
    }

    public void atualizar(View view) {
        this.finish();
    }

    public void fechar(View view) {
        this.finish();
    }
}
