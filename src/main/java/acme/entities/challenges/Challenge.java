
package acme.entities.challenges;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "deadline")
})
public class Challenge extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//Attributes ----------------------------------------------

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date				deadline;

	@NotBlank
	private String				description;

	@NotBlank
	private String				goldGoal;

	@Valid
	@NotNull
	private Money				goldReward;

	@NotBlank
	private String				silverGoal;

	@Valid
	@NotNull
	private Money				silverReward;

	@NotBlank
	private String				bronzeGoal;

	@Valid
	@NotNull
	private Money				bronzeReward;
}
