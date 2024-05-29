package fr.efrei.billeterie.repository;

import fr.efrei.billeterie.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

    List<Cart> findAll();

    Optional<Cart> findOneByUuid(String uuid);

    Cart save(Cart cart);

    void deleteByUuid(String uuid);
}
