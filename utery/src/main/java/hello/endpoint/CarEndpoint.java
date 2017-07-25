package hello.endpoint;

import hello.repository.CarRepository;
import hello.repository.CustomerRepository;
import io.spring.guides.gs_producing_web_service.Customer;
import io.spring.guides.gs_producing_web_service.GetCustomerRequest;
import io.spring.guides.gs_producing_web_service.GetCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by skrty on 25.7.2017.
 */
@Endpoint
public class CarEndpoint {
    private static final String NAMESPACE = "http://spring.io/guides/gs-producing-web-service";

    private final CustomerRepository customerRepository;

    @Autowired
    public CarEndpoint(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse getCustomer(@RequestPayload GetCustomerRequest request) {
        GetCustomerResponse response = new GetCustomerResponse();

        hello.entity.Customer databaseCustomer = customerRepository.findOne(request.getCustomerId());
        Customer soapCustomer = new Customer();
        if (databaseCustomer != null) {
            soapCustomer.setCustomerId(databaseCustomer.getId());
            soapCustomer.setDiscount(databaseCustomer.getDiscount());
            soapCustomer.setEmail(databaseCustomer.getEmail());
            soapCustomer.setFirstname(databaseCustomer.getFirstname());
            soapCustomer.setLastname(databaseCustomer.getLastname());
            soapCustomer.setPhone(databaseCustomer.getPhone());
        }
        response.setCustomer(soapCustomer);
        return response;
    }
}
