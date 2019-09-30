package pedido;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.DAY_OF_MONTH, 20);
		calendario.set(Calendar.MONTH, 9);
		calendario.set(Calendar.YEAR, 2019);
		Date dataInicio= new Date();
		dataInicio = calendario.getTime();
		
		Calendar calendario1 = Calendar.getInstance();
		calendario1.set(Calendar.DAY_OF_MONTH, 25);
		calendario1.set(Calendar.MONTH, 9);
		calendario1.set(Calendar.YEAR, 2019);
		Date dataFim= new Date();
		dataFim = calendario1.getTime();
		
		Pedido pedido = new Pedido(dataInicio, dataFim);
		Produto produto = new Produto(1, "leite",2.50, 2);
		Produto produto2 = new Produto(1, "leite",2.50, 3);
		Produto produto3 = new Produto(2, "cafe",4.50, 3);
		Produto produtoAcucar = new Produto(3, "Acucar",5, 2);
		Produto produto4 = new Produto(4, "caldo",4.50, 3);
		
		System.out.println(pedido.addProduto(produto));
		System.out.println(pedido.addProduto(produto2));
		System.out.println(pedido.addProduto(produto3));
		System.out.println(pedido.addProduto(produtoAcucar));
		System.out.println(pedido.addProduto(produto4));
		
		System.out.println("Total ="+pedido.totalPedido());
		System.out.println("Medio ="+pedido.valorMedio());
		System.out.println(pedido.quantidadeMaior(1));
		System.out.println(pedido.buscaProdutoDescricao("ca"));
		System.out.println("dias = "+ pedido.dias());
		System.out.println(pedido.getDtFim());
		System.out.println(pedido.getDtInicio());
	}

}
