package kodlama.io.HRMS.business.abstracts;

import java.util.List;

import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.entities.concretes.Employee;

public interface EmployeeService {
	List<Employee> GetAll();
	void add(Employee systemUser);
	Result activeEmployee(int employyeId);
}
