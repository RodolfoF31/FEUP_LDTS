package com.aor.Sh00tingGame.viewer.game;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.game.elements.Coin;

public class CoinViewer implements ElementViewer<Coin> {
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
