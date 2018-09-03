package DAL;

import java.sql.*;

public class Conexao
{

    static Connection conexao = null;
    public static String mensagem;

    public static Connection Conectar()
    {
        mensagem = "";
        try
        {
            conexao = DriverManager.getConnection("jdbc:sqlserver://localhost\\DUDY-PC:1433;databaseName=CrudPessoasJava","sa","le");
        }
        catch (SQLException e)
        {
            mensagem = e.getMessage();
        }
        
        return conexao;
        
    } 
    public static void Desconectar(){
        try
        {
            if (!conexao.isClosed())
            {
                conexao.close();
            }
        }
        catch (SQLException e)
        {
            mensagem = "Erro ao fechar banco de dados";
        }
    }
            
}