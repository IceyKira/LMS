package Model.base;

public enum EItemType {
    PERSONAL("personal", 1),
    STATUS("status", 2),
    SKILL("skill", 3);

    private final String name;
    private final int id;

    EItemType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
