package br.edu.ufal.aracomp.graphQLteste.turma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import br.edu.ufal.aracomp.graphQLteste.aluno.Aluno;
import br.edu.ufal.aracomp.graphQLteste.aluno.AlunoService;

@Component
public class TurmaResolver implements GraphQLResolver<Turma>{
	
	@Autowired
	private AlunoService alunoService;
	
	public List<Aluno> alunos(Turma t){
		return alunoService.findAllByTurma(t);
	}

}
