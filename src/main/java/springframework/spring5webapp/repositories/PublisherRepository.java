package springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import springframework.spring5webapp.domain.Publisher;

@Component
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
