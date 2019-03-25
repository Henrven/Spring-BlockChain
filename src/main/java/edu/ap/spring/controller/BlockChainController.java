package edu.ap.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.ap.spring.service.Wallet;
import edu.ap.spring.service.WalletRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@Scope("session")
public class BlockChainController{

    @Autowired
	private WalletRepository walletRepository;

    @GetMapping("/")
   public String list(Model model) {
      
      model.addAttribute("wallets", walletRepository.findAll());

	   return "strat";
   }
    
    @GetMapping("/Detail/{walletName}")
   public String getDetail(@PathVariable("walletName") String walletName,
                           Model model) {
      
      model.addAttribute("wallet_naam", walletRepository.findByName(walletName));

      return "mislukt";
   }

   @PostMapping("/new")
   @ResponseBody
    public String wallet_post(@RequestParam("walletName") String walletName,
                            @RequestParam("ammount") Long ammount) {

    walletRepository.save(new Wallet(walletName, ammount));

    return "add";
   }
   
   
   
}