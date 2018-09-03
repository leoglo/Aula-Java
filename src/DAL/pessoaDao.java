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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ExcluirPessoa(Pessoa pessoa)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pessoa PesquisarPessoaPorId(Pessoa pessoa)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> PesquisarPessoaPorNome(Pessoa pessoa)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
