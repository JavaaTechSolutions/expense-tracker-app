package com.jts.expensetracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jts.expensetracker.dto.ExpenseDto;
import com.jts.expensetracker.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {

	private final ExpenseService expenseService;

	@PostMapping
	public ResponseEntity<String> addExpense(@RequestBody ExpenseDto expenseDto) {
		Long expenseId = expenseService.addExpense(expenseDto);
		return ResponseEntity.ok("Expense created with id:" + expenseId);
	}

	@PutMapping
	public void updateExpense(@RequestBody ExpenseDto expense) {
		expenseService.updateExpense(expense);
	}

	@GetMapping
	public List<ExpenseDto> getAllExpenses() {
		return expenseService.getAllExpenses();
	}

	@GetMapping("/{id}")
	public ExpenseDto getExpense(@PathVariable Long id) {
		return expenseService.getExpense(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "Success";
    }

}
