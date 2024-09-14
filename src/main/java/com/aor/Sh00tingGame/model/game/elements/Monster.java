package com.aor.Sh00tingGame.model.game.elements;

public class Monster extends Element {
    private int min = 1;
    private int max = 3;
    private int type;

    private int health;
    public Monster(int x, int y) {
        super(x, y);
        type = (int)(Math.random()*(max-min+1)+min);
        health = type * 10;
    }

    public void decreaseHealth(int damage) {
        this.health = this.health - damage;
    }

    public boolean verifyDeath(){
        if(this.health <= 0){
            return true;
        }
        return false;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
