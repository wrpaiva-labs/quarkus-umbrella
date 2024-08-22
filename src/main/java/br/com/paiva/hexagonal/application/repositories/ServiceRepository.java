package br.com.paiva.hexagonal.application.repositories;

import br.com.paiva.hexagonal.application.domain.model.Service;
import br.com.paiva.hexagonal.application.domain.model.ServiceId;

import java.util.Optional;

// interface adapter
public interface ServiceRepository {

    Optional<Service> serviceOfId(ServiceId anId);

    Service serviceOfName(String name);

    Service create(Service service);

    Service update(Service service);

    void delete(Service service);
}