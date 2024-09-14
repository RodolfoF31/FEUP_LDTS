package com.aor.Sh00tingGame.gui;

import com.aor.Sh00tingGame.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawHero(Position position);

    void drawWeapon(Position position, int side);

    void drawShoot(Position position);

    void drawWall(Position position);

    void drawMonster(Position position, int health);

    void drawCoin(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, SHOOTUP, SHOOTRIGHT, SHOOTDOWN, SHOOTLEFT, AK47, KNIFE, PISTOL, SNIPER, NONE, QUIT, SELECT, BMENU}
}
