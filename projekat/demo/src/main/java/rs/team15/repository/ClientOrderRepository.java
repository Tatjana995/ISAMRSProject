package rs.team15.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.team15.model.ClientOrder;


public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {

    ClientOrder findByReservation_RsidAndClientId(Long reservationId, Long userId);

    Collection<ClientOrder> findByReservation_Rsid(Long reservationId);
}