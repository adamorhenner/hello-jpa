package main;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class TrialSubscription extends Subscription{
    private Date endDate;

    public TrialSubscription() {
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
