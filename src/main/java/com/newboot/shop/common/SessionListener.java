package com.newboot.shop.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        logger.debug("SessionListenerCreated:"+event.getSession().getAttribute("user"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.debug("SessionListenerDestroyed:"+event.getSession().getAttribute("user"));
        if("".equals(event.getSession().getAttribute("user"))||event.getSession().getAttribute("user")==null){
            return;
        }
        else {
            HttpSession session = event.getSession();
//            LastTime lastTime = new LastTime(session);
//            lastTime.update();
        }

    }
}
