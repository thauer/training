package net.hauers.formvalid;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
public class WebController extends WebMvcConfigurerAdapter {
    
  @RequestMapping("**")
  @ResponseBody
  public String showForm() {
    return "hello\n";
  }
}