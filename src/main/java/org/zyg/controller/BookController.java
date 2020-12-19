package org.zyg.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import org.zyg.service.BookService;
import org.zyg.domain.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController
{
    // 依赖注入bookService组件
    @Resource(name = "bookService")
    private BookService bookService;

    @GetMapping("/books")
    public void books(Model model)
    {
        // 调用BookService的方法来获取所有图书
        model.addAttribute("books", bookService.findAll());
    }
    @GetMapping("/bookForm")
    public void bookForm(Book book)
    {}
    @GetMapping("/updateForm")
    public void updateForm(Integer id, Model model)
    {
        model.addAttribute("book", bookService.findById(id));
    }

    @PostMapping("/addBook")
    public String addBook(@Validated Book book, BindingResult bindingResult,
                          RedirectAttributes attrs)
    {
        if (bindingResult.getErrorCount() > 0)
        {
            return "bookForm";
        }
        Integer id = bookService.saveBook(book);
        if (id > 0)
        {
            attrs.addFlashAttribute("tip", "图书添加成功");
            return "redirect:books";
        }
        else
        {
            attrs.addFlashAttribute("tip", "图书添加失败，请您重新添加");
            return "redirect:bookForm";
        }
    }

    @GetMapping("/deleteBook")
    public String deleteBook(Integer id, RedirectAttributes attrs)
    {
        Integer count = bookService.deleteBook(id);
        if (count > 0)
        {
            attrs.addFlashAttribute("tip", "图书删除成功");
        }
        else
        {
            attrs.addFlashAttribute("tip", "图书删除失败，请您重新尝试");
        }
        return "redirect:books";
    }
    @PostMapping("/updateBook")
    public String updateBook(@Validated Book book, BindingResult bindingResult,
                             RedirectAttributes attrs)
    {
        if (bindingResult.getErrorCount() > 0)
        {
            return "updateForm";
        }
        Integer count = bookService.updateBook(book);
        if (count > 0)
        {
            attrs.addFlashAttribute("tip", "图书修改成功");
            return "redirect:books";
        }
        else
        {
            attrs.addFlashAttribute("tip", "图书修改失败，请您重新尝试");
            return "updateForm";
        }
    }
    @PostMapping("/queryBook")
    public String findByName(String bookName, Model model) {
        Book book = bookService.findByName(bookName);
        List<Book> list = new ArrayList<>();
        list.add(book);
        if (book == null) {
            list = bookService.findAll();
            model.addAttribute("error", "未查到");
        }
        model.addAttribute("books", list);
        return "books";

    }

}
