package fr.eni.pizzas.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Pizza {
	@Id
	@GeneratedValue
	private long id;
	private String nom;
	private String description;
	private String image;
	private double prix;
	
	
	public Pizza() {
		super();
	}

	public Pizza(String nom, String description, String image, double prix) {
		this.nom = nom;
		this.description = description;
		this.image = image;
		this.prix = prix;
	}

	public Pizza(int id, String nom, String description, String image, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.image = image;
		this.prix = prix;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	

}
