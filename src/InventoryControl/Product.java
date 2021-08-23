package InventoryControl;

public class Product {
    private String name;
    private float priceUnit;
    private int unit;
    private int qtdInventory;

    public Product(String name, float priceUnit, int unit, int qtdInventory) throws Exception{
        setName(name);
        setPriceUnit(priceUnit);
        setUnit(unit);
        setQtdInventory(qtdInventory);
    }

    public void setName(String nome){
        this.name = nome;
    }

    public void setPriceUnit(float precoUnitario) throws Exception{
        if(precoUnitario > 0){
            this.priceUnit = precoUnitario;
        }
        else {
            throw new Exception("O Preço do produto deve ser maior que Zero");
        }
    }

    public void setUnit(int unidade) throws Exception{
        if(unidade > 0){
            this.unit = unidade;
        }
        else {
            throw new Exception("Não é possivel Criar/Editar um produto com unidade igual a Zero");
        }
    }

    public void setQtdInventory(int qtdEstoque) throws Exception {
        if(qtdEstoque > 0){
            this.qtdInventory = qtdEstoque;
        }
        else{
            throw new Exception("Não é possivel criar um produto com estoque igual a Zero");
        }
    }

    public String getName() {
        return this.name;
    }

    public float getPriceUnit() {
        return this.priceUnit;
    }

    public int getUnit() {
        return this.unit;
    }

    public int getQtdInventory() {
        return this.qtdInventory;
    }

    public void getProduct(){
        System.out.println("Nome: " + getName());
        System.out.println("Preço: " + getPriceUnit());
        System.out.println("Unidade: " + getUnit());
        System.out.println("Quantidade: " + getQtdInventory());
        System.out.println();
    }


}
