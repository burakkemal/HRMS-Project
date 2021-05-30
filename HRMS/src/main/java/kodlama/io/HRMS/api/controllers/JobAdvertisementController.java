package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.JobAdvertisementService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	@GetMapping(name = "/getall")
	public DataResult<List<JobAdvertisement>> getAll()
	{
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getActiveAdvertisement")
	public DataResult<List<JobAdvertisement>> getActiveAdvertisement()
	{
		return this.jobAdvertisementService.findByIsActiveTrue();
	}
	@GetMapping("/findByIsActiveTrueOrderByCreationDate")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreationDate()
	{
		return this.jobAdvertisementService.findByIsActiveTrueOrderByCreationDate();
	}
	@GetMapping("/findByIsActiveTrueAndEmployer")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer(int employerId)
	{
		return this.jobAdvertisementService.findByIsActiveTrueAndEmployerId(employerId);
	}
	@GetMapping("/setValueActive")
	public Result setValueActive(int id,boolean active)
	{
		return this.jobAdvertisementService.setValueOfActive(id,active);
	}
	
}
