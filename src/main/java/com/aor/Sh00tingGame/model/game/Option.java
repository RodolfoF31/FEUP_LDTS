package com.aor.Sh00tingGame.model.game;

public class Option {
    private int option, price;
    private String name;
    private boolean again;

    public Option(int option, String name, int price, boolean again){
        this.option = option;
        this.name = name;
        this.price = price;
        this.again = again;
    }

    public void setAgain(boolean again) {
        this.again = again;
    }

    public int getOption() {
        return this.option;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public boolean getAgain(){
        return this.again;
    }
}
