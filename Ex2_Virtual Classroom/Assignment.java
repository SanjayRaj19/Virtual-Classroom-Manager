package edu.virtualclassroom;

import java.util.logging.Logger;

public class Assignment {
    private static final Logger logger = Logger.getLogger(Assignment.class.getName());

    private String details;

    public Assignment(String details) {
        if (details == null || details.isEmpty()) {
            throw new IllegalArgumentException("Assignment details cannot be null or empty");
        }
        this.details = details;
        logger.info("Created assignment with details: " + details);
    }

    public String getDetails() {
        return details;
    }
}