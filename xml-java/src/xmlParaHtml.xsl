<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="venda">
		<h2>Venda</h2>
		<p>Forma de pagamento: <xsl:value-of select="formaDePagamento" /></p>
		<xsl:apply-templates select="produtos" />
	</xsl:template>
	
	<xsl:template match="produtos">
		<xsl:apply-templates select="produto" />
	</xsl:template>
	
	<xsl:template match="produto">
		<h3>Nome: <xsl:value-of select="nome" /></h3>
		<h3>R$: <xsl:value-of select="preco" /></h3>
	</xsl:template>
</xsl:stylesheet>