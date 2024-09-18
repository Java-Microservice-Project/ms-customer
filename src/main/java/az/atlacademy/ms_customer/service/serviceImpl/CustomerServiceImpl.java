package az.atlacademy.ms_customer.service.serviceImpl;


import az.atlacademy.ms_customer.dao.entity.CustomerEntity;
import az.atlacademy.ms_customer.dao.repository.CustomerRepository;
import az.atlacademy.ms_customer.exception.NotFoundException;
import az.atlacademy.ms_customer.model.request.SaveCustomerDto;
import az.atlacademy.ms_customer.model.response.CustomerResponseDto;
import az.atlacademy.ms_customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import static az.atlacademy.ms_customer.mapper.CustomerMapper.CUSTOMER_MAPPER;
import static az.atlacademy.ms_customer.model.enums.ErrorMessage.CUSTOMER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void saveCustomer(SaveCustomerDto dto) {
        var entity = CUSTOMER_MAPPER.buildCustomerEntity(dto);
        customerRepository.save(entity);
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        var entity = fetchCustomerIfExist(id);
        return CUSTOMER_MAPPER.buildCustomerResponse(entity);
    }

    @Override
    public void reduceBalance(Long id, BigDecimal totalAmount) {
        var entity = fetchCustomerIfExist(id);
        var updatedBalance = entity.getBalance().subtract(totalAmount);
        entity.setBalance(updatedBalance);
        customerRepository.save(entity);
    }

    private CustomerEntity fetchCustomerIfExist(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(CUSTOMER_NOT_FOUND.format(id))
        );
    }
}

