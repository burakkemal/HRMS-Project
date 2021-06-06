package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.DepartmentService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.DepartmentDao;
import kodlama.io.HRMS.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {

	private  DepartmentDao departmentDao;
	
	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}
	
	@Override
	public Result add(Department department) {
		 this.departmentDao.save(department);
		return new SuccessResult("Bölüm eklendi.");
	}



	@Override
	public DataResult<List<Department>> getAll() {
		
		return new SuccessDataResult<List<Department>>(departmentDao.findAll(),"Bölümler listelendi.");
	}

}
