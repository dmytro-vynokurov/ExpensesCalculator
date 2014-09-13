package net.expensescalculator.entities
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import groovy.transform.ToString
import net.expensescalculator.util.JacksonDateTimeSerializer
import org.hibernate.annotations.Type
import org.joda.time.DateTime

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@ToString(includeNames=true)
class Expense {
	@Id	@GeneratedValue
	long id
	
	String name
    Double amount

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using=JacksonDateTimeSerializer.class)
	DateTime date

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", date=" + date.toString("HH:mm:ss dd.MM.yyyy") +
                '}';
    }
}
