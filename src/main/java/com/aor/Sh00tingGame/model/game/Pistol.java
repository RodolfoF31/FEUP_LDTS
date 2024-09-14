package com.aor.Sh00tingGame.model.game;

public class Pistol {
    private int range;
    private int damage;
    public Pistol() {
        this.range=5;
        this.damage=3;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }
}
