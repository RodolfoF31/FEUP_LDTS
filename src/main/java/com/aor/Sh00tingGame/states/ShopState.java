package com.aor.Sh00tingGame.states;

import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.viewer.Viewer;
import com.aor.Sh00tingGame.controller.menu.ShopController;
import com.aor.Sh00tingGame.model.menu.Shop;
import com.aor.Sh00tingGame.viewer.game.menu.ShopViewer;


public class ShopState extends State<Shop> {

    public ShopState(Shop model) {
        super(model);
    }

    @Override
    protected Viewer<Shop> getViewer() {
        return new ShopViewer(getModel());
    }

    @Override
    protected Controller<Shop> getController() {
        return new ShopController(getModel());
    }
}
