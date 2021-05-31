package br.edu.ufal.aracomp.graphQLteste;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ufal.aracomp.graphQLteste.aluno.Aluno;
import br.edu.ufal.aracomp.graphQLteste.aluno.AlunoRepository;
import br.edu.ufal.aracomp.graphQLteste.turma.Turma;
import br.edu.ufal.aracomp.graphQLteste.turma.TurmaRepository;


@Component
public class DataLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private TurmaRepository turmaRepository;
	
	@Override
	public void run(String... args) throws Exception {

		logger.info("Carregando dados de teste na inicialização...");

		this.dadosTurmas();
		this.dadosAlunos();

		logger.info("Alunos carregadas: {}", alunoRepository.count());
		logger.info("Turmas carregadas: {}", turmaRepository.count());

		logger.info("Finalizando teste na inicialização...");
	}
	
	private void dadosTurmas() {
		Turma t1 = new Turma("511-A");
		Turma t2 = new Turma("411-A");
		Turma t3 = new Turma("211-A");
		
		turmaRepository.save(t1);
		turmaRepository.save(t2);
		turmaRepository.save(t3);
		
	}

	private void dadosAlunos() {
		
		Turma turm1 = turmaRepository.findById(1L).orElse(null);
		Turma turma2 = turmaRepository.findById(2L).orElse(null);
		
		Aluno a1 = new Aluno("Biu", "Ciência da Computação");
		a1.setTurma(turm1);
		Aluno a2 = new Aluno("Zé", "Ciência da Computação");
		a2.setTurma(turm1);
		Aluno a3 = new Aluno("Mark", "Letras");
		a3.setTurma(turma2);
		Aluno a4 = new Aluno("Renata", "Letras");
		a4.setTurma(turma2);
		
		alunoRepository.save(a1);
		alunoRepository.save(a2);
		alunoRepository.save(a3);
		alunoRepository.save(a4);
		
	}

}