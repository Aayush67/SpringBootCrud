package com.decipher.crud.service;

import com.decipher.crud.model.ApiResponse;
import com.decipher.crud.model.Book;
import com.decipher.crud.model.ResponseStatus;
import com.decipher.crud.repository.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepo libraryRepo;
    public ApiResponse list()
    {
        List<Book> bookList= libraryRepo.findAll();
        ApiResponse response=new ApiResponse();
        response.setResponseStatus(new ResponseStatus(1000,"Success"));
        response.setResponseData(bookList);
        return response;
    }
    public ResponseStatus update(Book book)
    {
        Optional<Book> optional=libraryRepo.findById(book.getSid());
        if(!optional.isPresent())
            return (new ResponseStatus(400,"Book Id Not Found"));
        Book bookData=optional.get();
        bookData.setName(book.getName());
        bookData.setStatus(book.getStatus());
        libraryRepo.save(bookData);
        return (new ResponseStatus(1000,"Success"));
//        bookData.ifPresent(data->{
//            data.setName(book.getName());
//            data.setStatus(book.getStatus());
//            libraryRepo.save(data);
//            System.out.println(data.getName() + " "+data.getStatus());
//        });
    }
    public ResponseStatus add(Book book)
    {
        libraryRepo.save(book);
        return (new ResponseStatus(1000,"Success"));
    }
    public ResponseStatus delete(int bookId)
    {
       /* Request URL
        http://localhost:8080/delete?id=2*/
        try {
            libraryRepo.deleteById(bookId);
            return (new ResponseStatus(1000, "Success"));
        }
        catch (Exception e)
        {
            return (new ResponseStatus(400, "Book Id Doesn't Exist"));
        }
    }
    public void findByName(String bookName)
    {
        List<Book> bookList= libraryRepo.findAllByName(bookName);
        for(Book book: bookList)
                System.out.println(book.getName());
    }

    public void join()
    {
//        List<Book> bookList= libraryRepo.findAllByName(bookName);
//        for(Book book: bookList)
//            System.out.println(book.getName());
           List<Book> bookList=libraryRepo.findAll();
    }
}
