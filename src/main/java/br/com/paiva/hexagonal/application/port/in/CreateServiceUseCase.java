package br.com.paiva.hexagonal.application.port.in;

import br.com.paiva.hexagonal.application.domain.model.Service;
import br.com.paiva.hexagonal.application.port.UseCase;
import br.com.paiva.hexagonal.application.repositories.ServiceRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateServiceUseCase
        extends UseCase<CreateServiceUseCase.Input, CreateServiceUseCase.Output> {

    private final ServiceRepository serviceRepository;

    public CreateServiceUseCase(final ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Output execute(Input input) {

        var service = serviceRepository
                .create(Service.newService(input.name(), input.description()));

        return new Output(service.serviceId().value(), service.name().value(), service.description().value());
    }

    public record Input(String name, String description) {}

    public record Output(String id, String name, String description) {}
}
