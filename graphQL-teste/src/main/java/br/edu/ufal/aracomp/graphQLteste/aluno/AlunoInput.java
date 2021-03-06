package br.edu.ufal.aracomp.graphQLteste.aluno;

public class AlunoInput {

	private Long id;

	private String nome;

	private String curso;
	
	private Long turmaId;

	public AlunoInput() {
	}

	public AlunoInput(Long id, String nome, String curso) {
		this.id = id;
		this.nome = nome;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public Long getTurmaId() {
		return turmaId;
	}
	
	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
	}

}
