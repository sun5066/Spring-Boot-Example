package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Qualifier("bookServiceV1")
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String getList(@PageableDefault Pageable pageable, Model model) {
        Page<BookVO> bookVOList = bookService.pageSelect(pageable);
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

    @GetMapping("/insert")
    public String insert(@ModelAttribute BookVO bookVO, Model model) {
        model.addAttribute("BOOK", bookVO);
        return "book/input";
    }

    @PostMapping("/insert")
    public String insert(@ModelAttribute BookVO bookVO) {
        log.debug("------------------------ {}", bookVO);
        bookService.insert(bookVO);
        return "redirect:/book/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable String id, Model model) {
        BookVO bookVO = bookService.findById(Long.valueOf(id));
        model.addAttribute("BOOK", bookVO);
        return "book/input";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BookVO bookVO, Model model) {
        bookService.update(bookVO);
        model.addAttribute("id", bookVO.getId());
        return "/book/view/" + bookVO.getId();
    }
}
