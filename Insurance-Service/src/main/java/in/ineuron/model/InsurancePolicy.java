package in.ineuron.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="INSURANCE_POLICY")
public class InsurancePolicy {
	@Id
	@Column(name="POLICY_ID")
	private Integer policyId;
	@Column(name="POLICY_NAME")
	private String policyName;
	@Column(name="POLICY_TENURE")
	private Integer tenure;
}
