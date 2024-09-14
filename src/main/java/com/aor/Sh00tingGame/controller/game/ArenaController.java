package com.aor.Sh00tingGame.controller.game;

import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.menu.EndMenu;
import com.aor.Sh00tingGame.model.menu.NextMenu;
import com.aor.Sh00tingGame.states.EndMenuState;
import com.aor.Sh00tingGame.states.NextMenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;
    private final MonsterController monsterController;

    private final CoinController coinController;
    private final WeaponController weaponController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
        this.coinController = new CoinController(arena);
        this.weaponController = new WeaponController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(game.getMenuState());
        else if(getModel().getHero().getEnergy() == 0){
            game.setDeath(1);
            game.setState(new EndMenuState(new EndMenu()));
        }
        else if(getModel().getMonsters().size() == 0 && getModel().getCoin().size() == 0){
            game.setLevel(game.getLevel()+1);
            if(game.getLevel()<=3) game.setState(new NextMenuState(new NextMenu()));
            else game.setState(new EndMenuState(new EndMenu()));
        }
        else {
            heroController.step(game, action, time);
            weaponController.step(game, action, time);
            monsterController.step(game, action, time);
            coinController.step(game, action, time);
        }
    }
}