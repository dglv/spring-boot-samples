package ru.dglv.business.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "person")
@Entity
public class Person extends AbstractBaseEntity 
{
    private static final long serialVersionUID = 1L;

    @Column(name = "guid", unique=true, nullable = false)
    private String guid;

    @Column(name = "username", unique=true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    public Person()
    {
        this.guid = UUID.randomUUID().toString();
    }
    
    public Person(final String username, final String password, final String name, final Integer age)
    {
        this.guid = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId()
    {
        return id;
    }

    public void setId(final long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getGuid()
    {
        return guid;
    }
    
    public void setGuid(final String guid)
    {
        this.guid = guid;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(final Integer age)
    {
        this.age = age;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((guid == null) ? 0 : guid.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (guid == null)
        {
            if (other.guid != null)
                return false;
        } else if (!guid.equals(other.guid))
            return false;
        if (username == null)
        {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
    
    @Override
    public String toString()
    {
        return "Person[id:" + id + ", username:" + username + 
                ", password:" + password + ", name:" + name + 
                ", age:" + age + ", guid:" + guid + "]";
    }
}
