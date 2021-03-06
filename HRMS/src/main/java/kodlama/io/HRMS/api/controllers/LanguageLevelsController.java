package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.LanguageLevelService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.LanguageLevel;

@RestController
@RequestMapping("/api/languagelevels")
public class LanguageLevelsController {

	private LanguageLevelService languageLevelService;

	@Autowired
	public LanguageLevelsController(LanguageLevelService languageLevelService) {
		super();
		this.languageLevelService = languageLevelService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LanguageLevel languageLevel)
	{
		return this.languageLevelService.add(languageLevel);
	}
	
	@GetMapping("/getall")
	public DataResult<List<LanguageLevel>> getAll()
	{
		return this.languageLevelService.getAll();
	}
}
