package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>>  GetAll();
	Result add(Employee systemUser);
	Result activeEmployee(int employyeId);
	Result updateActive(int id ,boolean active);
}
