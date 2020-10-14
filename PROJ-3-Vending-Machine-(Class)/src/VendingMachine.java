/**
 * CECS 277 Project 3
 * @authors: Matthew Chen, Ryan Ignasiak, Tina Vu
 * Due Date: 10/07/20
 * Professor Mimi Opkins
 *
 * Summary: create a vending machine that contains an array list of product
 * users can add products and its prices into the vending machine
 * user can add money into the vending machine
 * user can buy products from the vending machine
 * user can receive change from the vending machine or cancel order
 */
import java.util.ArrayList;
public class VendingMachine {
    //private data members
    private double purchase;
    private double payment;
    private double salary;
    private ArrayList<Product> items = new ArrayList<>();

    /**
     * Constructs a cash register with no money in it.
     */
    public VendingMachine() {
        purchase = 0;
        payment = 0;
        salary = 0;
    }

    /**
     * Records the purchase price of an item.
     * @param itemNum product that is being purchased
     * @return a receipt like message of your purchase
     */
    public String recordPurchase(int itemNum) {
        //get the product item
        Product item = items.get(itemNum);
        //if you don't have enough money to buy it
        if(item.getPrice() > payment){
            return "Insufficient Money\n" +
            "Received Change: $" + giveChange() + "\n";
        //if the product ran out
        } else if(item.getAmount() == 0){
            return "SOLD OUT\n" +
            "Received Change: $" + giveChange() + "\n";
        }
        //else buy it
        else {
            purchase = purchase + item.getPrice();
            item.getProduct();
            salary = salary + item.getPrice();
            return "YOU GOT " + item.getItemName() + "\n" +
            "Received Change: $" + giveChange() + "\n";
        }
    }

    /**
     * Processes the payment received from the customer.
     * @param coinCount amount of $$$
     * @param coinType type of money used EX: quarter, dollar, dimes, etc.
     */
    public void receivePayment(double coinCount, Coin coinType){
        payment = payment + (coinCount*coinType.getAmount());
    }

    /**
     * let the user see how much money they have entered into the vending machine
     * @return payment as a string, which is the money they entered into the machine
     */
    public String getCurrentAmount(){
        return String.format("%.2f", payment);
    }

    /**
     * Computes the change due and resets the machine for the next customer.
     * @return the change due to the customer
     */
    public String giveChange(){
        //calculate the change
        double change = payment - purchase;

        //refresh purchase and payment
        purchase = 0;
        payment = 0;

        //return the change
        return String.format("%.2f",Math.round(change*100.00)/100.00);
    }

    public double getSalary(){
        return salary;
    }

    /**
     * add a product into the vending machine
     * @param cost: the cost of the product item
     * @param name: the name of the product item
     * return 0 to exit method
     */
    public int addProduct(double cost, String name, int amount){
        //if vending machine is empty, just add in the product
        if(items.size() == 0){
            items.add(new Product(cost, name, amount));
        }
        //if it is not empty
        else {
            //loop through the products in the vending machine
            for (int i = 0; i < items.size(); i++) {
                //if product is already in the vending machine, increase the amount
                if (items.get(i).getItemName().toLowerCase().equals(name.toLowerCase()) && items.get(i).getPrice() == cost) {
                    items.get(i).addProduct(amount);
                    return 0;
                }
            }
            //if this product is not yet in the Vending Machine,add it in
            items.add(new Product(cost, name, amount));
            return 0;
        }
        return 0;
    }

    /**
     * how many products are in the vending machine
     * @return number of products as an integer
     */
    public int amountOFProducts(){
        return items.size();
    }

    /**
     * return a string of all of the products
     * @return the products as a string
     */
    public String toString(){
        String lineOfProducts = "";
        for(int i = 0; i < items.size(); i++){
            lineOfProducts = lineOfProducts + i + ") " + items.get(i).toString() + "\n";
        }
        return lineOfProducts;
    }
}
