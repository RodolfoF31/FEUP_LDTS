package com.aor.Sh00tingGame.model.game;

public class AK47 {
    private int range;
    private int damage;
    private boolean canUse = false;
    public AK47() {
        this.range = 5;
        this.damage = 7;
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
