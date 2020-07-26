package my.rodo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zbior extends BaseUpdateCreate{
    private String name;
    private String description;
    private boolean abi;
    private boolean giodo;
    private boolean rejstrWewnetrzny;
    @OneToMany
    private List<Incydent> incydents;

    public boolean isAbi() {
        return abi;
    }

    public void setAbi(boolean abi) {
        this.abi = abi;
    }

    public boolean isGiodo() {
        return giodo;
    }

    public void setGiodo(boolean giodo) {
        this.giodo = giodo;
    }

    public boolean isRejstrWewnetrzny() {
        return rejstrWewnetrzny;
    }

    public void setRejstrWewnetrzny(boolean rejstrWewnetrzny) {
        this.rejstrWewnetrzny = rejstrWewnetrzny;
    }

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
