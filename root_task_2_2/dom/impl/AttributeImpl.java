package root_task_2_2.dom.impl;

import root_task_2_2.dom.Attribute;
import root_task_2_2.dom.Element;

/**
 *
 */
class AttributeImpl extends NodeImpl implements Attribute {

    private String value;
    private boolean isId;

    protected AttributeImpl(String name, String value, boolean isId) {
        super.type = DomUtils.ATTRIBUTE;
        super.name = name;
        this.value = value;
        this.isId = isId;
    }

    public Element getOwnerElement(){
        return (Element) super.parent;
    }

    public String getValue(){
         return this.value;
    }

    public boolean	isId(){
         return this.isId;
    }

    public void	setValue(String value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        AttributeImpl attribute = (AttributeImpl) o;
        if (isId != attribute.isId) {
            return false;
        }
        return value != null ? value.equals(attribute.value) : attribute.value == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (isId ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AttributeImpl{" +
                "value='" + value + '\'' +
                ", isId='" + isId +
                '}';
    }
}
