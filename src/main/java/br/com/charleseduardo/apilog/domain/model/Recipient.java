package br.com.charleseduardo.apilog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Recipient {

    @Column(name = "recipient_name")
    private String name;
    @Column(name = "recipient_street")
    private String streetAddress;
    @Column(name = "recipient_number")
    private String numberAddress;
    @Column(name = "recipient_complement")
    private String complement;
    @Column(name = "recipient_district")
    private String district;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getNumberAddress() {
        return numberAddress;
    }

    public void setNumberAddress(String numberAddress) {
        this.numberAddress = numberAddress;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
