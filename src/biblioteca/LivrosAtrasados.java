package biblioteca;

import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.springframework.scheduling.annotation.Scheduled;

import biblioteca.dao.EmprestimoDao;
import biblioteca.dominio.Emprestimo;

public class LivrosAtrasados {
	@Scheduled(cron="0 0 4 * * *")
	public void RelatarAtrasos() {
		EmprestimoDao emprestimoDao = new EmprestimoDao();
		List<Emprestimo> emprestimos = emprestimoDao.atrasados();
		StringBuilder livros = montarTabela(emprestimos);
		System.out.println(livros);
		SendMailSSL sendmail = new SendMailSSL();
		sendmail.send("admin@biblioteca.com", "Livros Atrasados", livros.toString());
	}
	
	private StringBuilder montarTabela(List<Emprestimo> emprestimos) {
		StringBuilder sb = new StringBuilder();
		sb.append("Livros atrasados\n");
		for(Emprestimo e: emprestimos) {
			sb.append(e.getLivro().getTitulo());
			sb.append("\t");
			sb.append(e.getDataEmprestimo().toString());
			sb.append("\t");
			sb.append(e.getDataDevolucao().toString());
			sb.append("\n");
		}
		return sb;
	}
}