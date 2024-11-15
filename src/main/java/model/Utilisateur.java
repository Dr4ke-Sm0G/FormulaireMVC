package model;

import java.io.Serializable;
import java.util.List;

public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nom;
    private String prenom;
    private String sexe;
    private String codePostal;
    private List<String> transports;

    // Constructeur sans argument
    public Utilisateur() {}

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public List<String> getTransports() { return transports; }
    public void setTransports(List<String> transports) { this.transports = transports; }
}
