package ru.dglv.business.model;

import java.io.Serializable;

public abstract class AbstractBaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    protected long id;

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractBaseEntity other = (AbstractBaseEntity) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
