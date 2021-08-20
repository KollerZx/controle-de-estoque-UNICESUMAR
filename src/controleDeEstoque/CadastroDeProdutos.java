package controleDeEstoque;


import java.util.Scanner;

public class CadastroDeProdutos extends Produto{


    public CadastroDeProdutos(String nome, float precoUnitario, int unidade, int qtdEstoque) {

        super(nome, precoUnitario, unidade, qtdEstoque);

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
