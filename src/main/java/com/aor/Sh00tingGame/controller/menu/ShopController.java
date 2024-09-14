package com.aor.Sh00tingGame.controller.menu;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.menu.Shop;

import java.io.IOException;

public class ShopController extends Controller<Shop> {
    public ShopController(Shop model) {
        super(model);
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
                if (getModel().isSelectedExit()) {
                    game.setState(game.getGameState());
                }
                if (getModel().isSelectedBuyAK()) {
                    getModel().buyItem(getModel().getHero().getMoney(),0, getModel().getHero(), getModel().getHero().getAk47(), getModel().getHero().getSniper());
                }
                if (getModel().isSelectedBuySniper()) {
                    getModel().buyItem(getModel().getHero().getMoney(),1, getModel().getHero(), getModel().getHero().getAk47(), getModel().getHero().getSniper());

                }
                if (getModel().isSelectedBuyHealth()) {
                    getModel().buyItem(getModel().getHero().getMoney(),2, getModel().getHero(), getModel().getHero().getAk47(), getModel().getHero().getSniper());

                }
        }
    }
}
