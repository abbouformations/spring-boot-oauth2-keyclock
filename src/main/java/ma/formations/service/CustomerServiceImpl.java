package ma.formations.service;

import lombok.AllArgsConstructor;
import ma.formations.dtos.CustomerDto;
import ma.formations.entities.Customer;
import ma.formations.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements IService{
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public void save(CustomerDto dto) {
      customerRepository.save(modelMapper.map(dto, Customer.class));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().
                stream().
                map(bo->modelMapper.map(bo, CustomerDto.class)).
                toList();
    }
}
