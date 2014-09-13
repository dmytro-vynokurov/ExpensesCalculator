package net.expensescalculator.dao

import net.expensescalculator.entities.Expense
import org.joda.time.DateTime
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
@Repository
class BackfillDao extends AbstractDao{

    def backfillExpenses(){
        session().saveOrUpdate(new Expense(name: "KFC", amount: 40.6, date: DateTime.parse("2014-09-06T11:33+02:00")))
        session().saveOrUpdate(new Expense(name: "MacBook", amount: 32000, date: DateTime.parse("2014-09-16T11:33:56+02:00")))
    }
}
