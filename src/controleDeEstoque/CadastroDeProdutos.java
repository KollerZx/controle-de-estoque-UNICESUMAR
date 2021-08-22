package controleDeEstoque;


public class CadastroDeProdutos {
    private Produto[] listaDeProdutos;
    private int qtdProdutos;

    public CadastroDeProdutos(int capacidade){
        this.listaDeProdutos = new Produto[capacidade];
        this.qtdProdutos = 0;
    }

    public Produto[] getListaDeProdutos(){
        return this.listaDeProdutos;
    }

    public void addProduto(Produto elemento) throws Exception {
        // Verifica se há espaço no estoque para mais produtos
        if((this.qtdProdutos < this.listaDeProdutos.length) && (this.findProduct(elemento.getNome()) == -1)){
            this.listaDeProdutos[this.qtdProdutos] = elemento;
            this.qtdProdutos++;
        }else{
            throw new Exception("Não foi possivel adicionar o Produto, verifique se já não existe um produto com mesmo nome, ou se há espaço no estoque");
        }

    }

    public int findProduct(String name){
        if(this.qtdProdutos == 0){ return -1; }
        for(int i=0; i < this.qtdProdutos; i++ ){
            if(this.listaDeProdutos[i].getNome().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    public static void menu(){
        System.out.println("CADASTRO DE PRODUTOS:");
        System.out.println("1.1 - INCLUSÃO");
        System.out.println("1.2 - ALTERAÇÃO");
        System.out.println("1.3 - CONSULTA");
        System.out.println("1.4 - EXCLUSÃO");
        System.out.println("0 - RETORNAR");

        System.out.println("OPÇÃO: ");

    }




}
