package br.edu.ufal.aracomp.graphQLteste.aluno;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.edu.ufal.aracomp.graphQLteste.turma.TurmaService;

@Component
public class AlunoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver{
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private AlunoService alunoService;
	
	public Aluno aluno(Long id) {
		return alunoService.findById(id);
	}
	
	public List<Aluno> alunos(){
		return alunoService.findAll();
	}
	
	public Aluno saveAluno(AlunoInput input) {
		ModelMapper m = new ModelMapper();
		
		Aluno aluno = m.map(input, Aluno.class);
		
		aluno.setTurma(turmaService.findById(input.getTurmaId()));
		return alunoService.save(aluno);
	}
	
	public boolean deleteAluno(Long id) {
		return alunoService.deleteById(id);
	}
}
