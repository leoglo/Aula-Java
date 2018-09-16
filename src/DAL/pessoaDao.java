package DAL;

import java.sql.*;
import java.util.List;
import modelo.Pessoa;

public class pessoaDao implements intPessoaDao
{

    public String mensagem;

    @Override
    public void CadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection conexao = Conexao.Conectar();
            String instrucaoSql = "insert into Pessoas"
                    + "(nome, rg, cpf) "
                    + "values (?, ?, ?)";
            PreparedStatement prm = conexao.prepareStatement(instrucaoSql);
            prm.setString(1, pessoa.nome);
            prm.setString(2, pessoa.rg);
            prm.setString(3, pessoa.cpf);
            prm.execute();
            Conexao.Desconectar();
            this.mensagem = "Pessoa cadastrada com sucesso!";
        }
        catch (SQLException e)
        {
            this.mensagem = Conexao.mensagem + e.getMessage();
        }

    }

    @Override
    public void EditarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection conexao = Conexao.Conectar();
            String instrucaoSql = "Update Pessoas set nome= ?, rg= ?, cpf= ? where id = ?";
            PreparedStatement prm = conexao.prepareStatement(instrucaoSql);
            prm.setString(1, pessoa.nome);
            prm.setString(2, pessoa.rg);
            prm.setString(3, pessoa.cpf);
            prm.setInt(4, pessoa.id);
            prm.execute();
            Conexao.Desconectar();
            this.mensagem = "Pessoa Editada com sucesso!";
        }
        catch (SQLException e)
        {
            this.mensagem = Conexao.mensagem + e.getMessage();
        }

    }

    @Override
    public void ExcluirPessoa(Pessoa pessoa)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa PesquisarPessoaPorId(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection conexao = Conexao.Conectar();
            String instrucaoSql = "Select * From "
                    + "Pessoas where id = ?";
            PreparedStatement prm = conexao.prepareStatement(instrucaoSql);
            prm.setInt(1, pessoa.id);
            ResultSet result = prm.executeQuery();
            if (result.next())
            {
                pessoa.nome = result.getString("nome");
                pessoa.rg = result.getString("rg");
                pessoa.cpf = result.getString("cpf");
            }
            Conexao.Desconectar();
        }
        catch (SQLException e)
        {
            this.mensagem = Conexao.mensagem + e.getMessage();
        }
        return pessoa;
    }

    @Override
    public List<Pessoa> PesquisarPessoaPorNome(Pessoa pessoa)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
