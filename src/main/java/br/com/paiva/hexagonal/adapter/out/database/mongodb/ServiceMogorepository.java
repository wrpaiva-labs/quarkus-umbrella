package br.com.paiva.hexagonal.adapter.out.database.mongodb;

import br.com.paiva.hexagonal.adapter.out.database.mongodb.entities.ServiceEntity;
import br.com.paiva.hexagonal.domain.model.Service;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class ServiceMogorepository implements PanacheMongoRepositoryBase<ServiceEntity, UUID> {

    public final Service findByName(String name) {
        return null;
    }

}