package pedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido extends Operacao {
	
	public Pedido(Date inicio, Date fim) {
		super(inicio, fim);
	}


	private int codigo;
	Vendedor vendedor;
	Cliente cliente;
	List<Produto> listaProduto =new ArrayList<Produto>();
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Produto> getListaProduto() {
		return listaProduto;
	}
	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
	
	public boolean verificaProdutoUnico(Produto produto) {
		for (Produto produtoLista : listaProduto) {
			if (produto.getDescricao().equalsIgnoreCase(produtoLista.getDescricao())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	public double totalPedido() {
		double somatoria = 0;
		for (Produto produtoList : listaProduto) {
			somatoria += produtoList.totalItem(); 
		}
		return somatoria;
	}

	public boolean addProduto(Produto produto) {
		if(verificaProdutoUnico(produto) == true) {
			return true;
		}else {
			listaProduto.add(produto);
			return false;
		}
	}
	public double valorMedio() {
		double quantidadeProduto = 0;
		double somatoria= 0;
		for (Produto produtoList : listaProduto) {
			somatoria += produtoList.getValor();
			quantidadeProduto++;
		}
		return (somatoria/quantidadeProduto);
	}
	 public List<Produto> quantidadeMaior(int quantidade){
		 List<Produto> listaProdutoAuxiliar =new ArrayList<Produto>();
		 for (Produto produtoList : listaProduto) {
				if(produtoList.getQuantidade() > quantidade) {
					listaProdutoAuxiliar.add(produtoList);
				}
			}
		return listaProdutoAuxiliar;
	 }
	 public String nomeVendedor() {
		 return vendedor.getNome();
	 }
	 public String emailCliente() {
		 return cliente.getEmail();
	 }
	 public List<Produto> buscaProdutoDescricao(String descricao){
		 List<Produto> listaProdutoAuxiliar =new ArrayList<Produto>();
		 for (Produto produtoList : listaProduto) {
				if(produtoList.getDescricao().startsWith(descricao)) {
					listaProdutoAuxiliar.add(produtoList);
				}
			}
		 return listaProdutoAuxiliar;
	 }
	 public int dias() {
		 long inicio =getDtInicio().getTime();
		 long fim = getDtFim().getTime();
		 int dias = (int) ((((fim-inicio)/1000)/60)/60)/24;
		 return dias;
	 }
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [codigo=");
		builder.append(codigo);
		builder.append(", vendedor=");
		builder.append(vendedor);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append(", listaProduto=");
		builder.append(listaProduto);
		builder.append("]");
		return builder.toString();
	}
	
}
