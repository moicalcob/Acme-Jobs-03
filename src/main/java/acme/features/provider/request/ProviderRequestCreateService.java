
package acme.features.provider.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.features.authenticated.request.AuthenticatedRequestRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestCreateService implements AbstractCreateService<Authenticated, acme.entities.requests.Request> {

	//Internal state ------------------------------------------------------------

	@Autowired
	private AuthenticatedRequestRepository repository;


	//AbstractCreateService<Authenticated, Request> interface --------------

	@Override
	public boolean authorise(final Request<acme.entities.requests.Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final acme.framework.components.Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final acme.framework.components.Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "moment", "deadline", "title");
	}

	@Override
	public acme.entities.requests.Request instantiate(final acme.framework.components.Request<acme.entities.requests.Request> request) {
		acme.entities.requests.Request result;

		result = new acme.entities.requests.Request();

		return result;
	}

	@Override
	public void validate(final acme.framework.components.Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final acme.framework.components.Request<acme.entities.requests.Request> request, final acme.entities.requests.Request entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
