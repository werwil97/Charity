package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.donation.DonationRepository;
import pl.coderslab.institution.InstitutionRepository;

@Controller
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("countDonations", donationRepository.count());
        model.addAttribute("countBags",donationRepository.quantityOfBags());
        return "index";
    }

//    @RequestMapping(value = "/form", method = RequestMethod.GET)
//    public String form(Model model) {
//        return "/form";
//    }
}
