package com.aor.Sh00tingGame.controller.menu;

import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.model.game.arena.LoaderArenaBuilder;
import com.aor.Sh00tingGame.states.GameState;
import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.menu.NextMenu;

import java.io.IOException;

public class NextMenuController extends Controller<NextMenu> {
    public NextMenuController(NextMenu nextMenu) {
        super(nextMenu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SHOOTUP:
                getModel().previousEntry();
                break;
            case SHOOTDOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()){
                    game.setGameState(new GameState(new LoaderArenaBuilder(1).createArena()));
                    game.setState(game.getMenuState());
                }
                if (getModel().isSelectedStart()) {
                    game.setGameState(new GameState(new LoaderArenaBuilder(game.getLevel()).createArena()));
                    game.getHero().setPosition(game.getGameState().getModel().getHero().getPosition());
                    game.getGameState().getModel().getShoot().setDamage(game.getShoot().getDamage());
                    game.getGameState().getModel().getShoot().setRange(game.getShoot().getRange());
                    game.getGameState().getModel().setHero(game.getHero());
                    game.setState(game.getGameState());
                }
        }
    }
}
