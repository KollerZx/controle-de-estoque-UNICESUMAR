package tests;

import controleDeEstoque.CadastroDeProdutos;
import controleDeEstoque.Produto;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws Exception {

        try {
            CadastroDeProdutos estoque = new CadastroDeProdutos(5);
            Scanner scan = new Scanner(System.in);
            estoque.addProduto(new Produto("camiseta",25,1,15));
            System.out.println("Digite o nome do produto que deseja consultar: ");
            String nome = scan.next();
            int indiceDoProduto = estoque.findProduct(nome);

            if(indiceDoProduto > -1){
                Produto[] listaDeProdutos = estoque.getListaDeProdutos();
                listaDeProdutos[indiceDoProduto].getProduto();
            }
            else{
                System.out.println("Não existe produto com esse nome");
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
