package com.aor.Sh00tingGame.model.menu;

import com.aor.Sh00tingGame.model.game.AK47;
import com.aor.Sh00tingGame.model.game.Option;
import com.aor.Sh00tingGame.model.game.Sniper;
import com.aor.Sh00tingGame.model.game.elements.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Shop {

    private Hero hero;
    private final List<String> entries;

    private boolean cantBuy = false;
    private com.aor.Sh00tingGame.model.game.Option option1 = new com.aor.Sh00tingGame.model.game.Option(1,"Buy Rifle", 10, true);
    private com.aor.Sh00tingGame.model.game.Option option2 = new com.aor.Sh00tingGame.model.game.Option(2,"Buy Sniper", 15, true);
    private com.aor.Sh00tingGame.model.game.Option option3 = new com.aor.Sh00tingGame.model.game.Option(3,"Buy Health", 10, true);
    private ArrayList<com.aor.Sh00tingGame.model.game.Option> options = new ArrayList<com.aor.Sh00tingGame.model.game.Option>();

    public Shop(Hero hero){
        this.hero = hero;
        defineOptions();
        this.entries = Arrays.asList(option1.getName()+": "+option1.getPrice()+"$",option2.getName()+": "+option2.getPrice()+"$", option3.getName()+": "+option3.getPrice()+"$", "Back to Game");
    }

    private void defineOptions(){
        this.options.add(option1);
        this.options.add(option2);
        this.options.add(option3);
    }

    public ArrayList<Option> getOptions() {
        return this.options;
    }

    public void buyItem(int money, int option, Hero hero, AK47 ak47, Sniper sniper){
        switch (option){
            case 0:
                if(getOptions().get(option).getPrice() <= money && getOptions().get(option).getAgain()){
                    ak47.setCanUse(true);
                    options.get(option).setAgain(false);
                    hero.setMoney(money - getOptions().get(option).getPrice());
                }
                else{
                    this.cantBuy=true;
                }
                break;
            case 1:
                if(getOptions().get(option).getPrice() <= money && getOptions().get(option).getAgain()){
                    sniper.setCanUse(true);
                    options.get(option).setAgain(false);
                    hero.setMoney(money - getOptions().get(option).getPrice());                }
                else{
                    this.cantBuy=true;
                }
                break;
            case 2:
                if(getOptions().get(option).getPrice() <= money){
                    hero.increaseEnergy();
                    hero.setMoney(money - getOptions().get(option).getPrice());                }
                else{
                    this.cantBuy=true;
                }
                break;
        }
    }
    private int currentEntry = 0;

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }

    public boolean isSelectedBuyAK() {
        return isSelected(0);
    }
    public boolean isSelectedBuySniper() {
        return isSelected(1);
    }
    public boolean isSelectedBuyHealth() {
        return isSelected(2);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public boolean getCantBuy() {
        return cantBuy;
    }

    public void setCantBuy(boolean cantBuy) {
        this.cantBuy = cantBuy;
    }
}

