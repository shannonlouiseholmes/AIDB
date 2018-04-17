package com.shannonholmes.guestbook.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestBookEntryRepository extends CrudRepository <GuestBookEntry, Integer>
{
    @Override
    List<GuestBookEntry> findAll();
}
