package br.com.paiva.hexagonal.adapter;

import br.com.paiva.hexagonal.domain.model.Service;
import br.com.paiva.hexagonal.domain.model.ServiceId;

import java.util.Optional;

public interface ServiceRepository {
    Optional<Service> serviceOfId(ServiceId anId);

    Service serviceOfName(String name);

    Service create(Service service);

    Service update(Service service);

    void delete(Service service);
}
