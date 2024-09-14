package com.aor.Sh00tingGame.controller.menu;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.game.arena.LoaderArenaBuilder;
import com.aor.Sh00tingGame.model.menu.Menu;
import com.aor.Sh00tingGame.states.GameState;
import com.aor.Sh00tingGame.states.MenuState;
import com.aor.Sh00tingGame.model.menu.EndMenu;

import java.io.IOException;

public class EndMenuController extends Controller<EndMenu> {

    public EndMenuController(EndMenu endMenu) {
        super(endMenu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        getModel().setDeath(game.getDeath());
        switch (action) {
            case SHOOTUP:
                getModel().previousEntry();
                break;
            case SHOOTDOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedMenu()){
                    game.setDeath(0);
                    getModel().setDeath(0);
                    game.setLevel(1);
                    game.setGameState(new GameState(new LoaderArenaBuilder(1).createArena()));;
                    game.setState(new MenuState(new Menu()));
                }
                if (getModel().isSelectedQuit()) {
                    game.setState(null);
                }
        }
    }
}
