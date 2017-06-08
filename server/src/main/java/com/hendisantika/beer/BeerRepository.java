package com.hendisantika.beer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Created by hendisantika on 6/6/17.
 */
@RepositoryRestResource
@CrossOrigin(origins = {"http://localhost:8100","file://"})
interface BeerRepository extends JpaRepository<Beer, Long> {}
