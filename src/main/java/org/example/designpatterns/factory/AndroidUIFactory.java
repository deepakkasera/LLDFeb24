package org.example.designpatterns.factory;

import org.example.designpatterns.factory.buttons.AndroidButton;
import org.example.designpatterns.factory.buttons.Button;
import org.example.designpatterns.factory.menu.AndroidMenu;
import org.example.designpatterns.factory.menu.Menu;

public class AndroidUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
