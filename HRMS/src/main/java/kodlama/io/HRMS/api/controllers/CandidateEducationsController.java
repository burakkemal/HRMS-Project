package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.CandidateEducationService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateEducation;

@RestController
@RequestMapping("/api/candidateeducations")
public class CandidateEducationsController {
	
	private CandidateEducationService candidateEducationService;

	@Autowired
	public CandidateEducationsController(CandidateEducationService candidateEducationService) {
		super();
		this.candidateEducationService = candidateEducationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateEducation candidateEducation)
	{
		return candidateEducationService.add(candidateEducation);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateEducation>> getAll()
	{
		return candidateEducationService.getAll();
	}
	
	@GetMapping("/findByCandidateIdOrderByEndDate")
	public DataResult<List<CandidateEducation>> findByEmployeeIdOrderByEndDate(int candidateId)
	{
		return candidateEducationService.findByCandidateIdOrderByEndDate(candidateId); 
	}
}
