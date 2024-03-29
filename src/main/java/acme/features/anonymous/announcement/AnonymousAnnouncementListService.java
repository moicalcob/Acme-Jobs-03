
package acme.features.anonymous.announcement;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcements.Announcement;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousAnnouncementListService implements AbstractListService<Anonymous, Announcement> {

	//Internal state
	@Autowired
	AnonymousAnnouncementRepository repository;


	//AbstractListService<Administrator, Announcement> interface
	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "moment", "title");
	}

	@Override
	public Collection<Announcement> findMany(final Request<Announcement> request) {
		assert request != null;
		Collection<Announcement> result;
		result = this.repository.findManyAll();
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, -1);
		Date date = c.getTime();
		return result.stream().filter(x -> new Date(x.getMoment().getTime()).after(date)).collect(Collectors.toSet());
	}

}
