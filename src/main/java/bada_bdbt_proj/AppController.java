package bada_bdbt_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AppController implements WebMvcConfigurer{

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("main_admin");
        registry.addViewController("/main_user").setViewName("main_user");
        registry.addViewController("/oferty").setViewName("oferty");
        registry.addViewController("/oferty_zalogowani").setViewName("user/oferty_zalogowani");
        registry.addViewController("/kontakt").setViewName("kontakt");
        registry.addViewController("/rejestracja").setViewName("rejestracja");
        registry.addViewController("/zapomniane_haslo").setViewName("zapomniane_haslo");
        registry.addViewController("/wiecej").setViewName("user/wiecej");
        registry.addViewController("/kontakt_zalogowany").setViewName("user/kontakt_zalogowany");
        //registry.addViewController("/admin_test").setViewName("admin_test");
        registry.addViewController("/admin_strona").setViewName("admin/admin_strona");
        registry.addViewController("/new_form").setViewName("admin/new_form");
        registry.addViewController("/edit_form").setViewName("admin/edit_form");
        registry.addViewController("/reserve").setViewName("user/reserve");

    }

    @Autowired
    private OfertaDAO dao;
    private KlienciDAO kao;


    //@RequestMapping(value={"/main_user"})
    //public String view(Model model1){
    //    List<Klienci> listKlienci = kao.list();
    //    model1.addAttribute("listKlienci",listKlienci);
    //    return "/main_user";
    //}


    @RequestMapping(value={"/oferty_zalogowani"})
    public String viewHomePage1(Model model){
        List<Oferta> listOferta = dao.list();
        model.addAttribute("listOferta",listOferta);
        return "user/oferty_zalogowani";
    }
    @RequestMapping(value={"/admin_strona"})
    public String viewHomePage(Model model){
        List<Oferta> listOferta = dao.list();
        model.addAttribute("listOferta",listOferta);
        return "admin/admin_strona";
    }
    @RequestMapping(value={"/new_form"})
    public String showNewForm(Model model){
        Oferta oferta = new Oferta();
        model.addAttribute("oferta",oferta);
        return "admin/new_form";
    }
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public String save(@ModelAttribute("oferta")Oferta oferta){
        dao.save(oferta);
        return "redirect:/admin_strona";
    }

    @RequestMapping(value={"/edit/{id_pojazdu}"})
    public ModelAndView showEditForm(@PathVariable(name="id_pojazdu") int id){
        ModelAndView mav = new ModelAndView("admin/edit_form");
        Oferta oferta = dao.get(id);
        mav.addObject("oferta",oferta);
        return mav;
    }
    @RequestMapping(value={"/reserve/{id_pojazdu}"})
    public ModelAndView showEditForm1(@PathVariable(name="id_pojazdu") int id){
        ModelAndView mav = new ModelAndView("user/reserve");
        Oferta oferta = dao.get(id);
        mav.addObject("oferta",oferta);
        return mav;
    }


    @RequestMapping(value="/update",method=RequestMethod.POST)
    public String update(@ModelAttribute("oferta")Oferta oferta){
        dao.update(oferta);
        return "redirect:/admin_strona";
    }
    @RequestMapping(value="/reserve",method=RequestMethod.POST)
    public String reserve(@ModelAttribute("oferta")Oferta oferta){

        return "redirect:/main_user";
    }
    @RequestMapping(value="/delete/{id_pojazdu}")
    public String delete(@PathVariable(name="id_pojazdu")int id){
        dao.delete(id);
        return "redirect:/admin_strona";
    }







        @Controller
        public class DashboardController {
            @RequestMapping("/main")
            public String defaultAfterLogin(HttpServletRequest request) {
                if (request.isUserInRole("ADMIN")) {
                    return "redirect:/main_admin";
                } else if (request.isUserInRole("USER")) {
                    return "redirect:/main_user";
                } else {
                    return "redirect:/index";
                }
            }
        }

        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }

        @RequestMapping(value = {"/main_user"})
        public String showUserPage(Model model) {
            return "user/main_user";
        }
    }

