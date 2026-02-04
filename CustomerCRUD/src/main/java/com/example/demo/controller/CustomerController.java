package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins="*")

public class CustomerController {

	@Autowired
	private CustomerService cs;
	
	//aefwerf efwefwefe
	@GetMapping("/")
	public String getMethodName(){
		return "Hii";
	}
	
	@PostMapping("add")
	public void add(@RequestBody Customer c) {
		cs.add(c);
//		book
	}

	@PostMapping("add all")
	public void addAll(@RequestBody List<Customer> list) {
		cs.addAll(list);
	}

	@GetMapping("/display")
	public List<Customer> display() {
		return cs.display();
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Customer temp = cs.delete(id);
		if (temp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found !!");
		}
		return ResponseEntity.ok(temp);
	}

	@PostMapping("search/{id}")
	public ResponseEntity<?> search(@PathVariable Integer id) {
		Customer temp = cs.search(id);
		if (temp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found !!");
		}
		return ResponseEntity.ok(temp);
	}

	@PutMapping("update/{id}")
	public void update(@PathVariable Integer id, Customer c) {
		cs.update(c, id);
	}

	@PostMapping("search/mob/{mob}")
	public Customer searchMob(@PathVariable String mob) {

		return cs.findByMob(mob);
	}

	@PostMapping("search/name/{name}")
	public List<Customer> searchName(@PathVariable String name){
		return cs.findByName(name);
	}
	
	@PostMapping("search/address/{address}")
	public List<Customer> searchAddress(@PathVariable String address){
		return cs.findByAddress(address);
	}
}
