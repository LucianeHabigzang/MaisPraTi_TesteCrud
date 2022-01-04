
/**
 * Classe com dados basicos de um aluno
 * 
 * @author Luciane Habigzang
 * @version (1.0)
 */
public class Aluno extends Pessoa
{
    private Integer notaFinal;
	
    
    public Aluno() {
		super();
        this.notaFinal = 0;
    }
    
    public Aluno(String nome, String telefone, String dtNascimento, String dtCadastro, String dtAlteracao, Integer notaFinal) {
		super(nome, telefone, dtNascimento, dtCadastro, dtAlteracao);
        this.notaFinal = notaFinal;
    }
    
    public void setNotaFinal(Integer notaFinal) {
        this.notaFinal = notaFinal;
    }
    public Integer getNotaFinal() {
        return this.notaFinal;
    }
}
