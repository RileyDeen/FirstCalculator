package com.example.richarddeen.firstcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private Button add, sub, mult, div, dec, equal, clear, backspace, percent;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLY = '*';
    private final char DIVISION = '/';
    private final char EQUAL = '=';
    private final char PERCENT = '%';
    private double value1 = Double.NaN; //
    private double value2;
    private char ACTION;
    private TextView info;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Links buttons
        setupUI();

        //Sets listeners for each of the button
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + "9");
            }
        });

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setText(info.getText().toString() + ".");
            }
        });

        //Computational Functions all call compute on current values then clear screen for new entrys
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = ADDITION;
                result.setText(String.valueOf(value1) + '+');
                info.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(value1) + '-');
                info.setText(null);
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = MULTIPLY;
                result.setText(String.valueOf(value1) + '*');
                info.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(value1) + '/');
                info.setText(null);
            }
        });

        //Compute and displays the result
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = EQUAL;
                result.setText( String.valueOf(value1));
                info.setText(null);
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = PERCENT;
                result.setText(String.valueOf(value1));
                info.setText(null);
            }
        });

        //Clear all info on the screen and sets both values to not a number
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value1 = Double.NaN;
                value2 = Double.NaN;
                info.setText(null);
                result.setText(null);
            }
        });

        //Removes a single character from input
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(info.getText().length() > 0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence( 0, name.length() - 1 ));
                }
                else {
                    value1 = Double.NaN;
                    value2 = Double.NaN;
                    info.setText(null);
                }
            }
        });

    }

    //Associate the button ID to a Button variable
    private void setupUI(){
        zero = (Button)findViewById(R.id.button0);
        one = (Button)findViewById(R.id.button1);
        two = (Button)findViewById(R.id.button2);
        three = (Button)findViewById(R.id.button3);
        four = (Button)findViewById(R.id.button4);
        five = (Button)findViewById(R.id.button5);
        six = (Button)findViewById(R.id.button6);
        seven = (Button)findViewById(R.id.button7);
        eight = (Button)findViewById(R.id.button8);
        nine = (Button)findViewById(R.id.button9);
        dec = (Button)findViewById(R.id.button13);
        equal = (Button)findViewById(R.id.button14);
        add = (Button)findViewById(R.id.button17);
        sub = (Button)findViewById(R.id.button16);
        mult = (Button)findViewById(R.id.button18);
        div = (Button)findViewById(R.id.button15);
        clear = (Button)findViewById(R.id.button20);
        backspace = (Button)findViewById(R.id.button19);
        percent = (Button)findViewById(R.id.button21);
        info = (TextView) findViewById(R.id.textViewInput);
        result = (TextView)findViewById(R.id.textViewOutput);
    }

    private void compute(){
        //Multiple numbers(ex '3' then  '+' then '1' then '+')
        if(!Double.isNaN(value1)){ //if value1 is a number
            //sets to double
            value2 = Double.parseDouble(info.getText().toString());
            info.setText(null);
            switch(ACTION){
                case ADDITION:
                    value1 = value1 + value2;
                    break;
                case SUBTRACTION:
                    value1 = value1 - value2;
                    break;
                case MULTIPLY:
                    value1 = value1 * value2;
                    break;
                case DIVISION:
                    value1 = value1 / value2;
                    break;
                case PERCENT:
                    value1 = value1 / 100;
                    break;
                case EQUAL:
                    break;
            }
        }
        else{//First number (ex '3' then  '+')
            try {
                value1 = Double.parseDouble(info.getText().toString());
            } catch (Exception e){}
        }
    }

}
