package main;

import jakarta.persistence.Entity;

@Entity
public class Contract extends Document{
    private String terms;

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }
}
