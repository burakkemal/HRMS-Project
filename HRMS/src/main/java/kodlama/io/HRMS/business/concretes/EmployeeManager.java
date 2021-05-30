package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EmployeeService;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.EmployeeDao;
import kodlama.io.HRMS.entities.concretes.Employee;

@Service
public class EmployeeManager  implements EmployeeService{

	
	private EmployeeDao systemUserDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao systemUserDao) {
		super();
		this.systemUserDao = systemUserDao;
	}

	@Override
	public List<Employee> GetAll() {
		
		return this.systemUserDao.findAll();
	}

	@Override
	public void add(Employee systemUser) {
		this.systemUserDao.save(systemUser);				
	}

	@Override
	public Result activeEmployee(int employyeId) {
		this.systemUserDao.activeEmployee(employyeId);
		return new SuccessResult();
	}
	
	

}
