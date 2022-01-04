import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TesteCrud
{
    public static void main(String[] args) 
    {
        Aluno a1 = new Aluno("Luciane Cunha", "(46) 99124-3022", "26/11/1981", "02/01/2022", "02/01/2022", 80);
        Aluno a2 = new Aluno("Alex Habigzang", "(41) 98803-7362", "12/11/1977", "02/01/2022", "02/01/2022", 90);
		
        Pessoa p1 = new Pessoa("Daniela Habigzang", "(46) 99124-3022", "12/11/1977", "02/01/2022", "02/01/2022");
        
        List<Aluno> alunos = new ArrayList<Aluno>();
		
        alunos.add(a1);
        alunos.add(a2);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		pessoas.add(p1);
        
		String op;
		
		
		while (true) {
			op = imprimirMenu();
			if (op.equals("1")){
				cadastrar(alunos, pessoas);
			} else if (op.equals("2")){
				deletar(alunos, pessoas);
			} else if (op.equals("3")){
				editar(alunos, pessoas);
			} else if (op.equals("4")){
				imprimirAlunos(alunos);
			} else if (op.equals("5")){
				imprimirPessoas(pessoas);
			} else if (op.equals("9")){
				break;
			} else {
				break;
			}
		}
    }
	
	public static void cadastrar(List<Aluno> alunos, List<Pessoa> pessoas) {
		String nome;
		String telefone;
		String dtNascimento;
		String nota;
		String opCad;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("****Cadastrar*****");
		System.out.println("Digite o nome:");
		nome = teclado.nextLine();
		System.out.println("Digite o telefone:");
		telefone = teclado.nextLine();
		System.out.println("Digite a data de nascimento:");
		dtNascimento = teclado.nextLine();
		
		while(!(dtNascimento.matches("^([0-9]{2})/([0-9]{2})/([0-9]{4})$"))){
			System.out.println("Data invalida, digite novamente (dd/mm/aaaa) :");
			dtNascimento = teclado.nextLine();
		}
		
		System.out.println("Deseja informar a nota final? s/n");
		opCad = teclado.nextLine();
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String data = date.format(formatterData);
		
		if (opCad.equals("s")){
			System.out.println("Digite a nota final do curso:");
			nota = teclado.nextLine();
			Aluno aluno = new Aluno(nome, telefone, dtNascimento, data, data, Integer.parseInt(nota));
			alunos.add(aluno);
		} else {
			Pessoa pes = new Pessoa(nome, telefone, dtNascimento, data, data);
			pessoas.add(pes);
		}
		System.out.println("Cadastro efetuado com sucesso.");
    }
	
	public static void deletar(List<Aluno> alunos, List<Pessoa> pessoas) {
		Scanner teclado = new Scanner(System.in);
		String codigo;
		String bus;
		Integer index;
		Aluno alunoDel;
		Pessoa pessoaDel;
		
		System.out.println("****Deletar*****");
		System.out.println("Digite o codigo que deseja excluir:");
		codigo = teclado.nextLine();
		
		if (codigo.startsWith("P")) {
			bus = codigo.replace("P", "");
			index = Integer.parseInt(bus);
			
			if(!(index <= pessoas.size())) {
				System.out.println("Codigo invalido.");
			}
			pessoaDel = pessoas.get(index);
			pessoas.remove(pessoaDel);
			
			System.out.println("Deletado com sucesso.");
			
			
		} else if(codigo.startsWith("A")){
			bus = codigo.replace("A", "");
			index = Integer.parseInt(bus);
			
			if(!(index <= alunos.size())) {
				System.out.println("Codigo invalido.");
			}
			alunoDel = alunos.get(index);
			alunos.remove(alunoDel);
			
			System.out.println("Deletado com sucesso.");
			
		} else {
			System.out.println("Codigo invalido.");
		}
	}
	
	public static void editar(List<Aluno> alunos, List<Pessoa> pessoas) {
		Scanner teclado = new Scanner(System.in);
		String codigo;
		String bus;
		Integer index;
		Aluno alunoEdit;
		Pessoa pessoaEdit;
		
		System.out.println("****Editar*****");
		System.out.println("Digite o codigo que deseja editar:");
		codigo = teclado.nextLine();
		
		LocalDate data = LocalDate.now();
		
		if (codigo.startsWith("P")) {
			bus = codigo.replace("P", "");
			index = Integer.parseInt(bus);
			
			if(!(index <= pessoas.size())) {
				System.out.println("Codigo invalido.");
			}
			pessoaEdit = pessoas.get(index);
			
			System.out.println("Editar nome: " + pessoaEdit.getNome());
			System.out.println("Digite o novo nome:");
			pessoaEdit.setNome(teclado.nextLine());
			System.out.println("Editar telefone: " + pessoaEdit.getTelefone());
			System.out.println("Digite o novo telefone:");
			pessoaEdit.setTelefone(teclado.nextLine());
			pessoaEdit.setDtAlteracao(data);
			System.out.println("Edicao efetuada com sucesso.");
			
		} else if(codigo.startsWith("A")){
			bus = codigo.replace("A", "");
			index = Integer.parseInt(bus);
			
			if(!(index <= alunos.size())) {
				System.out.println("Codigo invalido.");
			}
			alunoEdit = alunos.get(index);
			
			System.out.println("Editar nome: " + alunoEdit.getNome());
			System.out.println("Digite o novo nome:");
			alunoEdit.setNome(teclado.nextLine());
			System.out.println("Editar telefone: " + alunoEdit.getTelefone());
			System.out.println("Digite o novo telefone:");
			alunoEdit.setTelefone(teclado.nextLine());
			alunoEdit.setDtAlteracao(data);
			System.out.println("Edicao efetuada com sucesso.");
			
		} else {
			System.out.println("Codigo invalido.");
		}
	}
	
    public static void imprimirAlunos(List<Aluno> lista) {
		int i = 0;
		
		System.out.println(lista.size() + " Alunos Cadastrados:");
		//Collections.sort(lista, Comparator.comparing(Aluno::getNome).thenComparing(Aluno::getNome));
        for (Aluno aluno : lista) {
			System.out.println("Codigo | Nome do aluno | Telefone | Nota Final");
            System.out.println("A" + i + " | " + aluno.getNome() + " | " + aluno.getTelefone() + " | " + aluno.getNotaFinal());
			i++;
        }
    }
	
	public static void imprimirPessoas(List<Pessoa> lista) {
		int i = 0;
		
		System.out.println(lista.size() + " Pessoas Cadastradas:");
		Collections.sort(lista, Comparator.comparing(Pessoa::getNome).thenComparing(Pessoa::getNome));
        for (Pessoa pessoa : lista) {
			System.out.println("Codigo | Nome da pessoa | Telefone ");
            System.out.println("P" + i + " | " + pessoa.getNome() + " | " + pessoa.getTelefone());
			i++;
        }
    }
	
	public static String imprimirMenu() {
		Scanner teclado = new Scanner(System.in);
		String opMenu;
		System.out.println("********************MENU********************************");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Deletar");
		System.out.println("3 - Editar");
		System.out.println("4 - Listar Alunos");
		System.out.println("5 - Listar Pessoas");
		System.out.println("9 - Sair");
		
		System.out.println("Digite a opcao desejada: ");
		opMenu = teclado.nextLine();
		
		return opMenu; 
	}
}
