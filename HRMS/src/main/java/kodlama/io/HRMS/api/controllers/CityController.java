package kodlama.io.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.CityService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {
	
	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<City>> getAll()
	{
		return cityService.getAll();
	}
}
