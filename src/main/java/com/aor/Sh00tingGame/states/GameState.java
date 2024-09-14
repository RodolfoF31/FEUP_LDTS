package com.aor.Sh00tingGame.states;

import com.aor.Sh00tingGame.controller.Controller;
import com.aor.Sh00tingGame.controller.game.ArenaController;
import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.elements.Hero;
import com.aor.Sh00tingGame.viewer.Viewer;
import com.aor.Sh00tingGame.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }

    public void setHero(Hero hero){

    }
}
