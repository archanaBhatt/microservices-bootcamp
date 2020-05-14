package Resourceserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo1 extends JpaRepository <Order1, String> {

}
