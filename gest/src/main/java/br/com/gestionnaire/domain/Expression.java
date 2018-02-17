package br.com.gestionnaire.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Expression implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String description;

	@Column(name="synonyms_from", nullable = false, length = 100)
	private String synonymsFrom;
	
	@Column(name="synonyms_translated", nullable = false, length = 100)
	private String synonymsTranslated;
	
	@Column(nullable = true, length = 500)
	private Boolean favorite;
	
	@Column(nullable = false, length = 100)
	private String nation;
	
	@Column(nullable = true, length = 500)
	private Boolean inactive;
	
	@Column(name="display_date", nullable = true, length = 500)
	private Boolean displayDate;
	
	//Getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSynonymsFrom() {
		return synonymsFrom;
	}

	public void setSynonymsFrom(String synonymsFrom) {
		this.synonymsFrom = synonymsFrom;
	}

	public String getSynonymsTranslated() {
		return synonymsTranslated;
	}

	public void setSynonymsTranslated(String synonymsTranslated) {
		this.synonymsTranslated = synonymsTranslated;
	}

	public Boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public Boolean getInactive() {
		return inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	public Boolean getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(Boolean displayDate) {
		this.displayDate = displayDate;
	}

	@Override
	public String toString() {
		return "Expression [id=" + id + ", description=" + description + ", synonymsFrom=" + synonymsFrom
				+ ", synonymsTranslated=" + synonymsTranslated + ", favorite=" + favorite + ", nation=" + nation
				+ ", inactive=" + inactive + ", displayDate=" + displayDate + "]";
	}
	

}