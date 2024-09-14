package com.aor.Sh00tingGame.gui;

import com.aor.Sh00tingGame.model.Position;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }
    @Test
    void refresh() throws IOException {
        gui.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void close() throws IOException {
        gui.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }
    @Test
    void clear(){
        gui.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }


    @Test
    void drawHero() {
        gui.drawHero(new Position(1, 1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0, 255, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "*");
    }

    @Test
    void drawWeapon(){
        gui.drawWeapon(new Position(1,1), 0);
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, ";");


        gui.drawWeapon(new Position(1,1), 1);
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "/");


        Mockito.verify(tg, Mockito.times(2)).setForegroundColor(new TextColor.RGB(255, 192, 203));
    }

    @Test
    void drawShoot(){
        gui.drawShoot(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "O");
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 51, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, String.valueOf(Symbols.BLOCK_SOLID));
    }

    @Test
    void drawMonster(){

        gui.drawMonster(new Position(1,1), 30);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(185, 28, 2));

        gui.drawMonster(new Position(1,1), 20);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(235, 156, 13));

        gui.drawMonster(new Position(1,1), 10);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 213, 0));


        Mockito.verify(tg, Mockito.times(3)).putString(1, 2, "%");
    }

    @Test
    void drawCoin(){
        gui.drawCoin(new Position(1,1));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "$");
    }



    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }
}