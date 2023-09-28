package main;

import jakarta.persistence.Entity;

@Entity
public class LifeTimeSubscription extends Subscription{
    private Boolean eliteClub;

    public Boolean getEliteClub() {
        return eliteClub;
    }

    public void setEliteClub(Boolean eliteClub) {
        this.eliteClub = eliteClub;
    }
}
