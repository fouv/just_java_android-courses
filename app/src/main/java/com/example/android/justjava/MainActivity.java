package com.example.android.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText edit =  (EditText) findViewById(R.id.name_view);
        String nameString = edit.getText().toString();
//        Log.d("name",nameString);

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_checkbox);
        Boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        Boolean hasChocolate = chocolateCheckbox.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage = createOrderSummary(nameString,price,hasWhippedCream,hasChocolate);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     * @param addChocolate to add chocolate
     *@param addCream to add cream
     * @return price
     */

    private int calculatePrice(boolean addCream,boolean addChocolate) {

        int pricePerCup = 5;
        if (addChocolate) {
            pricePerCup = pricePerCup + 2;
        }
        if (addCream) {
            pricePerCup = pricePerCup + 1;
        }
        return quantity * pricePerCup;
    }


    /**
     * create a summary of the order.
     * @param nameString
     * @param hasWhippedCream
     * @param hasChocolate
     * @param price
     * @return total price
     *
     */
    private String createOrderSummary (String nameString, int price, boolean hasWhippedCream, boolean hasChocolate) {
        String priceMessage = "Name: " + nameString ;
        priceMessage += "\nAdd whipped cream ? "+ hasWhippedCream ;
        priceMessage += "\nAdd chocolate ? " + hasChocolate;
        priceMessage += "\nQuantity : " + quantity;
        priceMessage += "\nTotal : €" + price;
        priceMessage += "\nThank you !";
        return priceMessage;
    }


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        Context context = getApplicationContext();
        if(quantity==98) {
            Toast.makeText(context, "you can't order over than 100 coffees !", Toast.LENGTH_SHORT).show();
        }
        if(quantity>99)    {
            quantity = 99;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the less button is clicked.
     */
    public void decrement(View view) {
        Context context = getApplicationContext();
        if(quantity < 2){
            Toast.makeText(context,"you can't order less than 1 coffee !", Toast.LENGTH_SHORT).show();
        }
        if(quantity<=1){
            quantity = 1;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


}
