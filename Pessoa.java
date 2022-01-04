
/**
 * Classe com dados basicos de uma pessoa
 * 
 * @author Luciane Habigzang
 * @version (1.0)
 */
 
import java.time.LocalDate; // import the LocalDateTime class
import java.time.format.DateTimeFormatter;

public class Pessoa
{
    private String nome;
	private String telefone;
    private LocalDate dtNascimento;
    private LocalDate dtCadastro;
	private LocalDate dtAlteracao;
    
    public Pessoa() {
        this.nome = "Pessoa";
		this.telefone = "(00)00000-0000";
        this.dtNascimento = geraData("00/00/0000");
        this.dtCadastro = LocalDate.now();
		this.dtAlteracao = LocalDate.now();
    }
    
    public Pessoa(String nome, String telefone, String dtNascimento, String dtCadastro, String dtAlteracao) {
        this.nome = nome;
		this.telefone = telefone;
        this.dtNascimento = geraData(dtNascimento);
        this.dtCadastro = geraData(dtCadastro);
		this.dtAlteracao = geraData(dtAlteracao);
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }
	
	public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    public LocalDate getDtNascimento() {
        return this.dtNascimento;
    }
    
    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
    public LocalDate getDtCadastro() {
        return this.dtCadastro;
    }
	public void setDtAlteracao(LocalDate dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }
    public LocalDate getDtAlteracao() {
        return this.dtAlteracao;
    }
	public LocalDate geraData(String data) {
		try{
			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			return LocalDate.parse(data, formatterData);
			
		} catch (Exception e) {
			System.out.println("Data de nascimento invalida, edite o cadastro (dd/mm/aaaa) ");
			return LocalDate.now();
		}
	}
}
