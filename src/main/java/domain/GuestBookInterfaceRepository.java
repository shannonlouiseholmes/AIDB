package domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestBookInterfaceRepository extends CrudRepository <GuestBookEntry, Integer>
{
    @Override
    List<GuestBookEntry> findAll();
}
