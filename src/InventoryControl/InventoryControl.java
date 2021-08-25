package InventoryControl;

import java.util.Scanner;

public class InventoryControl {
    /* QUANTIDADE DE TIPOS DE PRODUTOS QUE A EMPRESA TRABALHA
    *  TEM POR FINALIDADE DELIMITAR O CADASTRO DE 10 TIPOS DE PRODUTOS,
    *  VALOR ESSE QUE PODERÁ SER ALTERADO CASO SE INCLUA UM NOVO TIPO / DEPARTAMENTO
    * */
    static int DEPARTAMENTS = 10;

    public static void main(String[] args) throws Exception {

        try{
            int opcao=9;
            Scanner scan = new Scanner(System.in);
            /* CRIA UM ESTOQUE, QUE PODERÁ CONTER 10 DE TIPOS DE PRODUTOS, QUE SÃO SEPARADOS POR DEPARTAMENTO*/
            RegisterProducts estoque = new RegisterProducts(DEPARTAMENTS);
            while(opcao!=0){
                Menus.menuMain();
                opcao = scan.nextInt();
                scan.nextLine();
                switch (opcao){
                    case 0:
                        System.out.println("Deseja realmente sair do programa?");
                        String option =scan.next();
                        if(Controllers.confirmOperation(option)){
                            continue;
                        }
                        opcao = 1;
                        break;
//                  CADASTRO DE PRODUTOS
                    case 1:
                        Menus.menuRegister();
                        opcao = scan.nextInt();
//                      INCLUSÃO DE PRODUTO
                        if(opcao == 1){
                            Controllers.includeProduct(estoque);
                            break;
                        }
//                      ALTERAÇÃO DE PRODUTO
                        else if(opcao == 2){
                            Controllers.changeProduct(estoque);
                            break;
                        }
//                      CONSULTA PRODUTO POR NOME
                        else if(opcao == 3){
                            Controllers.findProduct(estoque);
                            break;
                        }
//                      EXCLUSÃO DE PRODUTO
                        else if(opcao == 4){
                            Controllers.removeProduct(estoque);
                            break;
                        }
//                      RETORNAR AO MENU ANTERIOR
                        else if(opcao == 0){
                            opcao = 1;
                            continue;
                        }
                        // -----------------------------------------------------//

//                  MOVIMENTAÇÃO
                    case 2:
                        Menus.menuInventoryMovement();
                        opcao = scan.nextInt();
//                      RETORNAR
                        if(opcao == 0){
                            opcao = 1;
                            continue;
                        }
//                      ENTRADA
                        else if(opcao == 1){
                            Controllers.inputStock(estoque);
                            break;
                        }
//                      SAÍDA
                        else if(opcao == 2){
                            Controllers.outputStock(estoque);
                            break;
                        }

//                  REAJUSTE DE PREÇOS
                    case 3:
                        Controllers.percentPriceAdjust(estoque);
                        break;

                    default:
                        System.out.println("Escolha uma opção válida");
                        break;
                }
            };
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}