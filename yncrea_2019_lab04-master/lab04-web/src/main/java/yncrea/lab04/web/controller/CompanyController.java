package yncrea.lab04.web.controller;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yncrea.lab04.core.entity.Company;
import yncrea.lab04.core.service.CompanyService;

import javax.inject.Inject;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/list")
    public String getListOfCompanies(ModelMap modelMap){
        List<Company> companies = companyService.findAllWithProjects();
        modelMap.addAttribute("companies", companies);
        return "companiesList";
    }
    @RequestMapping(value = "/form")
    public String getForm(ModelMap modelMap){
        Company company = new Company();
        modelMap.put("company", company);
        return "companyForm";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("company") Company company){
        companyService.save(company);
        return "redirect:list";
    }

    @RequestMapping(path = "{id}/delete")
    public String deleteCompany(@PathVariable Long id){
        companyService.deleteById(id);
        return "redirect:/list";
    }
}
