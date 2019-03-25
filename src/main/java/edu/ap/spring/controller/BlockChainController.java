package edu.ap.spring.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Scope("session")
public class BlockChainController{

    @GetMapping(value="/")
    public String getValue() {
        return "Index";
    }
    
    @GetMapping("/Detail/{walletName}")
   public String getDetail(@PathVariable("walletName") String walletName,
                           Model model) {
      
      model.addAttribute("joke_naam", jokeRepository.findByFirstNameAndLastName(firstName, lastName));

      return "List_Person";
   }
}