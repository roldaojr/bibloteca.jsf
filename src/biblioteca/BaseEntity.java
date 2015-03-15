package biblioteca;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public abstract Long getId();

	public abstract void setId(Long id);

    @Override
    public int hashCode() {
        return (getId() != null) ? (getClass().hashCode() + getId().hashCode()) : super.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return (other != null && getClass() == other.getClass() && getId() != null) ? getId().equals(((BaseEntity) other).getId()) : (other == this);
    }
    
    @Override
    public String toString() {
        return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
    }    
}
