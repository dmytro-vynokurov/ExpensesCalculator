package net.expensescalculator.controllers

import net.expensescalculator.dao.BackfillDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BackfillController {
    public static final String EXPENSES_PAGE = "<a href='http://localhost:8080/expenses'>Expenses</a>"

    @Autowired
    BackfillDao dao

    @RequestMapping("/backfill_expenses")
    String prepare(){
        dao.backfillExpenses()
        return EXPENSES_PAGE
    }
}
