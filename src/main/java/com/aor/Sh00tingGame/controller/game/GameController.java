package com.aor.Sh00tingGame.controller.game;

import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.controller.Controller;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
