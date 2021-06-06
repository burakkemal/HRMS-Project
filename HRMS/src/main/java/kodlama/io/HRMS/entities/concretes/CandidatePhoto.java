package kodlama.io.HRMS.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_photos")
@NoArgsConstructor
@AllArgsConstructor
public class CandidatePhoto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "photo_link")
	private String photoLink;

	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@Column(name = "uploaded_date")
	private LocalDate uploadedDate = LocalDate.now();
}
