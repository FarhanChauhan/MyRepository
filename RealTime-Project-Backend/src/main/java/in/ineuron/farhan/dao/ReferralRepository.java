package in.ineuron.farhan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.farhan.model.Referral;

@Repository
public interface ReferralRepository extends JpaRepository<Referral, Long> {
    // Add custom query methods if needed
}


