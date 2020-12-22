package noemie.breiznoemie.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


public class VillageModel {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom")
    private String nom;

    @OneToMany(mappedBy = "evenements")
    @JsonBackReference
    private List<Village> villages;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "village_id")
    private Village village;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }


}
