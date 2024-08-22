package br.com.paiva.hexagonal.application.port.in;

import br.com.paiva.hexagonal.application.repositories.ServiceRepository;
import br.com.paiva.hexagonal.application.port.UseCase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;

@ApplicationScoped
public class GetServiceByNameUseCase
        extends UseCase<GetServiceByNameUseCase.Input, GetServiceByNameUseCase.Output> {


    private final ServiceRepository serviceRepository;

    public GetServiceByNameUseCase(final ServiceRepository serviceRepository) {
        this.serviceRepository = Objects.requireNonNull(serviceRepository);
    }

    @Override
    public Output execute(Input input) {
//        return serviceRepository.serviceOfName(input.name);
        return null;
    }

    public record Input(String name) {}

    public record Output(String id, String name, String description) {}
}
