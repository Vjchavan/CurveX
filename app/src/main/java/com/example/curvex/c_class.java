package com.example.curvex;

public class c_class {
    String input,country1,country2,result;

    public c_class(){

    }


    public c_class(String input, String country1, String country2, String result) {
        this.input = input;
        this.country1 = country1;
        this.country2 = country2;
        this.result = result;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getCountry1() {
        return country1;
    }

    public void setCountry1(String country1) {
        this.country1 = country1;
    }

    public String getCountry2() {
        return country2;
    }

    public void setCountry2(String country2) {
        this.country2 = country2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
