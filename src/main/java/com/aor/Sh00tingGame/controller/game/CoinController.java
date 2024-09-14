package com.aor.Sh00tingGame.controller.game;

import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.elements.Coin;
import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;

import java.io.IOException;

public class CoinController extends GameController{
    public CoinController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }

    private void getMoney(Coin coin, Position position){
        if (getModel().getHero().getPosition().equals(position)){
            getModel().getHero().increaseMoney();
        }
    }
}
