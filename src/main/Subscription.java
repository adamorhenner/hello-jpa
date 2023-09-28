package main;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Ou outra estratégia de geração de chave primária
    private Long id;
    private Date startDate;
    private Double payment;
    private Long version;

    @OneToMany
    List<LineItem> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public Subscription() {
    }

    public Subscription(Long id, Date startDate, Double payment) {
        this.id = id;
        this.startDate = startDate;
        this.payment = payment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
