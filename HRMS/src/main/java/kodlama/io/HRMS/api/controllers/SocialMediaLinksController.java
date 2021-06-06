package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.SocialMediaLinkService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.SocialMediaLink;

@RestController
@RequestMapping("/api/socialmedialinks")
public class SocialMediaLinksController {

	private SocialMediaLinkService linkService;

	@Autowired
	public SocialMediaLinksController(SocialMediaLinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialMediaLink mediaLink)
	{
		return this.linkService.add(mediaLink);
	}
	
	@GetMapping("/getall")
	public DataResult<List<SocialMediaLink>> getAll()
	{
		return this.linkService.getAll();
	}
}
