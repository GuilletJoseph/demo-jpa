



package fr.diginamic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "region")



public class Region {
    
    @Id
    private int id;
    
    private int region_id;

    private String region_nom ;
    EntityManager entityManager;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "region_id")
	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	@Column(name = "region_nom")
	public String getRegionNom() {
		return region_nom;
	}

	public void setRegionNom(String region_nom) {
		this.region_nom = region_nom;
	}

	@Override
	public String toString() {
		return "Employee [id =" + id + ",  " +"code de la ville ="+ region_id+ " ,"+"nom de rgion =" + region_nom + "]";
	}
	

}
