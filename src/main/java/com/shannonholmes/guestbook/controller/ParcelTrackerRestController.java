package com.shannonholmes.guestbook.controller;

import com.shannonholmes.guestbook.domain.ParcelEntry;
import com.shannonholmes.guestbook.service.ParcelTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping ("/api")
@RestController
public class ParcelTrackerRestController
{
    @Autowired
    private ParcelTrackerService parcelTrackerService;

    @GetMapping ("/comments")
    public List<ParcelEntry> getAllComments ()
    {
        return parcelTrackerService.findAllEntries();
    }

    @GetMapping ("/comment/{id}")
    public ParcelEntry findGuestBookEntryByID (@PathVariable ("id") Integer id)
    {
        return this.parcelTrackerService.findGuestBookEntryById(id);
    }

    @GetMapping ("/user/{user}")
    public List <ParcelEntry> findGuestBookEntryByUser (@PathVariable ("user") String user)
    {
        return this.parcelTrackerService.findGuestBookEntryByUser (user);
    }

    @DeleteMapping ("/comment/{id}")
    public void deleteGuestBookEntryById (@PathVariable ("id") Integer id)
    {
        this.parcelTrackerService.deleteGuestBookEntryById(id);
    }

    @PostMapping ("/add")
    public void addComment (@RequestBody ParcelEntry parcelEntry)
    {
        this.parcelTrackerService.save (parcelEntry);
    }

    @PostMapping ("/update")
    public void updateComment (@RequestBody ParcelEntry parcelEntry)
    {
        this.parcelTrackerService.save(parcelEntry);
    }
}
