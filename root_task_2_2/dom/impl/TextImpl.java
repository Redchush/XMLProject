package root_task_2_2.dom.impl;

/**
 * Created by user on 03.06.2016.
 */
class TextImpl extends NodeImpl implements root_task_2_2.dom.Text {

    private String wholeText;

    protected TextImpl(String content) {
        super.type = DomUtils.TEXT;
        this.setWholeText(content);
    }

    @Override
    public String getWholeText() {
        return wholeText;
    }

    @Override
    public void setWholeText(String wholeText) {
        this.wholeText = wholeText;
    }

    @Override
    public boolean isElementContentWhitespace(){
        return getWholeText().contains(" ");
    }


    @Override
    public String toString() {
        return "TextImpl{" +
                "wholeText='" + wholeText + '\'' +
                '}';
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
        TextImpl text = (TextImpl) o;
        return wholeText != null ? wholeText.equals(text.wholeText) : text.wholeText == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wholeText != null ? wholeText.hashCode() : 0);
        return result;
    }
}
