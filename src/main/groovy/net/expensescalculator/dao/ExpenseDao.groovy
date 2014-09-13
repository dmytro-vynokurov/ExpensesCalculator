package net.expensescalculator.dao

import net.expensescalculator.entities.Expense
import org.joda.time.DateTime
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
@Repository
class ExpenseDao extends AbstractDao{

//    def peoplesFiltered(){
//        Expense examplePerson = new Expense(lastName: "cooper")
//        Example example = Example.create(examplePerson).ignoreCase().excludeProperty("creationDate")
//        session().createCriteria(Expense).add(example).list()
//    }

    def expenses(){
        session().createQuery("select e from Expense e").list()
    }

    def expenseById(long id){
        session().get(Expense.class,id)
    }
}
