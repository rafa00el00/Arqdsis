package br.usjt.arqdsis.sisPredial.Models;
import java.util.Date;

import br.usjt.arqdsis.sisPredial.DAO.UsuarioDao;
public class Usuario extends IEntidade{

   private String login;
   private String senha;
   private TipoPerfil perfil;
   private String CPF;
   private String nome;
   private Empresa empresa;
   private Date horaAcesso;
   private Date horaSaida; 
   
   public Usuario(String login,String senha,TipoPerfil perfil){
      setLogin(login);
      setSenha(senha);
      setPerfil(perfil);
     
   }
   
   public Usuario(){
      this("","",TipoPerfil.comum);
   }
   
   public enum TipoPerfil{
	   Admin,comum,comumComPrivilegio
   }
   
   //Settes
   public void setLogin(String login)
   {
      this.login = login;
   }
   public void setSenha(String senha)
   {
      this.senha = senha;
   }
   public void setPerfil(TipoPerfil perfil)
   {
      this.perfil = perfil;
   }
   
   //Getters
   public String getLogin()
   {
      return this.login;
   }
   public String getSenha()
   {
      return this.senha;
   }
   public TipoPerfil getPerfil()
   {
      return this.perfil;
   }
   
    public String getCPF() {
      return CPF;
   }
   public void setCPF(String cPF) {
      CPF = cPF;
   }
   public String getNome() {
      return nome;
   }
   public void setNome(String nome) {
      this.nome = nome;
   }
   public Empresa getEmpresa() {
      return empresa;
   }
   public void setEmpresa(Empresa empresa) {
      this.empresa = empresa;
   }
   public Date getHoraAcesso() {
      return horaAcesso;
   }
   public void setHoraAcesso(Date horaAcesso) {
      this.horaAcesso = horaAcesso;
   }
   public Date getHoraSaida() {
      return horaSaida;
   }
   public void setHoraSaida(Date horaSaida) {
      this.horaSaida = horaSaida;
   }

   
}