package tests;

import controleDeEstoque.CadastroDeProdutos;
import controleDeEstoque.Produto;

public class Teste {
    public static void main(String[] args) throws Exception {

        try {
            CadastroDeProdutos estoque = new CadastroDeProdutos(5);

            estoque.addProduto(new Produto("Camiseta", 25, 1,10));
            estoque.addProduto(new Produto("camiseta", 27, 1, 60));
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
