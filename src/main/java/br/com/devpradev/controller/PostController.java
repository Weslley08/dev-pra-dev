package br.com.devpradev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

import br.com.devpradev.models.entity.Post;
import br.com.devpradev.service.PostService;

@Controller
public class PostController {
    
    @Autowired
    PostService postService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/posts", method=RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = postService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = postService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value="/newpost", method=RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping(value="/newpost", method=RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        postService.save(post);
        return "redirect:/posts";
    }
}
