package my.rodo.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Place extends BaseUpdateCreate {
    private String localization;
    @ElementCollection(targetClass = Zabezpieczenia.class)
    @Enumerated(EnumType.STRING)
    private Set<Zabezpieczenia> zabezpieczenia = new HashSet<>();
    private Long number;

    public void addZabezpieczenie(String zabez) {
        zabezpieczenia.add(Zabezpieczenia.valueOf(zabez));
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public Set<Zabezpieczenia> getZabezpieczenia() {
        return zabezpieczenia;
    }

    public void setZabezpieczenia(Set<Zabezpieczenia> zabezpieczenia) {
        this.zabezpieczenia = zabezpieczenia;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
