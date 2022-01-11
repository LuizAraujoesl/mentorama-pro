package repository;

import com.travelworks.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
@Async("customThread")
public interface TravelRespository extends JpaRepository<Persona, Long> {

    CompletableFuture<Optional<Persona>> findOneById(final Long id);

    CompletableFuture<List<Persona>> findAllBy();
}
