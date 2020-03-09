package labylost.engine.game;

import labylost.engine.maze.Maze;

import java.awt.*;
import java.util.Map;

public abstract class Game {

    private int gameSpeed;

    public Game(String mazePath, int gameSpeed) {
        Maze maze = Maze.fromFile(mazePath);
        Clock c = new Clock(gameSpeedToTickDuration(gameSpeed));
        c.addObserver(maze);
        this.gameSpeed = gameSpeed;
    }

    private int gameSpeedToTickDuration(int gameSpeed) {
        return gameSpeed * 1500;
    }

    // player win
    public abstract void playerWin();

    // player die
    public abstract void playerDie();

    //
    public abstract void monstersMove(Map<Point, Point> movements);

    public void updateGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }
}