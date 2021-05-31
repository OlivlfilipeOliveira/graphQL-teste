package br.edu.ufal.aracomp.graphQLteste.aluno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufal.aracomp.graphQLteste.turma.Turma;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	List<Aluno> findAllByTurma(Turma t);

}
