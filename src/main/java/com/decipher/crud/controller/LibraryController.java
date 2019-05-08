package com.decipher.crud.controller;

import com.decipher.crud.model.ApiResponse;
import com.decipher.crud.model.Book;
import com.decipher.crud.model.ResponseStatus;
import com.decipher.crud.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ApiResponse list()
    {
        return libraryService.list();
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseStatus list(@RequestBody Book book)
    {
         return libraryService.update(book);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseStatus add(@RequestBody Book book)
    {
        return libraryService.add(book);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseStatus add(@RequestParam("id") int bookId)
    {
        return libraryService.delete(bookId);
    }
    @RequestMapping(value = "/findByName",method = RequestMethod.GET)
    public void joinTable(@RequestParam("name") String bookName)
    {
        libraryService.findByName(bookName);
    }
    @RequestMapping(value = "/join",method = RequestMethod.GET)
    public void joinTable()
    {
        libraryService.join();
    }
}
