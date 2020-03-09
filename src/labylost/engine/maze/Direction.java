package labylost.engine.maze;

public enum Direction {
    Left("Left"), Right("Right"), Top("Top"), Bottom("Bottom");

    String value;

    private Direction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "value='" + value + '\'' +
                '}';
    }
}