package df.ormtemplate.domain
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PeopleController {
    @Autowired
    PersonDao dao

    @RequestMapping("/peoples")
    List<Person> getPeoples(){
        dao.peoples()
    }

    @RequestMapping("/person?id={id}")
    Person getPersonById(@RequestParam("id") int id){
        dao.personById(id)
    }
}
