package com.aor.Sh00tingGame.controller.game;

import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;

import java.io.IOException;

public class WeaponController extends GameController {
    public WeaponController(Arena arena) {super(arena);}

    public void revWeaponRight(){
        if(getModel().isEmpty(getModel().getHero().getPosition().getRight())){
            moveWeapon(getModel().getHero().getPosition().getRight());
            getModel().getWeapon().setSide(0);
        }
    }

    public void revWeaponLeft() {
        if(getModel().isEmpty(getModel().getHero().getPosition().getLeft())) {
            moveWeapon(getModel().getHero().getPosition().getLeft());
            getModel().getWeapon().setSide(1);
        }
    }

    private void moveWeapon(Position position) {
            if(getModel().isEmpty(position) && !(getModel().getHero().getPosition().equals(position)))
                getModel().getWeapon().setPosition(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.RIGHT || action == GUI.ACTION.LEFT || action == GUI.ACTION.UP || action == GUI.ACTION.DOWN) {
            if(getModel().getWeapon().getSide() == 0)
                revWeaponRight();
            if(getModel().getWeapon().getSide() == 1)
                revWeaponLeft();
        }
        if(action == GUI.ACTION.SHOOTRIGHT)
            revWeaponRight();

        if (action == GUI.ACTION.SHOOTLEFT) {
                revWeaponLeft();
        }
    }
}
