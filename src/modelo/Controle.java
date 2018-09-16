package modelo;

import DAL.pessoaDao;
import java.util.List;

public class Controle
{

    public String mensagem;

    public void CadastrarPessoa(List<String> DadosPessoa)
    {
        this.mensagem = "";

        Validacao validacao = new Validacao();
        validacao.ValidarDadosPessoa(DadosPessoa);
        if (validacao.Mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.nome = DadosPessoa.get(1);
            pessoa.rg = DadosPessoa.get(2);
            pessoa.cpf = DadosPessoa.get(3);
            DAL.pessoaDao pessoadao = new DAL.pessoaDao();
            pessoadao.CadastrarPessoa(pessoa);
            this.mensagem = pessoadao.mensagem;
        }
        else
        {
            this.mensagem = validacao.Mensagem;
        }
    }

    public Pessoa PesquisarPessoaporId(List<String> DadosPessoa)
    {
        Validacao validacao = new Validacao();
        Pessoa pessoa = new Pessoa();
        validacao.ValidarPesquisaPorId(DadosPessoa);
        if (validacao.Mensagem.equals(""))
        {
            pessoa.id = validacao.id;
            DAL.pessoaDao pessoadao = new pessoaDao();
            pessoa = pessoadao.PesquisarPessoaPorId(pessoa);
            this.mensagem = pessoadao.mensagem;
        }
        else
        {
            this.mensagem = validacao.Mensagem;
        }
        return pessoa;
    }

    public void EditarPessoa(List<String> DadosPessoa)
    {
        this.mensagem = "";

        Validacao validacao = new Validacao();
        validacao.ValidarDadosPessoa(DadosPessoa);
        if (validacao.Mensagem.equals(""))
        {
            Pessoa pessoa = new Pessoa();
            pessoa.id = validacao.id;
            pessoa.nome = DadosPessoa.get(1);
            pessoa.rg = DadosPessoa.get(2);
            pessoa.cpf = DadosPessoa.get(3);
            DAL.pessoaDao pessoadao = new DAL.pessoaDao();
            pessoadao.EditarPessoa(pessoa);
            this.mensagem = pessoadao.mensagem;
        }
        else
        {
            this.mensagem = validacao.Mensagem;
        }
    }
}
