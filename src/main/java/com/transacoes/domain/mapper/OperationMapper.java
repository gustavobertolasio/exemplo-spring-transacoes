package com.transacoes.domain.mapper;

import com.transacoes.domain.dto.operation.response.OperationResponse;
import com.transacoes.domain.entities.Operation;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class OperationMapper {
    private final ModelMapper mapper;

    public OperationMapper(ModelMapper mapper) {
        this.mapper = mapper;

        this.mapper.addMappings(new PropertyMap<Operation, OperationResponse>() {
            @Override
            protected void configure() {
                map().setOriginAccountNumber(source.getOriginAccount().getNumber());
                map().setDestinationAccountNumber(source.getDestinationAccount().getNumber());
            }
        });
    }

    public OperationResponse toDto(Operation operation) {
        return mapper.map(operation, OperationResponse.class);
    }

    public Operation fromDto(OperationResponse operation) {
        return mapper.map(operation, Operation.class);
    }
}
