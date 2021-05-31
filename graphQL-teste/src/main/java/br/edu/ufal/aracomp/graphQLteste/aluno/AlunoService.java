package br.edu.ufal.aracomp.graphQLteste.aluno;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufal.aracomp.graphQLteste.turma.Turma;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public Aluno findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Aluno> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Aluno save(Aluno aluno) {
		return repository.save(aluno);
	}

	@Transactional
	public boolean deleteById(Long id) {
		Aluno a = repository.findById(id).orElse(null);
		if(a!=null) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	public List<Aluno> findAllByTurma(Turma t) {
		return repository.findAllByTurma(t);
	}

}
