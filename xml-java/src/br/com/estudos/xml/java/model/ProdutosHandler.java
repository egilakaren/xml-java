package br.com.estudos.xml.java.model;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ProdutosHandler extends DefaultHandler{

	private List<Produto> produtos = new ArrayList<>();
	private StringBuilder conteudo;
	private Produto produto;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("produto"))
			produto = new Produto();
		conteudo = new StringBuilder(); 
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		conteudo.append(new String(ch, start, length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("produto"))
			produtos.add(produto);
		else if(qName.equals("nome"))
			produto.setNome("nome");
		else if(qName.equals("preco"))
			produto.setPreco(Double.parseDouble(conteudo.toString()));
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public StringBuilder getConteudo() {
		return conteudo;
	}

	public void setConteudo(StringBuilder conteudo) {
		this.conteudo = conteudo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
