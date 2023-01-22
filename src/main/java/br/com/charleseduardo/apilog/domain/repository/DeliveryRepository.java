package br.com.charleseduardo.apilog.domain.repository;

import br.com.charleseduardo.apilog.domain.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
