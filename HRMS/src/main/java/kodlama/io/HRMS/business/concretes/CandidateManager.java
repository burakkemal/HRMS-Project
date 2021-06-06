package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.CandidateEducationService;
import kodlama.io.HRMS.business.abstracts.CandidateExperienceService;
import kodlama.io.HRMS.business.abstracts.CandidateLanguageService;
import kodlama.io.HRMS.business.abstracts.CandidatePhotoService;
import kodlama.io.HRMS.business.abstracts.CandidateService;
import kodlama.io.HRMS.business.abstracts.CandidateSocialMediaService;
import kodlama.io.HRMS.business.abstracts.CandidateTechologyService;
import kodlama.io.HRMS.core.utilities.business.BusinessRules;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.ErrorResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.core.utilities.services.abstracts.MernisCheckService;
import kodlama.io.HRMS.core.utilities.services.concretes.MernisCheckAdapter;
import kodlama.io.HRMS.dataAccess.abstracts.CandidateDao;
import kodlama.io.HRMS.entities.concretes.Candidate;
import kodlama.io.HRMS.entities.dtos.CvDetailDto;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private CandidateEducationService candidateEducationService;
	private CandidateExperienceService candidateExperienceService;
	private CandidateLanguageService  candidateLanguageService;
	private CandidateTechologyService candidateTechologyService;
	private CandidateSocialMediaService candidateSocialMediaService;
	private CandidatePhotoService candidatePhotoService;
	private MernisCheckService  mernisCheckService;
	

	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateEducationService candidateEducationService,
			CandidateExperienceService candidateExperienceService, CandidateLanguageService candidateLanguageService,
			CandidateTechologyService candidateTechologyService,
			CandidateSocialMediaService candidateSocialMediaService, CandidatePhotoService candidatePhotoService,
			MernisCheckService mernisCheckService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateEducationService = candidateEducationService;
		this.candidateExperienceService = candidateExperienceService;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateTechologyService = candidateTechologyService;
		this.candidateSocialMediaService = candidateSocialMediaService;
		this.candidatePhotoService = candidatePhotoService;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public DataResult<List<Candidate>> GetAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		Result result = BusinessRules.RunBusinessRules(mernisCheck(),checkEmailAdress(candidate.getMail()),
				checkNationalIdentity(candidate.getIdentificationNumber()), nullControl(candidate));
		if (result != null && !result.isSuccess()) {
			return result;
		}
		candidateDao.save(candidate);
		return new SuccessResult("Kayıt başarılı");
	}

	private Result checkNationalIdentity(String Tc) {

		if (this.candidateDao.findByidentificationNumberContaining(Tc).isEmpty()) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu Tc No Kullanılıyor.");
	}

	private Result checkEmailAdress(String mail) {

		if (this.candidateDao.findByMailContaining(mail).isEmpty()) {
			return new SuccessResult();
		}
		return new ErrorResult("Mail adresi kullanılıyor");
	}

	private Result nullControl(Candidate candidate) {
		if (candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty()
				|| candidate.getIdentificationNumber().isEmpty() || candidate.getBirthDate().toString().isEmpty()
				|| candidate.getMail().isEmpty() || candidate.getPassword().isEmpty()) {
			return new ErrorResult("Alanlar bos birakilamaz!!");
		}
		return new SuccessResult();
	}
	private Result mernisCheck() {
		
		mernisCheckService.checkIfRealPerson();
		return new SuccessResult();
	}

	@Override
	public DataResult<CvDetailDto> getDetailCandidateeCv(int candidateId) {
		CvDetailDto cvDetailDto = new CvDetailDto();
		cvDetailDto.setCandidate(this.candidateDao.findById(candidateId).get());
		cvDetailDto.setCandidateEducations(this.candidateEducationService.findByCandidate_Id(candidateId).getData());
		cvDetailDto.setCandidateExperiences(this.candidateExperienceService.findByCandidate_Id(candidateId).getData());
		cvDetailDto.setCandidateLanguages(this.candidateLanguageService.findByCandidate_Id(candidateId).getData());
		cvDetailDto.setCandidatePhotos(this.candidatePhotoService.findByCandidate_Id(candidateId).getData());
		cvDetailDto.setCandidateSocialMedias(this.candidateSocialMediaService.findByCandidate_Id(candidateId).getData());
		cvDetailDto.setCandidateTechnologies(this.candidateTechologyService.findByCandidate_Id(candidateId).getData());
		return new SuccessDataResult<CvDetailDto>(cvDetailDto, "Cv detayı listelendi.");
	}

	

}
