package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.CandidateTechologyService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateTechnology;

@RestController
@RequestMapping("/api/candidatetechnologies")
public class CandidateTechnologiesController {

	private CandidateTechologyService candidateTechologyService;

	@Autowired
	public CandidateTechnologiesController(CandidateTechologyService candidateTechologyService) {
		super();
		this.candidateTechologyService = candidateTechologyService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CandidateTechnology candidateTechnology) {
		return this.candidateTechologyService.add(candidateTechnology);

	}

	@GetMapping("/getall")
	public DataResult<List<CandidateTechnology>> getAll() {
		return this.candidateTechologyService.getAll();
	}
}
