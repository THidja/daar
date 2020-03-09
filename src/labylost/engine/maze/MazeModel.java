package labylost.engine.maze;

import java.awt.Point;

final class MazeModel {

    private int width;
    private int height;
    private int[][] model;

    protected MazeModel(int width, int height) {
        this.width = width;
        this.height = height;
        model = new int[width][height];
    }

    protected void setAt(Point p, MazeElementType e) {
        model[p.x][p.y] = valueOf(e);
    }

    protected void moveMonster(Point p, Point q) {
        model[p.x][p.y] = valueOf(MazeElementType.Nothing);
        model[q.x][q.y] = valueOf(MazeElementType.Monster);
    }

    protected void movePlayer(Point p, Point q) {
        model[p.x][p.y] = valueOf(MazeElementType.Nothing);
        model[q.x][q.y] = valueOf(MazeElementType.Player);
    }

    protected void destroyStatic(Point p) {
        model[p.x][p.y] = valueOf(MazeElementType.Nothing);
    }

    protected MazeElementType at(Point p) {
        return elementOf(model[p.x][p.y]);
    }

    public MazeElementType atLeft(Point p) {
        if(p.x  > 0) {
            return elementOf(model[p.x][p.y]);
        }
        return  MazeElementType.MazeBorder;
    }

    public MazeElementType atRight(Point p) {
        if(p.x < width - 1) {
            return elementOf(model[p.x][p.y]);
        }
        return  MazeElementType.MazeBorder;
    }

    public MazeElementType atTop(Point p) {
        if(p.y > 0) {
            return elementOf(model[p.x][p.y]);
        }
        return MazeElementType.MazeBorder;
    }

    public MazeElementType atBottom(Point p) {
        if(p.y < height - 1) {
            return elementOf(model[p.x][p.y]);
        }
        return MazeElementType.MazeBorder;
    }

    private MazeElementType elementOf(int e) {
        switch(e) {
            case 0:  return MazeElementType.Nothing;
            case 1:  return MazeElementType.Static;
            case 2:  return MazeElementType.Monster;
            case 3:  return MazeElementType.Player;
            case 4:  return MazeElementType.Exit;
            default: return MazeElementType.MazeBorder;
        }
    }

    private int valueOf(MazeElementType t) {
        switch(t) {
            case MazeBorder: return 5;
            case Static:     return 1;
            case Monster:    return 2;
            case Player:     return 3;
            case Exit:       return 4;
            default:         return 0;
        }
    }
}