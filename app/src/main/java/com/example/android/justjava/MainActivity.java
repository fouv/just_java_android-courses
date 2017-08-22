package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

     /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        int pricePerCup = 5;
        int price = quantity * pricePerCup;
        displayPrice(price);
        return price;
    }

    /**
     * create a summary of the order.
     *
     * @return total price
     */
    private String createOrderSummary(int price) {
        String priceMessage = "Name: Isa Sanchez" ;
        priceMessage = priceMessage + "\nQuantity : "+quantity ;
        priceMessage = priceMessage + "\nTotal : €" + price;
        priceMessage = priceMessage + "\nThank you !";
        return priceMessage;
    }


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the less button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
