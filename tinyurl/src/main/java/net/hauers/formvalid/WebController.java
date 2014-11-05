package net.hauers.formvalid;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/results").setViewName("results");
  }

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String showForm(Person person) {
    return "form";
  }
  
  @ResponseBody
  public String showForm() {
    return "hello\n";
  }
}