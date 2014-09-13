package net.expensescalculator.dao

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class AbstractDao {
    @Autowired
    private SessionFactory sessionFactory

    protected Session session(){
        sessionFactory.getCurrentSession()
    }
}
