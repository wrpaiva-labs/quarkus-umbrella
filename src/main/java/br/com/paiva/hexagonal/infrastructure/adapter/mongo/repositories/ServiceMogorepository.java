package br.com.paiva.hexagonal.infrastructure.adapter.mongo.repositories;

import br.com.paiva.hexagonal.application.domain.model.Service;
import br.com.paiva.hexagonal.infrastructure.adapter.mongo.entities.ServiceEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ServiceMogorepository implements PanacheMongoRepositoryBase<ServiceEntity, UUID> {

    public final Service findByName(String name) {
        return null;
    }

}
