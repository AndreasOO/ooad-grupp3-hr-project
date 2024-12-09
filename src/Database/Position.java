package Database;

import javax.swing.*;

public enum Position {
    VD ("VD"),
    CHEF ("Chef"),
    MANAGER ("Manager"),
    SUBORDINATE ("Subordinate"),
    DEVELOPER ("Developer"),
    PRODUCT_OWNER ("Product Owner"),
    SCRUM_MASTER ("Scrum Master");
    
    public final String title;

    Position(String title) {
        this.title = title;
    }

    public String getPosition() {
        return title;
    }
}
