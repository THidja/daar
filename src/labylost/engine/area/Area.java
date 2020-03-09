package labylost.engine.area;

import java.util.Objects;

public abstract class Area {

    private String name;
    private AreaFactory factory;

    protected Area(String name, AreaFactory factory) {
        this.name = name;
        this.factory = factory;
    }

    public final AreaFactory getFactory() {
        return factory;
    }

    public final String getName() {
        return name;
    }

    public final String getResourcesPath() {
        return String.format("resources/%s/", name);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(name, area.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public final String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                '}';
    }
}