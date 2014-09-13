package net.expensescalculator.controllers

import net.expensescalculator.dao.ExpenseDao
import net.expensescalculator.entities.Expense
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class ExpenseController {
    @Autowired
    ExpenseDao dao


    @RequestMapping("/expenses")
    List<Expense> getExpenses(){
        dao.expenses()
    }

    @RequestMapping("/expense")
    Expense getExpenseById(@RequestParam("id") long id){
        dao.expenseById(id)
    }
}
