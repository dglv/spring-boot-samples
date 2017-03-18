package ru.dglv.restapp.business.model;


public class Person
{
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    
    public Person(final Long id, final String firstName, 
            final String lastName, final Integer age)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(final Long id)
    {
        this.id = id;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
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
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (id == null)
        {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
