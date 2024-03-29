
package acme.features.provider.request;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestCreateService implements AbstractCreateService<Provider, Request> {

	//Internal state ------------------------------------------------------------
	@Autowired
	ProviderRequestRepository repository;


	//AbstractCreateService<Provider, Request> interface --------------

	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "text", "reward", "ticker");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accepted", false);
		} else {
			request.transfer(model, "accepted");
		}

	}

	@Override
	public Request instantiate(final acme.framework.components.Request<Request> request) {
		Request result = new Request();

		return result;
	}

	@Override
	public void validate(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isDuplicated, isAccepted;
		String ticker = entity.getTicker();

		isDuplicated = this.repository.exist(ticker) == null;
		errors.state(request, isDuplicated, "ticker", "provider.request.form.error.ticker");

		isAccepted = request.getModel().getBoolean("accepted");
		errors.state(request, isAccepted, "accepted", "provider.request.form.error.accepted");

	}

	@Override
	public void create(final acme.framework.components.Request<Request> request, final Request entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		this.repository.save(entity);
	}

}
