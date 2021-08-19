package controleDeEstoque;

public class CadastroDeProdutos extends Produto{
    private int qtdEstoque;
    private EstoqueDeProdutos estoque;

    public CadastroDeProdutos(Produto produto) {
        this.estoque = new EstoqueDeProdutos(produto);
    }
    public int getQtdEstoque(){
        return this.qtdEstoque;
    }

    public void getProduto(){
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + getPrecoUnitario());
        System.out.println("Unidade: " + getUnidade());
        System.out.println("Quantidade: " + getQtdEstoque());
    }


}
