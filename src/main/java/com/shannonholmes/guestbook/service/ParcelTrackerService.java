package com.shannonholmes.guestbook.service;

import com.shannonholmes.guestbook.domain.ParcelEntry;
import com.shannonholmes.guestbook.domain.ParcelEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelTrackerService
{

    @Autowired
    private ParcelEntryRepository parcelEntryRepository;

    public List<ParcelEntry> findAllEntries()
    {
        return this.parcelEntryRepository.findAll ();
    }

    public ParcelEntry findGuestBookEntryById (Integer id)
    {
        return this.parcelEntryRepository.findGuestBookEntryById(id);
    }

    public List<ParcelEntry> findGuestBookEntryByUser (String user)
    {
        return this.parcelEntryRepository.findGuestBookEntryByUser (user);
    }

    public void deleteGuestBookEntryById (Integer id)
    {
        this.parcelEntryRepository.delete(id);
    }

    public void save (ParcelEntry newEntry)
    {
        this.parcelEntryRepository.save(newEntry);
    }

    public ParcelEntry findOne (Integer id)
    {
        return this.parcelEntryRepository.findOne(id);
    }
}
