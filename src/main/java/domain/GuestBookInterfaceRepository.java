package domain;

import org.springframework.data.repository.CrudRepository;

public interface GuestBookInterfaceRepository extends CrudRepository <GuestBookEntry, Integer>
{
    @Override
    List <GuestBookEntry> findAll();
}
