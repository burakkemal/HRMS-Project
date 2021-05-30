package kodlama.io.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.HRMS.business.abstracts.JobAdvertisementService;
import kodlama.io.HRMS.core.utilities.results.DataResult;
import kodlama.io.HRMS.core.utilities.results.Result;
import kodlama.io.HRMS.core.utilities.results.SuccessDataResult;
import kodlama.io.HRMS.core.utilities.results.SuccessResult;
import kodlama.io.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.HRMS.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementdao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementdao) {
		super();
		this.jobAdvertisementdao = jobAdvertisementdao;
	}
	//ekleme
	@Override
	public Result add(JobAdvertisement jobadvertisement) {
		this.jobAdvertisementdao.save(jobadvertisement);
		return new SuccessResult("Eklendi");
	}

	//listeleme
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementdao.findAll());
	}

	//aktif iş ilanları
	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementdao.findByIsActiveTrue(),
				"Aktif ilanlar listelendi");
	}

	//aktif iş ilanlarının tarihe göre listelenmesi
	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreationDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(
				jobAdvertisementdao.findByIsActiveTrueOrderByCreationDateDesc());
	}

	// aktif iş verene ait iş ilanları
	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				jobAdvertisementdao.findByIsActiveTrueAndEmployerId(employerId));
	}

	//iş ilanını pasif hale getirme
	@Override
	public Result setValueOfActive(int id, boolean active) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementdao.findById(id).orElse(null);
		jobAdvertisement.setActive(active);
		this.jobAdvertisementdao.save(jobAdvertisement);
		return new SuccessResult("Güncellendi");
	}

}
