package com.shannonholmes.guestbook.controller;

import com.shannonholmes.guestbook.domain.ParcelEntry;
import com.shannonholmes.guestbook.service.ParcelTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ParcelTrackerWebController
{
    private static final String TRACKER_TEMPLATE = "parcelTracker";
    private static final String ENTRIES_TEMPLATE_ID = "entries";
    private static final String HOMEPAGE_REDIRECT = "redirect:/";
    private static final String NEW_ENTRY_TEMPLATE_ID = "newEntry";
    private static final String TRACKER_FORM_HEADER_ID = "formHeader";

    @Autowired
    private ParcelTrackerService parcelTrackerService;



    @GetMapping ("/")
    public String displayGuestBook (Model model)
    {
        model.addAttribute(TRACKER_FORM_HEADER_ID, "Add a New Package: ");
        model.addAttribute (ENTRIES_TEMPLATE_ID, this.parcelTrackerService.findAllEntries());
        model.addAttribute(NEW_ENTRY_TEMPLATE_ID, new ParcelEntry());

        return TRACKER_TEMPLATE;
    }

    @GetMapping ("/delete/{id}")
    public String deleteComment (@PathVariable Integer id)
    {
        this.parcelTrackerService.deleteGuestBookEntryById(id);

        return HOMEPAGE_REDIRECT;
    }

    @PostMapping ("/")
    public String addComment (Model model, @Valid @ModelAttribute (NEW_ENTRY_TEMPLATE_ID) ParcelEntry newEntry, BindingResult bindingResult)
    {
        if(!bindingResult.hasErrors())
        {
            this.parcelTrackerService.save(newEntry);

            return HOMEPAGE_REDIRECT;
        }
        else
        {
            model.addAttribute(TRACKER_FORM_HEADER_ID, "Please Correct the Status");
            model.addAttribute(ENTRIES_TEMPLATE_ID, this.parcelTrackerService.findAllEntries());
            return TRACKER_TEMPLATE;
        }
    }

    @GetMapping ("update/{id}")
    public String editComment (Model model, @PathVariable Integer id)
    {
        model.addAttribute (ENTRIES_TEMPLATE_ID, this.parcelTrackerService.findAllEntries ());
        model.addAttribute (TRACKER_FORM_HEADER_ID, "Please Change the Status");
        model.addAttribute (NEW_ENTRY_TEMPLATE_ID, this.parcelTrackerService.findOne (id));

        return TRACKER_TEMPLATE;
    }

    @PostMapping ("update/{id}")
    public String saveComment (Model model, @PathVariable Integer id, @ModelAttribute (NEW_ENTRY_TEMPLATE_ID) ParcelEntry newEntry, BindingResult bindingResult)
    {
        if(!bindingResult.hasErrors ())
        {
            ParcelEntry current = this.parcelTrackerService.findOne (id);

            current.setUser (newEntry.getUser ());
            current.setComment (newEntry.getComment ());

            this.parcelTrackerService.save (current);

            return HOMEPAGE_REDIRECT;
        }
        else
        {
            model.addAttribute(TRACKER_FORM_HEADER_ID, "Please update the status");
            model.addAttribute(ENTRIES_TEMPLATE_ID, this.parcelTrackerService.findAllEntries());

            return TRACKER_TEMPLATE;
        }

    }
}
