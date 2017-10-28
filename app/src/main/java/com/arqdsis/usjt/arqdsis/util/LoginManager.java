package com.arqdsis.usjt.arqdsis.util;

/**
 * Created by rafae on 28/10/2017.
 */

public class LoginManager {

    public boolean logar(String usuario, String senha){

        if (usuario.equals("Admin") && senha.equals("Admin@123"))
            return true;

        return  false;

    }

}
