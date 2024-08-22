package br.com.paiva.hexagonal.application.domain.model;

import br.com.paiva.hexagonal.application.domain.Description;
import br.com.paiva.hexagonal.application.domain.Name;
import br.com.paiva.hexagonal.application.exceptions.ValidationException;

public class Service {

    private final ServiceId serviceId;
    private Name name;
    private Description description;

    public Service(final ServiceId serviceId, final String name, final String description) {

        if(serviceId == null) {
            throw new ValidationException("Invalid serviceId for Service");
        }

        this.serviceId = serviceId;
        this.setName(name);
        this.setDescription(description);
    }

    public static Service newService(final String name, final String description) {
        return new Service(ServiceId.unique(), name, description);
    }

    public ServiceId serviceId() {
        return serviceId;
    }

    public Name name() {
        return name;
    }

    public Description description() {
        return description;
    }

    public void setName(final String name) {
        this.name = new Name(name);
    }

    public void setDescription(final String description) {
        this.description = new Description(description);
    }
}

