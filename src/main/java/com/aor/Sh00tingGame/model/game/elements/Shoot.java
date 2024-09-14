package com.aor.Sh00tingGame.model.game.elements;

import com.aor.Sh00tingGame.model.Position;


public class Shoot extends Element {
    private Position position;
    private int range = 0;
    private int damage = 0;
    public Shoot(int x, int y) {
        super(x,y);
        position = new Position(x,y);
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

}
