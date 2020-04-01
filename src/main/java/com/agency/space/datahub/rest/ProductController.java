package com.agency.space.datahub.rest;

import com.agency.space.datahub.model.Product;
import com.agency.space.datahub.service.ProductService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
        if (productId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product product = this.productService.getById(productId);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (product == null || product.getFootprint().size() != 4) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.productService.save(product);
        return new ResponseEntity<>(product, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody @Valid Product product) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (product == null || product.getFootprint().size() != 4) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.productService.save(product);
        return new ResponseEntity<>(product, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        Product product = this.productService.getById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = this.productService.getAll();

        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/findByMissionName/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findByMissionName(@PathVariable("name") String missionName) {

        if (missionName == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Product> products = this.productService.getByMissionName(missionName);

        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //make method accept date format without time
    @RequestMapping(value = "findByDateAfter/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findByDate(@PathVariable("date") String stringDate) {
        LocalDateTime date;

        if (stringDate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        date = LocalDateTime.parse(stringDate, formatter);
        List<Product> products = this.productService.getByDateAfter(date);

        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //make method accept date format without time
    @RequestMapping(value = "findByDateBefore/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findByDateBefore(@PathVariable("date") String stringDate) {
        LocalDateTime date;

        if (stringDate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        date = LocalDateTime.parse(stringDate, formatter);
        List<Product> products = this.productService.getByDateBefore(date);

        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //make method accept date format without time
    @RequestMapping(value = "findByDatesBetween/{from_date}/{to_date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findByDateBetween(@PathVariable("from_date") String stringFromDate,
                                                           @PathVariable("to_date") String stringToDate) {


        LocalDateTime fromDate;
        LocalDateTime toDate;

        if (stringFromDate == null || stringToDate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        fromDate = LocalDateTime.parse(stringFromDate, formatter);
        toDate = LocalDateTime.parse(stringToDate, formatter);

        List<Product> products = this.productService.getByDateBetween(fromDate, toDate);

        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/orderProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> orderProducts(@RequestParam List<Long> productsIds) {
        if (productsIds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Product> products = this.productService.orderProducts(productsIds);

        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
