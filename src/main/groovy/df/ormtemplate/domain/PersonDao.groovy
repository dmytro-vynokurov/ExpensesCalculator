package df.ormtemplate.domain

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.criterion.Example
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Transactional
@Repository
class PersonDao {
    @Autowired
    private SessionFactory sessionFactory

    def peoplesFiltered(){
        Person examplePerson = new Person(lastName: "cooper")
        Example example = Example.create(examplePerson).ignoreCase().excludeProperty("creationDate")
        sessionFactory.getCurrentSession().createCriteria(Person).add(example).list()
    }

    def peoples(){
        Session session = sessionFactory.getCurrentSession()

        session.saveOrUpdate(new Person(firstName: "Leonard", lastName: "Hofstadter"))
        session.saveOrUpdate(new Person(firstName: "Sheldon", lastName: "Cooper"))
        session.saveOrUpdate(new Person(firstName: "Howard", lastName: "Wolowitz"))
        session.saveOrUpdate(new Person(firstName: "Rajesh", lastName: "Koothrappali"))


        session.createQuery("from Person").list()
    }
}
