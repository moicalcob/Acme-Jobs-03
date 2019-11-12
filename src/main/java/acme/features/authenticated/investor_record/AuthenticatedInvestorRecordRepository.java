
package acme.features.authenticated.investor_record;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investor_records.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInvestorRecordRepository extends AbstractRepository {

	@Query("select a from InvestorRecord a where a.id = ?1")
	InvestorRecord findOneById(int id);

	@Query("select a from InvestorRecord a")
	Collection<InvestorRecord> findManyAll();

}
