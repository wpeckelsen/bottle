package com.example.bottle.C.repository;
import com.example.bottle.B.BusinessLogic.Models.Bottle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BottleRepo extends JpaRepository<Bottle, Long> {


//    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);

    List<Bottle> findBottlesByName(String name);

}
