package calculator.codekon.de.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {


    private EditText mShowNumber;
    private int mTemp;
    private String mNumber;

    private boolean mLastSub;
    private boolean mLastAdd;
    private boolean mLastMul;
    private boolean mLastDiv;
    private boolean mLastResult;

    private final String ZERO="0";
    private final String ONE="1";
    private final String TWO="2";
    private final String TREE="3";
    private final String FOUR="4";
    private final String FIVE="5";
    private final String SIX="6";
    private final String SEVEN="7";
    private final String EIGHT="8";
    private final String NINE="9";

    private final String ADD="+";
    private final String SUB="-";
    private final String MUL="*";
    private final String DIV="/";
    private final String RESULT="=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button add = (Button)findViewById(R.id.add);
        final Button sub = (Button)findViewById(R.id.subtraction);
        final Button mul = (Button)findViewById(R.id.multiplication);
        final Button div = (Button)findViewById(R.id.division);


        //TODO floating point numbers must be adapted
        //final Button comma = (Button)findViewById(R.id.comma);

        final Button clear = (Button) findViewById(R.id.clear);
        final Button result= (Button) findViewById(R.id.result);

        mShowNumber = (EditText)findViewById(R.id.show_number);

        mTemp = 0;
        mNumber = "";

        mLastSub = false;
        mLastAdd = false;
        mLastMul = false;
        mLastDiv = false;
        mLastResult = false;


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateAdd();

                mShowNumber.append(ADD);
                mLastAdd = true;
                mNumber = "";

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateSub();

                mShowNumber.append(SUB);
                mLastSub = true;
                mNumber = "";
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateMul();

                mShowNumber.append(MUL);
                mLastMul = true;
                mNumber = "";
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateDiv();

                mShowNumber.append(DIV);
                mLastDiv = true;
                mNumber = "";
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mLastAdd){

                    mTemp = mTemp + Integer.parseInt(mNumber);
                    mLastAdd = false;

                    mShowNumber.append(" " + RESULT + " " + mTemp);
                }
                if(mLastSub){

                    mTemp = mTemp - Integer.parseInt(mNumber);
                    mLastSub = false;

                    mShowNumber.append(" " + RESULT + " " + mTemp);
                }
                if(mLastMul){

                    mTemp = mTemp * Integer.parseInt(mNumber);
                    mLastMul = false;

                    mShowNumber.append(" " + RESULT + " " + mTemp);

                }
                if(mLastDiv){


                    if(Integer.parseInt(mNumber)>0)  {

                        mTemp = mTemp / Integer.parseInt(mNumber);
                        mLastDiv = false;

                        mShowNumber.append(" " + RESULT + " " + mTemp);
                    }
                    else{
                        mTemp = 0;
                        mLastDiv = false;

                        mShowNumber.append(" " + RESULT + " " + mTemp);
                    }
                }

                mNumber = "";
                mTemp = 0;
                mLastResult = true;
            }

        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mShowNumber.setText("");
            }
        });

    }


    public void calculateAdd() {

        if (!mNumber.equals("")) {

            if (mTemp == 0) {
                mTemp = Integer.parseInt(mNumber);

            } else if (mLastSub) {
                mTemp = mTemp - Integer.parseInt(mNumber);
                mLastSub = false;

            } else if (mLastMul) {
                mTemp = mTemp * Integer.parseInt(mNumber);
                mLastMul = false;

            } else if (mLastDiv) {
                mTemp = mTemp / Integer.parseInt(mNumber);
                mLastDiv = false;

            } else {
                mTemp = mTemp + Integer.parseInt(mNumber);
            }


        }

    }

    public void calculateSub() {

        if (!mNumber.equals("")) {

            if (mTemp == 0) {
                mTemp = Integer.parseInt(mNumber);

            } else if (mLastAdd) {
                mTemp = mTemp + Integer.parseInt(mNumber);
                mLastAdd = false;

            } else if (mLastMul) {
                mTemp = mTemp * Integer.parseInt(mNumber);
                mLastMul = false;

            } else if (mLastDiv) {
                mTemp = mTemp / Integer.parseInt(mNumber);
                mLastDiv = false;

            } else {
                mTemp = mTemp - Integer.parseInt(mNumber);
            }


        }

    }


    public void calculateMul() {

        if (!mNumber.equals("")) {

            if (mTemp == 0) {
                mTemp = Integer.parseInt(mNumber);

            } else if (mLastAdd) {
                mTemp = mTemp + Integer.parseInt(mNumber);
                mLastAdd = false;

            } else if (mLastSub) {
                mTemp = mTemp - Integer.parseInt(mNumber);
                mLastSub = false;

            } else if (mLastDiv) {
                mTemp = mTemp / Integer.parseInt(mNumber);
                mLastDiv = false;

            } else {
                mTemp = mTemp * Integer.parseInt(mNumber);
            }


        }

    }


    public void calculateDiv() {

        if (!mNumber.equals("")) {

            if (mTemp == 0) {
                mTemp = Integer.parseInt(mNumber);

            } else if (mLastAdd) {
                mTemp = mTemp + Integer.parseInt(mNumber);
                mLastAdd = false;

            } else if (mLastMul) {
                mTemp = mTemp * Integer.parseInt(mNumber);
                mLastMul = false;

            } else if (mLastSub) {
                mTemp = mTemp - Integer.parseInt(mNumber);
                mLastSub = false;

            } else {
                mTemp = mTemp / Integer.parseInt(mNumber);
            }


        }

    }





    public void onClickButton9(View view){
       onClickButtons(this.NINE);
    }

    public void onClickButton8(View view){
        onClickButtons(this.EIGHT);
    }

    public void onClickButton7(View view){
        onClickButtons(this.SEVEN);
    }

    public void onClickButton6(View view){
        onClickButtons(this.SIX);
    }

    public void onClickButton5(View view){
        onClickButtons(this.FIVE);
    }

    public void onClickButton4(View view){
        onClickButtons(this.FOUR);
    }

    public void onClickButton3(View view){
        onClickButtons(this.TREE);
    }

    public void onClickButton2(View view){
        onClickButtons(this.TWO);
    }

    public void onClickButton1(View view){
        onClickButtons(this.ONE);
    }

    public void onClickButton0(View view){
        onClickButtons(this.ZERO);
    }


    private void onClickButtons(String number){

        if(mShowNumber.getText().toString().equals(ZERO) || mLastResult){
            mLastResult = false;
            mShowNumber.setText(number);
            mNumber = number;
        }
        else{
            mShowNumber.append(number);
            mNumber = mNumber + number;
        }
    }


}
