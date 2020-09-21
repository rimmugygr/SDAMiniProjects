package my.rodo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProgramZasob extends BaseUpdateCreate{
    private String name;
    private String description;
    @OneToMany
    private List<Incydent> incydents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Incydent> getIncydents() {
        return incydents;
    }

    public void setIncydents(List<Incydent> incydents) {
        this.incydents = incydents;
    }
}
