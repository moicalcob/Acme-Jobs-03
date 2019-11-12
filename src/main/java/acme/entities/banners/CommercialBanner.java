
package acme.entities.banners;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommercialBanner extends DomainEntity {

	//Serialisation identifier
	private static final long	serialVersionUID	= 1L;

	//Attributes
	@NotBlank
	@URL
	private String				picture;

	@NotBlank
	private String				slogan;

	@NotBlank
	@URL
	private String				target;

	@NotBlank
	private String				creditCard;
}
