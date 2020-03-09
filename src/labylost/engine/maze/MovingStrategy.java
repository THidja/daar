package labylost.engine.maze;

import java.awt.Point;

public interface MovingStrategy  {
    public Direction next(Point actualPosition, MazeModel model);
}