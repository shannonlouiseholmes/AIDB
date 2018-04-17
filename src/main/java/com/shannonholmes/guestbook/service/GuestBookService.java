package com.shannonholmes.guestbook.service;

import com.shannonholmes.guestbook.domain.GuestBookEntry;
import com.shannonholmes.guestbook.domain.GuestBookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookService
{

    @Autowired
    private GuestBookEntryRepository guestBookEntryRepository;

    public List<GuestBookEntry> findAllEntries()
    {
        return this.guestBookEntryRepository.findAll ();
    }

    public GuestBookEntry findGuestBookEntryById (Integer id)
    {
        return this.guestBookEntryRepository.findGuestBookEntryById(id);
    }

    public List<GuestBookEntry> findGuestBookEntryByUser (String user)
    {
        return this.guestBookEntryRepository.findGuestBookEntryByUser (user);
    }

    public void deleteGuestBookEntryById (Integer id)
    {
        this.guestBookEntryRepository.delete(id);
    }

    public void save (GuestBookEntry newEntry)
    {
        this.guestBookEntryRepository.save(newEntry);
    }
}
