package br.com.charleseduardo.apilog.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @Embedded
    private Recipient recipient;

    private BigDecimal fee;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusDelivery status;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateOrder;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateFinish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public StatusDelivery getStatus() {
        return status;
    }

    public void setStatus(StatusDelivery statusDelivery) {
        this.status = statusDelivery;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public LocalDateTime getDateFinish() {
        return dateOrder;
    }

    public void setFinishOrder(LocalDateTime finishOrderDate) {
        this.dateFinish = finishOrderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id.equals(delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
