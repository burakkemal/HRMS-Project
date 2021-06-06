package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.HRMS.business.abstracts.CandidatePhotoService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.Candidate;
import kodlama.io.HRMS.entities.concretes.CandidatePhoto;

@RestController
@RequestMapping("/api/images")
public class CandidatePhotosController {
	private CandidatePhotoService candidatePhotoService;

	@Autowired
	public CandidatePhotosController(CandidatePhotoService candidatePhotoService) {
		super();
		this.candidatePhotoService = candidatePhotoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody MultipartFile file, @RequestParam int candidateId)
	{
		CandidatePhoto candidatePhoto =new CandidatePhoto();
		Candidate candidate =new Candidate();
		candidate.setId(candidateId);
		candidatePhoto.setCandidate(candidate);
		
		return this.candidatePhotoService.addCloudinary(candidatePhoto,file);
	}

	@GetMapping("/getall")
	public DataResult<List<CandidatePhoto>> getAll()
	{
		return this.candidatePhotoService.getAll();
	}
	
}
