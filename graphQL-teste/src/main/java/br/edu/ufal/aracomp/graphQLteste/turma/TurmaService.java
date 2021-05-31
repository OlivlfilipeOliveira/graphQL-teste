package br.edu.ufal.aracomp.graphQLteste.turma;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;
	
	public Turma findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Turma> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Turma save(Turma turma) {
		return repository.save(turma);
	}

	@Transactional
	public boolean deleteById(Long id) {
		Turma t = repository.findById(id).orElse(null);
		
		if(t!=null) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

}
