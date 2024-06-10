package actions;

import model.PessoaFisica;
import model.PessoaJuridica;

public interface RemoverClienteAction {

	public void actionPerformed(PessoaJuridica cliente);
	public void actionPerformed(PessoaFisica cliente);
}
