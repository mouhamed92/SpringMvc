package tn.isims.springmvctraining.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull
    private String designation ;
    @DecimalMin("100")
    private double prix ;
    @NotNull
    private double quntite ;

    public Produit() {
    }

    public Produit(Long id, String designation, double prix, double quntite) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.quntite = quntite;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                ", quntite=" + quntite +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getQuntite() {
        return quntite;
    }

    public void setQuntite(double quntite) {
        this.quntite = quntite;
    }
}
