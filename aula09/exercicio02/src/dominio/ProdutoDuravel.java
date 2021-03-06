package dominio;

import java.time.LocalDate;

public class ProdutoDuravel extends Produto{

    private String materialPredominante;
    private int durabilidade;

    /**
     * Construtor para objetos da classe ProdutoDuravel
     * @param nome Nome do produto.
     * @param preco Preco do produto.
     * @param marca Marca do produto.
     * @param descricao Descrição do produto.
     * @param dataFabricacao Data de fabricação do produto.
     * @param material Material predominante no produto.
     * @param durabilidade Durabilidade do produto.
     */ 
    public ProdutoDuravel( String nome, double preco, String marca, String descricao, LocalDate dataFabricacao, String material, int durabilidade ) {
	super( nome, preco, marca, descricao, dataFabricacao);
	this.materialPredominante = material;
	this.durabilidade = durabilidade;
    }

    /**
     * Retorna material predominante;
     * @return Material predominando no produto.
     */
    public String getMaterialPredominante(){
	return materialPredominante;
    }

    /**
     * Atualiza material predominante.
     * @param material Material predominando no produto.
     */
    public void setMaterialPredominante( String material ){
	this.materialPredominante = material;
    }

    /**
     * Retorna durabilidade do produto
     * @return Durabilidade do produto.
     */
    public int getDurabilidade() {
	return durabilidade;
    }

    /**
     * Atualiza durabilidade do produto
     * @param durabilidade Descrição do produto.
     */
    public void setDurabilidade( int durabilidade) { 
	this.durabilidade = durabilidade;
    }
}
