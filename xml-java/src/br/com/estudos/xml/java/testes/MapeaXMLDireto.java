package br.com.estudos.xml.java.testes;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import br.com.estudos.xml.java.model.Produto;
import br.com.estudos.xml.java.model.Venda;

public class MapeaXMLDireto {

	public static void main(String[] args) throws Exception {
		JAXBContext jaxb = JAXBContext.newInstance(Venda.class);
		xmlParaObjeto(jaxb);
		objetoParaXml(jaxb);
	}
	
	private static void objetoParaXml(JAXBContext jaxb) throws Exception {
		Marshaller marshaller = jaxb.createMarshaller();
		
		Venda venda = new Venda();
		venda.setFormaDePagamento("Crediario");
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Livro de java", 59.90));
		produtos.add(new Produto("Livro de xml", 59.90));
		produtos.add(new Produto("Livro de o.o", 59.90));
		
		venda.setProdutos(produtos);
		
		StringWriter writer = new StringWriter();
		marshaller.marshal(venda, writer);
		
		System.out.println(writer);
	}

	private static void xmlParaObjeto(JAXBContext jaxb) throws Exception {
		Unmarshaller unmarshaller = jaxb.createUnmarshaller();
		Venda venda = (Venda) unmarshaller.unmarshal(new File("src/vendas.xml"));
		System.out.println(venda);
	}
}
