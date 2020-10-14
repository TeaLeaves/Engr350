/**
 *  CECS 277 Project 3
 *  @authors: Matthew Chen, Ryan Ignasiak, Tina Vu
 *  Due Date: 10/07/20
 *  Professor Mimi Opkins
 *  Summary: creates the products that can be placed into the vending machine
 */
public class Product {
    //data members
    double price;
    String itemName;
    int amount;

    //default constructor with no param
    public Product(){
        price = 0;
        itemName = "";
        amount = 0;
    }

    /**argument constructor with param
     * @param cost: the cost of the product
     * @param name: the name of the product
     * @param amount: amount of that product to be put in the vending machine
     */
    public Product(double cost, String name, int amount){
        price = cost;
        itemName = name;
        this.amount = amount;
    }

    /**getter for price
     * @return the price of the product
     */
    public double getPrice(){
        return price;
    }

    /**getter for itemName
     * @return the name of the product
     */
    public String getItemName(){
        return itemName;
    }

    /**getter for amount
     * @return the amount of that product
     */
    public int getAmount(){
        return amount;
    }

    /** create a string with the product name, cost, and amount
     * @return "Name: $Cost AMOUNT: ##"
     */
    public String toString(){
        return itemName + ": \t$" + String.format("%.2f",price) + "\t AMOUNT: " + amount;
    }

    /**product was purchased so subtract amount
     */
    public void getProduct(){
        amount = amount - 1;
    }

    /**increase inventory of a product
     * @param amountNum: number to add into amount for product
     */
    public void addProduct(int amountNum){
        amount = amount + amountNum;
    }
}
