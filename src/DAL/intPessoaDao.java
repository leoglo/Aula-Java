package DAL;
import java.util.List;
import modelo.Pessoa;

public interface intPessoaDao
{
    public void CadastrarPessoa(Pessoa pessoa);
    public void EditarPessoa(Pessoa pessoa);
    public void ExcluirPessoa(Pessoa pessoa);
    public Pessoa PesquisarPessoaPorId(Pessoa pessoa);
    public List<Pessoa>PesquisarPessoaPorNome(Pessoa pessoa);
}
