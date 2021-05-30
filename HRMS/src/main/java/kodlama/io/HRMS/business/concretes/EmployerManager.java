package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.EmployerService;
import kodlama.io.HRMS.core.utilities.business.BusinessRules;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.ErrorResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.EmployerDao;

import kodlama.io.HRMS.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
		
		private EmployerDao employerDao;

		@Autowired
		public EmployerManager(EmployerDao employerDao) {
			super();
			this.employerDao = employerDao;
		}

		@Override
		public DataResult<List<Employer>> getAll() {
			return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Data Listelendi");
		}

		@Override
		public Result add(Employer employer) {
			Result result=BusinessRules.RunBusinessRules(nullCheck(employer),checkEmail(employer.getMail()),equalsPassword(employer));
			if (result!=null&& !result.isSuccess()) {
				return result; 
			}
			employerDao.save(employer);
			return new SuccessResult("Kayıt Başarılı");
		}
		//boş geçilen alanların kontrolü
		private Result nullCheck(Employer employer) {
			if (employer.getCompanyName().isEmpty()||employer.getMail().isEmpty()||employer.getWebAdress().isEmpty()) {
				return new ErrorResult("Bu alanlar boş geçilemez");
			}
			return new SuccessResult();
		}
		//email kontrol
		private Result checkEmail(String mail) {
			if (this.employerDao.findByMailContaining(mail).isEmpty()) {
				return new SuccessResult();
			}
			return new ErrorResult("Bu E-posta kullanılıyor");
		}

		//iş veren onayı
		@Override
		public Result activeEmployee(int employyerId) {
			this.employerDao.activeEmployer(employyerId);
			return new SuccessResult();
		}
		
		public Result equalsPassword(Employer employer) {
			if (employer.getPassword().equals(employer.getRepeatedPassword())) {
				return new SuccessResult();
			}
			return new ErrorResult("Şifreler uyuşmuyor");
		}

		
		//iş veren onayı için 
		@Override
		public Result employeeConfirm(int employeeId, boolean active) {
			
			Employer employer=this.employerDao.findById(employeeId).orElse(null);
			employer.setVerify(active);
			this.employerDao.save(employer);
			return new SuccessResult("Güncellendi");
			
		}
		

		
}
