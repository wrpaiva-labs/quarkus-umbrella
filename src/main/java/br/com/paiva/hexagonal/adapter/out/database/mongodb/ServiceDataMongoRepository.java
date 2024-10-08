package br.com.paiva.hexagonal.adapter.out.database.mongodb;

import br.com.paiva.hexagonal.adapter.ServiceRepository;
import br.com.paiva.hexagonal.adapter.out.database.mongodb.entities.ServiceEntity;
import br.com.paiva.hexagonal.domain.model.Service;
import br.com.paiva.hexagonal.domain.model.ServiceId;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class ServiceDataMongoRepository implements ServiceRepository {

    private ServiceMogorepository repository;

    public ServiceDataMongoRepository(ServiceMogorepository repository) {
        this.repository = repository;
    }

    public Optional<Service> serviceOfId(ServiceId anId) {
        Objects.requireNonNull(anId, "ServiceId is required");
        return this.repository.findByIdOptional(UUID.fromString(anId.value()))
                .map(ServiceEntity::toService);
    }

    public Service serviceOfName(String name) {
        return repository.findByName(name);
    }

    @Transactional
    public Service create(Service service) {
        repository.persist(ServiceEntity.of(service));
        return service;
    }

    @Transactional
    public Service update(Service service) {
        this.repository.update(ServiceEntity.of(service));

        return service;
    }

    public void delete(Service service) {
        repository.delete(ServiceEntity.of(service));
    }
}