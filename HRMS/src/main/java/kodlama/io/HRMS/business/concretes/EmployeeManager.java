package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EmployeeService;
import kodlama.io.HRMS.business.abstracts.EmployerService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.EmployeeDao;
import kodlama.io.HRMS.entities.concretes.Employee;

@Service
public class EmployeeManager  implements EmployeeService{

	
	private EmployeeDao systemUserDao;
	private EmployerService employerService;
	
	
	@Autowired
	public EmployeeManager(EmployeeDao systemUserDao,EmployerService employerService) {
		super();
		this.systemUserDao = systemUserDao;
		this.employerService=employerService;
	}

	@Override
	public DataResult<List<Employee>> GetAll() {
		
		return new SuccessDataResult<List<Employee>>(this.systemUserDao.findAll()); 
	}

	@Override
	public Result add(Employee systemUser) {
		this.systemUserDao.save(systemUser);
		return new SuccessResult("Eklendi");				
	}

	//aktif durumu değiştirme
	@Override
	public Result activeEmployee(int employyeId) {
		this.systemUserDao.activeEmployee(employyeId);
		return new SuccessResult();
	}
	
	public Result updateActive(int id ,boolean active) {
		employerService.employeeConfirm(id,active);
		return new SuccessResult("Güncellendi");
	}
	
	
	
	

}
