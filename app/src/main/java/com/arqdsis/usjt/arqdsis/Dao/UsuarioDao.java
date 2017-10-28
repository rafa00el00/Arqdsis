package com.arqdsis.usjt.arqdsis.Dao;

import com.arqdsis.usjt.arqdsis.Models.Usuario;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by rafae on 28/10/2017.
 */
public class UsuarioDao {

    private static ArrayList<Usuario> usuarios;
    private static int UserControllerId;

    public UsuarioDao() {
        if(usuarios == null){
            UserControllerId = 0;
            usuarios = new ArrayList<>();
            insertUsuario(new Usuario("Rafa","Rafa@123","Rafael Santos","1234567808",new Date(1995,7,24)));
            insertUsuario(new Usuario("Rafinfa","Rafa@123","Rafael Dias","1234567808",new Date(1995,7,24)));
            insertUsuario(new Usuario("Yuri","yuri@123","Yuri Vagabundo","1234567808",new Date(1995,7,24)));
            insertUsuario(new Usuario("Nick","Nik@123","nikolas bipolar","1234567808",new Date(1995,7,24)));
            insertUsuario(new Usuario("Mandadao","mandado@123","Vitor Mandadão mesmo ","1234567808",new Date(1995,7,24)));
        }
    }

    public ArrayList<Usuario> getUsuariosByNome(final String nome) {

        if(nome == null || nome.isEmpty())
            return usuarios;

        ArrayList<Usuario> filtro = new ArrayList<>();

        for (int i = 0; i < usuarios.size();i++){
            if(usuarios.get(i).getNome().toUpperCase().contains(nome.toUpperCase())){
                filtro.add(usuarios.get(i));
            }
        }

        return filtro;
    }

    public Usuario insertUsuario(Usuario usuario){
        usuario.setId(++UserControllerId);
        usuarios.add(usuario);
        return  usuario;
    }


}
