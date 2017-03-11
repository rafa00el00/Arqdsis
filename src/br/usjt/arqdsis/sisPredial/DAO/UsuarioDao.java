package br.usjt.arqdsis.sisPredial.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;
import br.usjt.arqdsis.sisPredial.Models.Usuario;

public class UsuarioDao extends AbstractDao{

   public UsuarioDao(){
      super();
   }

   //incluir
   public void incluir(Usuario usr)
   {
   
      String sqlInsert = "INSERT INTO Usuario("
         +"login"
         +",CPF"
         +",nome"
         +",empresa_id"
         +",horaAcesso"
         +",horaSaida"
         +")"
         +" VALUES (?, ?, ?, ?, ?, ?)";
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sqlInsert);
         stm.setString(1, usr.getLogin());
         stm.setString(2, usr.getCPF());
         stm.setString(3, usr.getNome());
         stm.setInt(4, usr.getEmpresa().getId());
       //  stm.setTime(5, usr.getHoraAcesso());
        // stm.setTime(6, usr.getHoraSaida());
         stm.executeUpdate();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			usr.setId(rs.getInt(1));
      }
      catch (Exception e)
      {
         e.printStackTrace();
         try
         {
            conn.rollback();
         }
         catch (SQLException e1)
         {
            System.out.print(e1.getStackTrace());
         }
         finally
         {
            if (stm != null)
            {
               try
               {
                  stm.close();
               }
               catch (SQLException e1)
               {
                  System.out.print(e1.getStackTrace());
               }
            }
         }
      }
   }
   
   //alterar
   public void alterar(Usuario usr)
   {
   
      String sqlInsert = "Update Usuario set "
         +"login = ?"
         +",CPF = ?"
         +",empresa_id = ?"
         +",horaAcesso = ?"
         +",horaSaida = ?"
         +",nome = ?"
         +""
         +" where id = ?";
         
      PreparedStatement stm = null;
      try
      {
         stm = conn.prepareStatement(sqlInsert);
         stm.setString(1, usr.getLogin());
         stm.setString(2, usr.getCPF());
         stm.setInt(3, usr.getEmpresa().getId());
        // stm.setTime(4, usr.getHoraAcesso());
        // stm.setTime(5, usr.getHoraSaida());
         stm.setString(6, usr.getNome());
         stm.setInt(7, usr.getId());
         stm.execute();
      }
      catch (Exception e)
      {
         e.printStackTrace();
         try
         {
            conn.rollback();
         }
         catch (SQLException e1)
         {
            System.out.print(e1.getStackTrace());
         }
         finally
         {
            if (stm != null)
            {
               try
               {
                  stm.close();
               }
               catch (SQLException e1)
               {
                  System.out.print(e1.getStackTrace());
               }
            }
         }
      }
   }
   
   //Consultar
   public Usuario consultar(IEntidade entidade)
   {
      String sqlSelect = "SELECT * FROM Usuario";
      Usuario usr;
      if (entidade instanceof Usuario){
         sqlSelect += " where id = ?";
      }
      usr= new Usuario();
   
      PreparedStatement stm = null;
      ResultSet rs = null;
      Empresa empresa = new Empresa();
      
      EmpresaDao empDao = new EmpresaDao();
      try
      {
         stm = conn.prepareStatement(sqlSelect);
         if (entidade instanceof Usuario){
            stm.setInt(1,entidade.getId());
         }
         rs = stm.executeQuery();
         while (rs.next())
         {
            
            usr.setId(rs.getInt("id"));
            usr.setCPF(rs.getString("cpf"));
            usr.setLogin(rs.getString("login"));
            usr.setNome(rs.getString("nome"));
            usr.setEmpresa(new Empresa());
            usr.getEmpresa().setId(rs.getInt("empresa_id"));
            empDao.consultar(usr.getEmpresa());
            usr.setHoraAcesso(rs.getTime("horaAcesso"));
            usr.setHoraSaida(rs.getTime("horaSaida"));
                
            
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         try
         {
            conn.rollback();
         }
         catch (SQLException e1)
         {
            System.out.print(e1.getStackTrace());
         }
      }
      finally
      {
         if (stm != null)
         {
            try
            {
               stm.close();
            }
            catch (SQLException e1)
            {
               System.out.print(e1.getStackTrace());
            }
         }
      }
      return (usr);
   }
   
   //Consultar
   public List<Usuario> consultarTodos(IEntidade entidade)
   {
      String sqlSelect = "SELECT * FROM Usuario";
      List<Usuario> usuarios = new ArrayList<Usuario>();
      Usuario usr;
      if (entidade instanceof Empresa){
         sqlSelect += " where empresa_id = ?";
      }
       
   
      PreparedStatement stm = null;
      ResultSet rs = null;
      Empresa empresa = new Empresa();
     
      EmpresaDao empDao = new EmpresaDao();
      
   
      try
      {
         stm = conn.prepareStatement(sqlSelect);
         if (entidade instanceof Usuario){
            //traz todos
         }
         else if (entidade instanceof Empresa){
            stm.setInt(1,((Empresa)entidade).getId());
         }
         rs = stm.executeQuery();
         while (rs.next())
         {
            usr= new Usuario();
            usr.setId(rs.getInt("id"));
            usr.setCPF(rs.getString("cpf"));
            usr.setLogin(rs.getString("login"));
            usr.setNome(rs.getString("nome"));
            usr.setEmpresa(new Empresa());
            usr.getEmpresa().setId(rs.getInt("empresa_id"));
            empDao.consultar(usr.getEmpresa());
            usr.setHoraAcesso(rs.getTime("horaAcesso"));
            usr.setHoraSaida(rs.getTime("horaSaida"));
            
            usuarios.add(usr);     
            
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
         try
         {
            conn.rollback();
         }
         catch (SQLException e1)
         {
            System.out.print(e1.getStackTrace());
         }
      }
      finally
      {
         if (stm != null)
         {
            try
            {
               stm.close();
            }
            catch (SQLException e1)
            {
               System.out.print(e1.getStackTrace());
            }
         }
      }
      return usuarios;
   }

   public boolean deletar(Usuario usr) {
      String sqlInsert = "Delete from Usuario "
            +" where id = ?";
            
      PreparedStatement stm = null;
      try
      {
      stm = conn.prepareStatement(sqlInsert);
         stm.setInt(1, usr.getId());
         stm.execute();
         return true;
      }
      catch (Exception e)
      {
         e.printStackTrace();
         try
         {
            conn.rollback();
         }
         catch (SQLException e1)
         {
            System.out.print(e1.getStackTrace());
         }
         finally
         {
            if (stm != null)
            {
               try
               {
                  stm.close();
               }
               catch (SQLException e1)
               {
                  System.out.print(e1.getStackTrace());
               }
            }
         }
         return false;
      }
   
   }




}

