package com.shannonholmes.guestbook.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParcelEntryRepository extends CrudRepository <ParcelEntry, Integer>
{
    @Override
    List<ParcelEntry> findAll();

    ParcelEntry findGuestBookEntryById (Integer id);

    List<ParcelEntry> findGuestBookEntryByUser (String user);

}
