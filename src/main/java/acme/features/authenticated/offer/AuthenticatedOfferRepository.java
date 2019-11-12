
package acme.features.authenticated.offer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.offers.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedOfferRepository extends AbstractRepository {

	@Query("Select o from Offer o where o.id = ?1")
	Offer findOneById(int id);

	@Query("Select o from Offer o")
	Collection<Offer> findManyAll();

}
