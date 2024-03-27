package org.example.designpatterns.factory;

import org.example.designpatterns.factory.buttons.Button;
import org.example.designpatterns.factory.menu.Menu;

//In this Factory Interface we are only going to have factory methods.
public interface UIFactory {
    Button createButton();

    Menu createMenu();
}
