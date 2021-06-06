package kodlama.io.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.HRMS.entities.concretes.SocialMediaLink;

public interface SocialMediaLinkDao extends JpaRepository<SocialMediaLink, Integer>{

}
