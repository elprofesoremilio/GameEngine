import Engine.Game;
import SimpleSample.MenuScene;

void main(String[] args) {
    Game game = new Game(800, 600, "Motor 2D - POO");
    game.setScene(new MenuScene(game));
    game.start();
}
