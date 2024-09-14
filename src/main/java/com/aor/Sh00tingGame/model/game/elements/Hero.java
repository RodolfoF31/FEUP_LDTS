package com.aor.Sh00tingGame.model.game.elements;

import com.aor.Sh00tingGame.model.game.AK47;
import com.aor.Sh00tingGame.model.game.Knife;
import com.aor.Sh00tingGame.model.game.Pistol;
import com.aor.Sh00tingGame.model.game.Sniper;

public class Hero extends Element {
    private int energy;

    private int money;

    private Knife knife = new Knife();
    private Pistol pistol = new Pistol();
    private AK47 ak47 = new AK47();
    private Sniper sniper = new Sniper();

    private String weaponUsed = "Pistol";

    public Knife getKnife() {
        return knife;
    }

    public Pistol getPistol() {
        return pistol;
    }

    public AK47 getAk47() {
        return ak47;
    }

    public Sniper getSniper() {
        return sniper;
    }

    public Hero(int x, int y) {
        super(x, y);
        this.energy = 5;
        this.money = 0;
    }

    public void increaseEnergy() {
        this.energy++;
    }
    public void decreaseEnergy() {
        this.energy--;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMoney(){ return money;}

    public void setMoney(int money){
        this.money = money;
    }

    public void increaseMoney(){ this.money++; }

    public void addMoney(){
        this.money++;
    }

    public String getWeaponUsed() {
        return weaponUsed;
    }

    public void setWeaponUsed(String weaponUsed) {
        this.weaponUsed = weaponUsed;
    }
}
