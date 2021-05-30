package kodlama.io.HRMS.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.HRMS.business.abstracts.EmployeeService;
import kodlama.io.HRMS.business.abstracts.JobService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.entities.concretes.Employee;
import kodlama.io.HRMS.entities.concretes.JobTitle;

@RestController
@RequestMapping(name = "/api/employee")
public class EmployeeController {
	private EmployeeService systemUserService;
	private JobService jobService;
	
	@Autowired
	public EmployeeController(EmployeeService systemUserService,JobService jobService) {
		super();
		this.systemUserService = systemUserService;
		this.jobService=jobService;
	}

	@GetMapping("/getall")
	public List<Employee> getAll() {

		return this.systemUserService.GetAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody Employee systemUser) {
		systemUserService.add(systemUser);
		System.out.println("Eklendi");
	}
	@PostMapping("/activedEmpoleye")
	public void activeEmploye(int employeeId) {
		systemUserService.activeEmployee(employeeId);
		 System.out.println("Onaylandı");
	}
	//burayı alıcam
	@GetMapping("/getJobTitle")
	public DataResult<List<JobTitle>>  getJobTitle() {
		return this.jobService.getAll();
	}
	
}
