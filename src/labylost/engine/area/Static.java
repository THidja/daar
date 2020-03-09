package labylost.engine.area;

import java.util.Objects;

public abstract class Static {

    private String name;
    private String area;

    protected Static(String name, String area) {
        this.name = name;
        this.area = area;
    }

    public final String getName() {
        return name;
    }

    public final String getResourcesPath() {
        return String.format("resources/%s/statics/%s", area, name);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Static aStatic = (Static) o;
        return name.equals(aStatic.name) &&
                area.equals(aStatic.area);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name, area);
    }
}