package com.aor.Sh00tingGame.model.menu;

import java.util.Arrays;
import java.util.List;

public class Controls {
    private final List<String> menuEntries;
    private final List<String> gameEntries;

    private final String onlyOption;

    private int currentEntry = 0;

    public Controls(){
        this.menuEntries = Arrays.asList("Arrow Keys\t\t\tMove Up and Down","ENTER\t\t\t\t\tSelect Next Step");
        this.gameEntries = Arrays.asList("W\t\t\t\t\t\tMove Up","A\t\t\t\t\t\tMove Left","S\t\t\t\t\t\tMove Down", "D\t\t\t\t\t\tMove Right", "Arrow Keys\t\t\tShoot in the Key's Direction",
                "B\t\t\t\t\t\tGo to Weapon Store","1-4\t\t\t\t\tSelect Weapon","ESC\t\t\t\t\tGo to Menu");
        this.onlyOption = "EXIT";
        }

    public String getMenuEntry(int i) {
        return menuEntries.get(i);
    }
    public int getMenuNumberEntries() {
        return this.menuEntries.size();
    }


    public String getOnlyOption(){return onlyOption;}

    public String getGameEntry(int i) {
        return gameEntries.get(i);
    }
    public int getGameNumberEntries() {
        return this.gameEntries.size();
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }
}


