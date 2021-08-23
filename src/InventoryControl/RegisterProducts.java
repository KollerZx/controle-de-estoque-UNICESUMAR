package InventoryControl;


public class RegisterProducts {
    private Product[] listaDeProdutos;
    private int qtdProdutos;

    public RegisterProducts(int capacidade){
        this.listaDeProdutos = new Product[capacidade];
        this.qtdProdutos = 0;
    }

    public Product[] getListProduct(){
        return this.listaDeProdutos;
    }

    public void addProduct(Product elemento){
        try{

            if(checkEstoqueAvailable() && !productNameAlreadyExists(elemento)){
                this.listaDeProdutos[this.qtdProdutos] = elemento;
                this.qtdProdutos++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void updateProduct(int index, float price, int unit, int qtd){
        try{
            this.listaDeProdutos[index].setPriceUnit(price);
            this.listaDeProdutos[index].setUnit(unit);
            this.listaDeProdutos[index].setQtdInventory(qtd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeProduct(String nome){

    }

    public int findProductByName(String name){
        if(this.qtdProdutos == 0){ return -1; }
        for(int i=0; i < this.qtdProdutos; i++ ){
            if(this.listaDeProdutos[i].getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    private boolean productNameAlreadyExists(Product elemento) throws Exception{
        var productExists = false;
        if(this.findProductByName(elemento.getName()) > -1){
            productExists = true;
            throw new Exception("Já existe um produto cadastrado com o mesmo nome");
        }
        return productExists;
    }

    private boolean checkEstoqueAvailable() throws Exception {
        var isValid = true;

        if(this.qtdProdutos > this.listaDeProdutos.length) {
            isValid = false;
            throw new Exception("Não foi possivel cadastrar o produto, pois não há mais espaço em estoque");
        }
        return isValid;

    }

    public static void menuRegister(){
        System.out.println("CADASTRO DE PRODUTOS:");
        System.out.println("1.1 - INCLUSÃO");
        System.out.println("1.2 - ALTERAÇÃO");
        System.out.println("1.3 - CONSULTA");
        System.out.println("1.4 - EXCLUSÃO");
        System.out.println("0 - RETORNAR");

        System.out.println("OPÇÃO: ");

    }





}
