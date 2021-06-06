package kodlama.io.HRMS.entities.dtos;

import java.util.List;

import kodlama.io.HRMS.entities.concretes.Candidate;
import kodlama.io.HRMS.entities.concretes.CandidateEducation;
import kodlama.io.HRMS.entities.concretes.CandidateExperience;
import kodlama.io.HRMS.entities.concretes.CandidateLanguage;
import kodlama.io.HRMS.entities.concretes.CandidatePhoto;
import kodlama.io.HRMS.entities.concretes.CandidateSocialMedia;
import kodlama.io.HRMS.entities.concretes.CandidateTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDetailDto {

	private Candidate candidate;
	private List<CandidateEducation> candidateEducations;
	private List<CandidateExperience> candidateExperiences;
	private List<CandidateLanguage> candidateLanguages;
	private List<CandidateSocialMedia> candidateSocialMedias;
	private List<CandidateTechnology> candidateTechnologies;
	private List<CandidatePhoto> candidatePhotos;
}
