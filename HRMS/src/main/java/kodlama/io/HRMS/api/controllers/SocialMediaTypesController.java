package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.SocialMediaTypeService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.SocialMediaType;

@RestController
@RequestMapping("/api/socialmediatypes")
public class SocialMediaTypesController {

	private SocialMediaTypeService mediaTypeService;

	@Autowired
	public SocialMediaTypesController(SocialMediaTypeService mediaTypeService) {
		super();
		this.mediaTypeService = mediaTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialMediaType mediaType)
	{
		return this.mediaTypeService.add(mediaType);
	}
	
	@GetMapping("/getall")
	public DataResult<List<SocialMediaType>> getAll()
	{
		return this.mediaTypeService.getAll();
	}
}
