package controleDeEstoque;

public class Produto {
    protected String nome;
    protected float precoUnitario;
    protected int unidade;
    private int qtdEstoque;

    public Produto(String nome, float precoUnitario, int unidade, int qtdEstoque){
        setNome(nome);
        setPrecoUnitario(precoUnitario);
        setUnidade(unidade);
        setQtdEstoque(qtdEstoque);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getNome() {
        return this.nome;
    }

    public float getPrecoUnitario() {
        return this.precoUnitario;
    }

    public int getUnidade() {
        return this.unidade;
    }

    public int getQtdEstoque() {
        return this.qtdEstoque;
    }

    public void getProduto(){
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: " + getPrecoUnitario());
        System.out.println("Unidade: " + getUnidade());
        System.out.println("Quantidade: " + getQtdEstoque());
        System.out.println();
    }
}
