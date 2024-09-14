package com.aor.Sh00tingGame.model.game;

public class Knife {
    private int range;
    private int damage;
    public Knife() {
        this.range=1;
        this.damage=3;
    }
    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }
}
