package com.shannonholmes.guestbook.controller;

import com.shannonholmes.guestbook.domain.GuestBookEntry;
import com.shannonholmes.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestBookController
{
    @Autowired
    private GuestBookService guestBookService;

    @GetMapping ("/comments")
    public List<GuestBookEntry> getAllComments ()
    {
        return guestBookService.findAllEntries();
    }

}
