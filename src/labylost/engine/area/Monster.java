package labylost.engine.area;

import labylost.engine.maze.MovingStrategy;
import java.util.Objects;

public abstract class Monster {

    public final static int MIN_SPEED = 1;
    public final static int MAX_SPEED = 3;
    // defined how the monster moves through the maze
    private MovingStrategy movingStrategy;
    // used to compute resources path
    private String livingArea;
    private String name;
    // speed belongs [1, 3]
    private int speed;

    protected Monster(String name, String livingArea, MovingStrategy movingStrategy, int speed) {
        this.movingStrategy = movingStrategy;
        this.livingArea = livingArea;
        this.name = name;
        this.speed = speed;
    }

    protected Monster(String name, String livingArea, MovingStrategy movingStrategy) {
        this(name, livingArea, movingStrategy, MIN_SPEED);
    }

    public final void setSpeed(int speed) {
        if(speed >= MIN_SPEED && speed <= MAX_SPEED) {
            this.speed = speed;
        }
    }

    public final int getSpeed() {
        return speed;
    }

    public final String getName() {
        return this.name;
    }

    public final MovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    public final String getResourcesPath() {
        return String.format("resources/%s/monsters/%s/", livingArea, name);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return livingArea.equals(monster.livingArea) &&
                name.equals(monster.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(livingArea, name);
    }
}