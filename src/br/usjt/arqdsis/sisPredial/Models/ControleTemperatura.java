package br.usjt.arqdsis.sisPredial.Models;

public class ControleTemperatura extends IEntidade{

    private String status;
    private Empresa empresa;
   
   
   //Settes
   public void setStatus(String status)
   {
      this.status = status;
   }

//Getters
   public String getStatus()
   {
      return this.status;
   }
   //metodos
   public void enviarTemperatura(){
   
   }
   

}