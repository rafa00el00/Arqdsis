package com.arqdsis.usjt.arqdsis.Projeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.arqdsis.usjt.arqdsis.Dao.UsuarioDao;
import com.arqdsis.usjt.arqdsis.Models.Usuario;
import com.arqdsis.usjt.arqdsis.R;

import java.util.ArrayList;
import java.util.List;

public class UsuariosActivity extends Activity {

    public static final String USUARIO_EXTRA = "com.arqdsis.usjt.arqdsis.Projeto.USUARIO_EXTRA";
    private ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        final Intent intent = getIntent();

        String nome =   intent.getStringExtra(PrincipalActivity.NOME_USUARIO);

        UsuarioDao usuarioDao = new UsuarioDao();
       usuarios = usuarioDao.getUsuariosByNome(nome);
        ArrayList<String> lista = new ArrayList<>();
        for(int i = 0; i< usuarios.size();i++)
            lista.add(usuarios.get(i).getNome());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista);

        ListView listView = (ListView)findViewById(R.id.lstUsuarios);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(view.getContext(), DetalhesUsuarioActivity.class);
                intent1.putExtra(USUARIO_EXTRA , usuarios.get(position));
                startActivity(intent1);
            }
        });

    }


}
