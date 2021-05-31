package br.edu.ufal.aracomp.graphQLteste.aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import br.edu.ufal.aracomp.graphQLteste.turma.Turma;
import br.edu.ufal.aracomp.graphQLteste.turma.TurmaService;

@Component
public class AlunoResolver implements GraphQLResolver<Aluno>{
	
	@Autowired
	private TurmaService turmaService;
	
	public Turma turma(Aluno a) {
		if(a.getTurma()==null) {
			System.out.println("Ok");
		}else {
			System.out.println("Não tá");
		}
		return turmaService.findById(a.getTurma().getId());
	}
}
