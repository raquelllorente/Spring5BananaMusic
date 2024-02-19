package com.bananaapps.bananamusic.controller;

import com.bananaapps.bananamusic.domain.music.PurchaseOrderLineSong;
import com.bananaapps.bananamusic.service.music.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/shoppingCart")
@Validated
@CrossOrigin(origins = "http://localhost:8080")
public class ShoppingCartController {

    @Autowired
    ShoppingCart shoppingCart;

    @GetMapping("/balance")
    public ResponseEntity getBalance(){
        return ResponseEntity.status(HttpStatus.OK).body(shoppingCart.getBalance());
    }

    @PutMapping("")
    public ResponseEntity addItem(@RequestBody @Valid PurchaseOrderLineSong item){
        shoppingCart.addItem(item);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Item added");
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity removeItem(@PathVariable @Min(1) Long itemId) {
        shoppingCart.removeItem(itemId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Item removed");
    }

    @GetMapping("/itemCount")
    public ResponseEntity getItemCount(){
        return ResponseEntity.status(HttpStatus.OK).body(shoppingCart.getItemCount());
    }

    @DeleteMapping("/empty")
    public ResponseEntity empty(){
        shoppingCart.empty();
        return ResponseEntity.status(HttpStatus.OK).body("Emptied");
    }

    @PostMapping("/buy")
    public ResponseEntity buy(){
        shoppingCart.buy();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Buy complete");
    }
}