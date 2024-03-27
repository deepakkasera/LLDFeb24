package org.example.designpatterns.factory;

import org.example.designpatterns.factory.buttons.Button;
import org.example.designpatterns.factory.buttons.IOSButton;
import org.example.designpatterns.factory.menu.IOSMenu;
import org.example.designpatterns.factory.menu.Menu;

public class IOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
