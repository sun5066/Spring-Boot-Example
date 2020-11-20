package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Qualifier("bookServiceV1")
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<BookVO> bookVOList = bookService.selectAll();
        model.addAttribute("BOOKS", bookVOList);
        return "book/list";
    }

    @GetMapping("/view")
    public String view(String id, Model model) {
        BookVO bookVO = bookService.findById(Long.valueOf(id));
        model.addAttribute("BOOK", bookVO);
        return "book/view";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id) {
        bookService.delete(Long.valueOf(id));
        return "redirect:/book/list";
    }
}
