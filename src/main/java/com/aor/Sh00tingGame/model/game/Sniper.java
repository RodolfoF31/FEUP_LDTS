package com.aor.Sh00tingGame.model.game;

public class Sniper {
    private int range;
    private int damage;
    private boolean canUse = false;
    public Sniper() {
        this.range=10;
        this.damage=10;
    }
    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public void setCanUse(boolean value){
        this.canUse=value;
    }

    public boolean getCanUse(){
        return this.canUse;
    }
}
