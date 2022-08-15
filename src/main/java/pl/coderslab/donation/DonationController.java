package pl.coderslab.donation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.category.CategoryRepository;
import pl.coderslab.institution.InstitutionRepository;

@Controller
@SessionAttributes("newDonation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    public DonationController(CategoryRepository categoryRepository, DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String addDonation(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        return "/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String saveSession(Model model, @ModelAttribute("donation") Donation donation) {
        model.addAttribute("newDonation", donation);
        return "redirect:/formSummary";
    }

    @RequestMapping(value = "/formSummary", method = RequestMethod.GET)
    public String summary(Model model, @SessionAttribute("newDonation") Donation donation) {
        model.addAttribute("donation", donation);
        return "/formSummary";
    }

    @RequestMapping(value = "/formSummary", method = RequestMethod.POST)
    public String saveDonation(Model model, @SessionAttribute("newDonation") Donation donation) {
        donationRepository.save(donation);
        return "/formConfirmation";
    }


}
