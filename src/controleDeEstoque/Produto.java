package controleDeEstoque;

public class Produto {
    protected String nome;
    protected float precoUnitario;
    protected int unidade;


    /*
    public Produto(String nome, float precoUnitario, int unidade){
        setNome(nome);
        setPrecoUnitario(precoUnitario);
        setUnidade(unidade);
    }
    *
     */

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
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
}
