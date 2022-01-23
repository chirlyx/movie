package com.epam.movie.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalTime;

public class TimeTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            LocalTime time = LocalTime.now();
            out.print(time.getHour());
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

}