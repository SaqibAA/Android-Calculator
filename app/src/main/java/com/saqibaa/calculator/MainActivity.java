package com.saqibaa.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView Given_Value,Results;

    String Input="",Formula="",tempFormula="";

    boolean add,sub,multi,div,equal_check=false;

    Double value1,value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Given_Value = findViewById(R.id.given_value);
        Results = findViewById(R.id.result);

        Given_Value.setMovementMethod(new ScrollingMovementMethod());
    }


    public void setValue(String givenValue)
    {
        Input = Input + givenValue;
        Given_Value.setText(Input);
    }

    public void clear(View v){
        Given_Value.setText("");
        Results.setText("");
        Input="";
    }

    public void backspace(View v){
        String input = Given_Value.getText().toString();
        if (input.length() >=1 ) {
            input = input.substring(0, input.length() - 1);
            Input="";
            setValue(input);
        };
        if (input.length() <1 ) {
            setValue("0");
        }
    }

    public void equal(View v) {
     Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();

        try {
            result = (double)engine.eval(Formula);
        } catch (ScriptException e)
        {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null)
            Results.setText(String.valueOf(result.doubleValue()));
    }

    private void checkForPowerOf() {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i = 0; i < Input.length(); i++)
        {
            if (Input.charAt(i) == '^')
                indexOfPowers.add(i);
        }
        Formula = Input;
        tempFormula = Input;
        for(Integer index: indexOfPowers)
        {
            changeFormula(index);
        }
        Formula = tempFormula;
    }

    private void changeFormula(Integer index) {
        String numberLeft = "";
        String numberRight = "";

        for(int i = index + 1; i< Input.length(); i++)
        {
            if(isNumeric(Input.charAt(i)))
                numberRight = numberRight + Input.charAt(i);
            else
                break;
        }
        for(int i = index - 1; i >= 0; i--)
        {
            if(isNumeric(Input.charAt(i)))
                numberLeft = numberLeft + Input.charAt(i);
            else
                break;
        }
        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);
    }

    private boolean isNumeric(char c)
    {
        if((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    public void one(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("1");
        }else{
            setValue("1");
        }
    }

    public void two(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("2");
        }else{
            setValue("2");
        }
    }

    public void three(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("3");
        }else{
            setValue("3");
        }
    }

    public void four(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("4");
        }else{
            setValue("4");
        }
    }

    public void five(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("5");
        }else{
            setValue("5");
        }
    }

    public void six(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("6");
        }else{
            setValue("6");
        }
    }

    public void seven(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("7");
        }else{
            setValue("7");
        }
    }

    public void eight(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("8");
        }else{
            setValue("8");
        }
    }

    public void nine(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("9");
        }else{
            setValue("9");
        }    }

    public void zero(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("0");
        }else{
            setValue("0");
        }
    }

    public void two_zero(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("") || input.equals("0")) {
            Input="";
            setValue("0");
        }else{
            setValue("00");
        }
    }

    public void add(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("")){
            Input="";
            setValue("");
        }else if(input.equals("0")) {
            Input="";
            setValue("0");
        }else{
            setValue("+");
        }
    }


    public void minus(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("")){
            Input="";
            setValue("-");
        }else if(input.equals("0")) {
            Input="";
            setValue("-");
        }else{
            setValue("-");
        }
    }

    public void multiply(View v){
        String input = Given_Value.getText().toString();

        if(input.equals("")){
            Input="";
            setValue("");
        }else if(input.equals("0")) {
            Input="";
            setValue("0");
        }else{
            setValue("*");
        }
    }

    public void divide(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("")){
            Input="";
            setValue("");
        }else if(input.equals("0")) {
            Input="";
            setValue("0");
        }else{
            setValue("/");
        }
    }

    public void dot(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("")){
            Input="";
            setValue("0.");
        }else if(input.equals("0")) {
            Input="";
            setValue("0.");
        }else{
            setValue(".");
        }
    }

    public void power(View v){
        String input = Given_Value.getText().toString();
        if(input.equals("")){
            Input="";
            setValue("");
        }else if(input.equals("0")) {
            Input="";
            setValue("0");
        }else{
            setValue("^");
        }
    }

}