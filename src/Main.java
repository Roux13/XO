import model.Field;
import model.Point;
import model.Player;
import model.Game;
import model.Figure;
import model.exceptions.*;
import view.*;
import controllers.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import java.util.Arrays;


public class Main {

    public static void main(String... args) {
        final Field field = new Field();
        final Player p = new Player("Slava", Figure.X);
        final Player p2 = new Player("Gleb", Figure.O);
        final Game g = new Game.Builder().player1(p).player2(p2).field(field).name("XO").build();
        if (!g.getPlayer1().equals(p)) throw new RuntimeException(String.format("Game.getPlayer1 returns %s instead of %s", g.getPlayer1(), p));
        if (!g.getPlayer2().equals(p2)) throw new RuntimeException(String.format("Game.getPlayer2 returns %s instead of %s", g.getPlayer2(), p2));
    }
}
