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

    public void addProduct(Product elemento) throws Exception{
            if(!productNameAlreadyExists(elemento)){
                this.listaDeProdutos[this.qtdProdutos] = elemento;
                this.qtdProdutos++;
            }

    }

    public void updateProduct(int index, float price, int unit, int qtd) throws Exception{
        this.listaDeProdutos[index].setPriceUnit(price);
        this.listaDeProdutos[index].setUnit(unit);
        this.listaDeProdutos[index].setQtdInventory(qtd);


    }

    public void percentPriceAdjust(int index, float percent) throws Exception {
        float productPrice = this.listaDeProdutos[index].getPriceUnit();
        float percentAdd = productPrice * (percent/100);
        float priceUpdated = productPrice + percentAdd;
        this.listaDeProdutos[index].setPriceUnit(priceUpdated);
    }

    public void removeProduct(int index) throws Exception{
        if(!(index >= 0 && index < this.qtdProdutos )){
            throw new IllegalArgumentException("O produto informado não existe no estoque");
        }
        for(int position = index; position < (this.listaDeProdutos.length -1); position++){
            this.listaDeProdutos[position] = this.listaDeProdutos[position+1];
        }
        this.listaDeProdutos[this.listaDeProdutos.length - 1] = null;
        this.qtdProdutos--;
    }

    public void inputStock(int indice, int qtdProduct) throws Exception {
        if(qtdProduct == 0){
            throw new Exception("Deve-se informar um valor maior que zero para Entrada");
        }
        var stockActually = this.listaDeProdutos[indice].getQtdInventory();
        var updateStock = stockActually + qtdProduct;
        this.listaDeProdutos[indice].setQtdInventory(updateStock);
    }

    public void outputStock(int indice, int qtdProduct) throws Exception {
        if(qtdProduct == 0){
            throw new Exception("Deve-se informar um valor maior que zero para Saída");
        }
        var stockActually = this.listaDeProdutos[indice].getQtdInventory();
        var updateStock = stockActually - qtdProduct;
        this.listaDeProdutos[indice].setQtdInventory(updateStock);
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

}
