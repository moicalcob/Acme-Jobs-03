
package acme.features.administrator.dashboard;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(*) from Announcement")
	Integer findManyAllAnnouncement();

	@Query("select count(*) from CompanyRecord")
	Integer findManyAllCompanyRecord();

	@Query("select count(*) from InvestorRecord")
	Integer findManyAllInvestorRecord();

	@Query("select AVG(reward.amount) from Request")
	Double findAverageRewardsRequest();

	@Query("select MAX(reward.amount) from Request")
	Double findMaximumRewardsRequest();

	@Query("select MIN(reward.amount) from Request")
	Double findMinimumRewardsRequest();

	@Query("select STDDEV(reward.amount) from Request")
	Double findStandardDeviationRewardsRequest();

	@Query("select AVG(reward.amount) from Offer")
	Double findAverageOfRewardsOffers();

	@Query("select MAX(reward.amount) from Offer")
	Double findMaximumOfRewardsOffers();

	@Query("select MIN(reward.amount) from Offer")
	Double findMinimumOfRewardsOffers();

	@Query("select STDDEV(reward.amount) from Offer")
	Double findStandardDeviationRewardsOffers();

	@Query("select c.sector, count(c) from CompanyRecord c group by c.sector")
	List<String[]> findCompaniesPerSector();

	@Query("select c.sector, count(c) from InvestorRecord c group by c.sector")
	List<String[]> findInvestorsPerSector();

}
