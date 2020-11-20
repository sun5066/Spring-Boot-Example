package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {

    @Qualifier(value = "bookServiceV1")
    private final BookService bookService;

    public HelloController(BookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String hello() {
        return "Hi";
    }

    //    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("username", "홍길동");
        model.addAttribute("tel", "010-111-1111");
        return "home";
    }

}
