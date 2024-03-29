
package acme.features.authenticated.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request;
import acme.framework.components.Model;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedRequestShowService implements AbstractShowService<Authenticated, Request> {

	//Internal state
	@Autowired
	private AuthenticatedRequestRepository repository;


	//AbstractShowService<Authenticated, Request> interface
	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		request.unbind(entity, model, "title", "moment", "deadline", "text", "reward", "ticker");
	}

	@Override
	public Request findOne(final acme.framework.components.Request<Request> request) {
		assert request != null;
		Request result = null;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}
}
