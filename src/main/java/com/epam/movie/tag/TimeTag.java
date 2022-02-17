package com.epam.movie.tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalTime;

public class TimeTag extends TagSupport {
    private static final Logger LOG = LoggerFactory.getLogger(TimeTag.class);

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            LocalTime time = LocalTime.now();
            out.print(time.getHour());
        } catch (IOException e) {
            LOG.debug(e.getMessage(), e);
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

}