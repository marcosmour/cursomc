package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonIgnore // PARA O PROGRAMA NEM OLHAR PARA ESSE CARA. ELE NÃO IRA SEREALIZAR NEM O PEDIDO NEM O PRODUTO
	@EmbeddedId // DEVIDO SER UMA CLASSE AUXILIAR QUE PEGA DOIS IDS
	private ItemPedidoPK id = new ItemPedidoPK(); // A CLASSE ITEMPEDIDOPK ESTA PEGANDO OS IDS DA CLASSE PRODUTO E PEDIDO // DEVE SER INSTANCIADA POIS E UMA CLASSE AUXILIAR // CHAVE COMPOSTA
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {
	}

	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) { // FOI ACRESSENTADO PEDIDO E PRODUTO E TIRADO ITEMPEDIDO. FOI ALTERADO TAMBEM O CORPO DO CONSTRUTOR
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonIgnore // AO COLOCAR ESSE CODIGO NÃO APARECERA O JSON NO POSTMAN.
	public Pedido getPedido() { // CRIADO MANUALMENTE
		return id.getPedido();
	}
	
	
	public Produto getProduto() { // CRIADO MANUALMENTE
		return id.getProduto();
	}

	public ItemPedidoPK getId() {
		return id;
	}

	public void setId(ItemPedidoPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
