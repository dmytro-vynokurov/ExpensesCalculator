package net.expensescalculator.controllers.util

import net.expensescalculator.dao.BackfillDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/backfill")
class BackfillController {
    @Autowired
    BackfillDao dao

    @RequestMapping("/expenses")
    String prepare(){
        dao.backfillExpenses()
        return "Expenses backfilled"
    }
}
