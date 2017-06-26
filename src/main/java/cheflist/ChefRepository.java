package cheflist;

import org.springframework.data.repository.CrudRepository;

import cheflist.Chef;

public interface ChefRepository extends CrudRepository<Chef, Long> {

}
