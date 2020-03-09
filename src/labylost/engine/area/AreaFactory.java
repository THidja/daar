package labylost.engine.area;

public interface AreaFactory {
    Monster createMonster(String name);
    Static createStatic(String name);
}