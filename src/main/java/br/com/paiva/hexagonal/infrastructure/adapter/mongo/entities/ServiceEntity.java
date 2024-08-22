package br.com.paiva.hexagonal.infrastructure.adapter.mongo.entities;

import br.com.paiva.hexagonal.application.domain.model.Service;
import br.com.paiva.hexagonal.application.domain.model.ServiceId;
import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.Objects;
import java.util.UUID;

@MongoEntity(collection = "services")
public class ServiceEntity extends PanacheMongoEntityBase {

    public UUID id;
    public String name;
    public String description;

    public ServiceEntity() {
    }

    public ServiceEntity(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static ServiceEntity of(final Service service) {
        return new ServiceEntity(
                UUID.fromString(service.serviceId().value()),
                service.name().value(),
                service.description().value());
    }

    public Service toService() {
        return new Service(ServiceId.with(this.id.toString()), this.name, this.description);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceEntity service = (ServiceEntity) o;
        return Objects.equals(id, service.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
