package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.CandidateSocialMediaService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.CandidateSocialMedia;

@RestController
@RequestMapping("/api/candidatesocialmedias")
public class CandidateSocialMedias {
	private CandidateSocialMediaService candidateSocialMediaService;

	@Autowired
	public CandidateSocialMedias(CandidateSocialMediaService candidateSocialMediaService) {
		super();
		this.candidateSocialMediaService = candidateSocialMediaService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSocialMedia candidateSocialMedia) {
		return candidateSocialMediaService.add(candidateSocialMedia);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateSocialMedia>> getAll(){
		return candidateSocialMediaService.getAll();
	}
}
