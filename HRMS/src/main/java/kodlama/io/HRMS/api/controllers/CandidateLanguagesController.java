package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.CandidateLanguageService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateLanguage;

@RestController
@RequestMapping("/api/candidatelanguages")
public class CandidateLanguagesController {
	private CandidateLanguageService candidateLanguageService;

	@Autowired
	public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
		super();
		this.candidateLanguageService = candidateLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLanguage candidateLanguage)
	{
		return this.candidateLanguageService.add(candidateLanguage);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CandidateLanguage>> getAll()
	{
		return this.candidateLanguageService.getall();
	}
}
