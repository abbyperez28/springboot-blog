package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Ad;
import com.codeup.springbootblog.services.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {
    private AdService service;

    public AdController(AdService service){
        this.service = service;
    }

    @GetMapping("/ads")
    public String showAllAds(Model viewAndModel){
        List<Ad> ads = service.findAll();

        viewAndModel.addAttribute("ads", ads);
        return "/ads/index";
    }

    @GetMapping("/ads/{id}")
    public String showIndividualAds(@PathVariable long id, Model viewAndModel){
        Ad ads = service.findOne(id);

        viewAndModel.addAttribute("ads", ads);
        return "/ads/index";
    }

    @GetMapping("ads/new")
    public String showCreateAdForm(){
        return "ads/new";
    }

    @PostMapping("ads/create")
    @ResponseBody
    public String saveAd( @RequestParam("title") String title, @RequestParam("description") String description) {
        Ad ad = new Ad(title, description);
        return ad.getTitle() + " " + ad. getDescription();
    }
}
