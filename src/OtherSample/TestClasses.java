package OtherSample;

import Engine.Game;

public class TestClasses {
    static void main() {
        Game game = new Game(500,300, "Test");
        game.setScene(new MiEscena(game));
        game.start();
    }
}
