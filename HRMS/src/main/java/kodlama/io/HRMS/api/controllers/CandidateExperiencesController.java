package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.CandidateExperienceService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateExperience;

@RestController
@RequestMapping("/api/candidateexperiences")
public class CandidateExperiencesController {
	
	private CandidateExperienceService candidateExperienceService;

	@Autowired
	public CandidateExperiencesController(CandidateExperienceService candidateExperienceService) {
		super();
		this.candidateExperienceService = candidateExperienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateExperience candidateExperience) {
		
		return this.candidateExperienceService.add(candidateExperience);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateExperience>> getAll(){
		return this.candidateExperienceService.getAll();
	}
	@GetMapping("/findByCandidateIdOrderByEndDateDesc")
	public DataResult<List<CandidateExperience>> findByEmployeeIdOrderByEndDateDesc(int candidateId)
	{
		return this.candidateExperienceService.findByCandidateIdOrderByEndDateDesc(candidateId);
	}
}
