package labylost.engine.maze;

import labylost.engine.game.Game;
import labylost.engine.area.Monster;
import labylost.engine.game.ClockTickObserver;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Maze implements ClockTickObserver {

    private Game game;
    private MazeModel model;
    private Map<Monster, Point> monstersPositions;


    private Maze() {
        super();
    }

    public static Maze fromFile(String path) {
        return new Maze();
    }

    protected void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void onTick() {
        Map<Point, Point> movements = new HashMap<>();
        for(Monster monster : monstersPositions.keySet()) {
            Point actualPosition = monstersPositions.get(monster);
            Direction dir = monster.getMovingStrategy()
                                   .next(actualPosition, model);
            Point requested = computeRequestedPosition(actualPosition, dir);
            if(model.at(requested) == MazeElementType.Nothing) {
                model.moveMonster(actualPosition, requested);
                monstersPositions.put(monster, requested);
                movements.put(actualPosition, requested);
            }
        }
        game.monstersMove(movements);
    }

    private Point computeRequestedPosition(Point actualPosition, Direction dir) {
        switch(dir) {
            case Left:
                return new Point(actualPosition.x - 1, actualPosition.y);
            case Right:
                return new Point(actualPosition.x + 1, actualPosition.y);
            case Top:
                return new Point(actualPosition.x, actualPosition.y - 1);
            case Bottom:
                return new Point(actualPosition.x, actualPosition.y + 1);
            default:
                return actualPosition;
        }
    }

}