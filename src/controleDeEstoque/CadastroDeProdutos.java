package controleDeEstoque;


import java.util.Scanner;

public class CadastroDeProdutos {
    private Produto[] listaDeProdutos;
    private int qtdProdutos;
    /*
   public CadastroDeProdutos(String nome, float precoUnitario, int unidade, int qtdEstoque) {

       super(nome, precoUnitario, unidade, qtdEstoque);

   }
   */


    public CadastroDeProdutos(int capacidade){
        this.listaDeProdutos = new Produto[capacidade];
        this.qtdProdutos = 0;
    }

    public Produto[] getListaDeProdutos(){
        return this.listaDeProdutos;
    }

    public void addProduto(Produto elemento) throws Exception {
        // Verifica se há espaço no estoque para mais produtos
        if(this.qtdProdutos < this.listaDeProdutos.length){
            this.listaDeProdutos[this.qtdProdutos] = elemento;
            this.qtdProdutos++;
        }else{
            throw new Exception("Não há mais espaço no estoque da empresa");
        }

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

    public static int findProduct(Produto elemento[], String name){
        for(int i=0; i < elemento.length; i++ ){
            if(elemento[i].getNome() == name){
                return i;
            }
        }
        return -1;
    }


}
