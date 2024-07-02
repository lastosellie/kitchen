package kiosk.domain;

import kiosk.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "kitchens", path = "kitchens")
public interface KitchenRepository
    extends PagingAndSortingRepository<Kitchen, Long> {}
