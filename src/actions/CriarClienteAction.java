package actions;

import model.PessoaFisica;
import model.PessoaJuridica;

public interface CriarClienteAction {

	public void actionPerformed(PessoaJuridica cliente);
	public void actionPerformed(PessoaFisica cliente);

}
