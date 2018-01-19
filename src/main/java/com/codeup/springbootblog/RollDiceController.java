package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String showPage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String play (@PathVariable Integer guess, Model viewModel) {

//        -----Generate random number (1-6)-----
        int random = (int) (Math.random() * 6 + 1);

        boolean win = (random == guess) ? true : false;

        viewModel.addAttribute("guess", guess);
        viewModel.addAttribute("random", random);
        viewModel.addAttribute("win", win);

        return "roll-dice";
    }

}
