package kodlama.io.HRMS.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "candidates")
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identification_number")
	private String identificationNumber;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateEducation> candidateEducations;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateExperience> candidateExperiences;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateLanguage> candidateLanguages ;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateSocialMedia> candidateSocialMedias;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CandidateTechnology> candidateTechnologies;
	
	@JsonIgnore
	@OneToOne(mappedBy="candidate",optional=false, fetch=FetchType.LAZY)
	private CandidatePhoto candidatePhoto;
}
