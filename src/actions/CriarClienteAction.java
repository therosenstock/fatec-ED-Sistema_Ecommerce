package actions;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;
import model.TipoProduto;

public interface CriarClienteAction {

	public void actionPerformed(PessoaJuridica cliente);
	public void actionPerformed(PessoaFisica cliente);

}
