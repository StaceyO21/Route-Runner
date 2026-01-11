package org.launchcode.route_runner.data;

import org.launchcode.route_runner.models.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {
}
