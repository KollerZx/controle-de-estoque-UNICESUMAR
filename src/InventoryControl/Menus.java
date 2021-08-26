package InventoryControl;

public class Menus {
    public static void menuMain(){
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n" +
                            "SISTEMA DE CONTROLE DE ESTOQUE\n");
        System.out.println("MENU PRINCIPAL");
        System.out.println("1 - CADASTRO DE PRODUTOS");
        System.out.println("2 - MOVIMENTAÇÃO");
        System.out.println("3 - REAJUSTE DE PREÇOS");
        System.out.println("4 - RELATÓRIOS");
        System.out.println("0 - FINALIZAR \n");
        System.out.print("OPÇÃO: ");
    }

    public static void menuRegister(){
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n" +
                            "SISTEMA DE CONTROLE DE ESTOQUE\n");
        System.out.println("CADASTRO DE PRODUTOS:");
        System.out.println("1.1 - INCLUSÃO");
        System.out.println("1.2 - ALTERAÇÃO");
        System.out.println("1.3 - CONSULTA");
        System.out.println("1.4 - EXCLUSÃO");
        System.out.println("0 - RETORNAR");

        System.out.println("OPÇÃO: ");

    }

    public static void menuInventoryMovement(){
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\n" +
                            "SISTEMA DE CONTROLE DE ESTOQUE\n");
        System.out.println("MOVIMENTAÇÃO:");
        System.out.println("1 - ENTRADA");
        System.out.println("2 - SAÍDA");
        System.out.println("0 - RETORNAR");
        System.out.println("OPÇÃO: ");
    }
}
