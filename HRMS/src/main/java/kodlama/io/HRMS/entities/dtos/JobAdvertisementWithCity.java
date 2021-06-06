package kodlama.io.HRMS.entities.dtos;


import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithCity {
	private int id;
	private String description;
	private double minSalary;
	private double maxSalary;
	private Date creationDate;
	private LocalDate deadLineDate;
	private int openPositonNumber;
}
