package com.decipher.crud.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class ApiResponse {
    private ResponseStatus responseStatus;
    private List<Book> responseData;
}
