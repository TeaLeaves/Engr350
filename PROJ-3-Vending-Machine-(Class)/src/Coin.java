/**
 *  CECS 277 Project 3
 *  @authors: Matthew Chen, Ryan Ignasiak, Tina Vu
 *  Due Date: 10/07/20
 *  Professor Mimi Opkins
 *  Summary: A coin with a monetary value.
 */
public class Coin {
    //private data members
    private double amount;
    private String type;

    /**
     * default constructor
     */
    public Coin(){
        amount = 0;
        type = "";
    }

    /**
     * Constructs a coin.
     * @param aValue the monetary value of the coin
     * @param aName the name of the coin
     */
    public Coin(double aValue, String aName){
        amount = aValue;
        type = aName;
    }

    /**
     * Gets the coin value.
     * @return the value
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the coin name.
     * @return the name
     */
    public String getType() {
        return type;
    }
}
