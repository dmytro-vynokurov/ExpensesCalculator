package net.expensescalculator.controllers.rest
import net.expensescalculator.dao.ExpenseDao
import net.expensescalculator.entities.Expense
import net.expensescalculator.util.StringToDateTimeConverter
import org.joda.time.DateTime
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.ServletRequestDataBinder
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest
import java.beans.PropertyEditorSupport

@RestController
@RequestMapping("/rest")
class ExpenseController {
    @Autowired
    ExpenseDao dao

    @Autowired
    StringToDateTimeConverter timeConverter

    @InitBinder
    private void initBinder(HttpServletRequest request, ServletRequestDataBinder binder){
        binder.registerCustomEditor(DateTime.class,new PropertyEditorSupport(){
            @Override
            public void setAsText(String text){
                DateTime dateTime = timeConverter.convert(text)
                setValue(dateTime)
            }
        })
    }


    @RequestMapping(value = "/expenses",method = RequestMethod.GET)
    List<Expense> getExpenses(){
        dao.expenses()
    }

    @RequestMapping(value = "/expense",method = RequestMethod.GET)
    Expense getExpenseById(@RequestParam("id") long id){
        dao.expenseById(id)
    }

    @RequestMapping(value = "/expense",method=RequestMethod.POST)
    void addExpense(@RequestParam("name") String name,
                    @RequestParam("amount") double amount,
                    @RequestParam("date") DateTime date){
        Expense expense = new Expense(name: name,amount: amount,date: date)
        dao.addExpense(expense)
    }
}
