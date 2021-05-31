package br.edu.ufal.aracomp.graphQLteste.turma;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class TurmaGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver{

	@Autowired
	private TurmaService service;
	
	public Turma turma(Long id) {
		return service.findById(id);
	}
	
	public List<Turma> turmas(){
		return service.findAll();
	}
	
	public Turma saveTurma(TurmaInput input) {
		ModelMapper m = new ModelMapper();
		
		Turma turma = m.map(input, Turma.class);
		
		return service.save(turma);
	}
	
	public boolean deleteTurma(Long id) {
		return service.deleteById(id);
	}
}
