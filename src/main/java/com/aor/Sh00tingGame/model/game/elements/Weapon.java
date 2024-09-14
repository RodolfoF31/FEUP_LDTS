package com.aor.Sh00tingGame.model.game.elements;

public class Weapon extends Element{
    int side=0;


    public Weapon(int x, int y) {
        super(x,y);
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}
