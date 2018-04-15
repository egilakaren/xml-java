package br.com.estudos.xml.java.testes;

import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.estudos.xml.java.model.ProdutosHandler;
/***
 * Metodo de implementacao que receve informa��es do xml
 * @author Egila Karen
 */
public class LerXmlComSax {

	public static void main(String[] args) throws Exception {
		XMLReader leitor = XMLReaderFactory.createXMLReader();
		ProdutosHandler logica = new ProdutosHandler();
		leitor.setContentHandler(logica);
		InputStream ips = new FileInputStream("src/vendas.xml");
		InputSource is = new InputSource(ips);
		leitor.parse(is);
		
		System.out.println(logica.getProdutos());
	}

}
