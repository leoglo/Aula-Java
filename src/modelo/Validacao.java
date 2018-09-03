package modelo;

import java.util.List;

public class Validacao
{
    public String Mensagem;
    public int id;
    
    public void ValidarDadosPessoa(List<String> DadosPessoa){
        
        this.Mensagem = "";
        if(DadosPessoa.get(1).length()> 30 ){
            this.Mensagem += "O nome só pode ter até trinta Caracteres";
        }
        if (DadosPessoa.get(2).length()> 10)
        {
            this.Mensagem += "O RG só pode ter até dez Caracteres";
        }
        if (DadosPessoa.get(3).length()> 13)
        {
            this.Mensagem += "O CPF só pode ter até treze Caracteres";
        }
        try
        {
            this.id = Integer.parseInt(DadosPessoa.get(0));
        }
        catch (Exception e)
        {
            this.Mensagem +="Erro de ID";
        }
    }
    
}
