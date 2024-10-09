package br.com.paiva.hexagonal.port.in;

import br.com.paiva.hexagonal.adapter.ServiceRepository;
import br.com.paiva.hexagonal.domain.model.ServiceId;
import br.com.paiva.hexagonal.exceptions.ValidationException;
import br.com.paiva.hexagonal.port.UseCase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;

@ApplicationScoped
public class GetServiceByIdUseCase
        extends UseCase<GetServiceByIdUseCase.Input, GetServiceByIdUseCase.Output> {

    private final ServiceRepository serviceRepository;

    public GetServiceByIdUseCase(final ServiceRepository serviceRepository) {
        this.serviceRepository = Objects.requireNonNull(serviceRepository);
    }

    @Override
    public Output execute(Input input) {
        return serviceRepository.serviceOfId(ServiceId.with(input.id()))
                .map(service -> new Output(service.serviceId().value(), service.name().value(), service.description().value()))
                .orElseThrow(() -> new ValidationException("Service not found"));
    }

    public record Input(String id) {}

    public record Output(String id, String name, String description) {}
}
